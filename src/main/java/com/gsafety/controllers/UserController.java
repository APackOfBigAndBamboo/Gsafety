package com.gsafety.controllers;

import com.gsafety.Utils.PersonDBUtil;
import com.gsafety.Utils.SendResetPasswordMail;
import com.gsafety.mappers.DeployMapper;
import com.gsafety.mappers.UserMapper;
import com.gsafety.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("user")
@SessionAttributes("account")
public class UserController {
    @Autowired
    UserMapper userMapper;

    @Autowired
    DeployMapper deployMapper;

    //获取用户列表，含模糊查询，分页
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String getUserList(ModelMap model,
                              @RequestParam(required = false) String searchText,
                              @RequestParam(required = false, defaultValue = "0") int offset,
                              @RequestParam(required = false, defaultValue = "10") int limit) {
        List<User> users = userMapper.getUsersAll(searchText, offset, limit);
        List<User> users1 = userMapper.getUsersAllPage(searchText);
        int totalPages = (users1.size() + limit-1) / limit;
        int pageNum=(offset+limit+1)/limit;
        System.out.println(totalPages);
        model.addAttribute("pageNum",pageNum);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("offset", offset);
        model.addAttribute("limit", limit);
        model.addAttribute("users", users);
        return "user/list_admin";
    }

    //配置用户可查看系统权限
    @RequestMapping(value = "editaccesscontrol", method = RequestMethod.GET)
    public String editAccessControl(ModelMap model, @RequestParam(required = false) Integer id,
                                    @RequestParam(required = false) String searchText,
                                    @RequestParam(required = false, defaultValue = "0") int offset,
                                    @RequestParam(required = false, defaultValue = "10") int limit) {
        User user = userMapper.getUserById(id);
        List<Deploy> deploys = deployMapper.getDeployAllAccessControl(searchText, offset, limit);
        System.out.println("deploys"+deploys.size());
        List<Deploy> deploysNum=deployMapper.getDeployPage(searchText);
        int totalPages = (deploysNum.size() + limit-1) / limit;
        int pageNum=(offset+limit+1)/limit;
        System.out.println(totalPages);
        model.addAttribute("pageNum",pageNum);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("offset", offset);
        model.addAttribute("limit", limit);
        model.addAttribute("deploys", deploys);
        model.addAttribute("user", user);
        return "user/edit_access_control";
    }

    //配置用户可查看系统权限
    @RequestMapping(value = "editaccesscontroller", method = RequestMethod.GET)
    public String editAccessControl(ModelMap model, @RequestParam(required = false) Integer id,
                                    @RequestParam(required = false) String access,
                                    @RequestParam(required = false) String searchText,
                                    @RequestParam(required = false, defaultValue = "0") int offset,
                                    @RequestParam(required = false, defaultValue = "10") int limit) {
        User user = userMapper.getUserById(id);
        String accessControl = user.getAccessControl();
        if (!access.equals(null)) {
            if (accessControl.contains(access)) {
                System.out.println(accessControl.replace(access + ",", ""));
                accessControl = accessControl.replace(access + ",", "");
            } else {
                accessControl = accessControl + access + ",";
            }
        }
        user.setAccessControl(accessControl);
        userMapper.updateUserAccessControl(user);
        List<Deploy> deploys = deployMapper.getDeployAllAccessControl(searchText, offset, limit);
        List<Deploy> deploysNum=deployMapper.getDeployPage(searchText);
        int totalPages = (deploysNum.size() +limit- 1) / limit;
        int pageNum=(offset+limit+1)/limit;
        System.out.println(totalPages);
        model.addAttribute("pageNum",pageNum);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("offset", offset);
        model.addAttribute("limit", limit);
        model.addAttribute("deploys", deploys);
        model.addAttribute("user", user);
        return "user/edit_access_control";
    }


    //从CRM中间库同步人员信息到统一演示中心数据库中
    @RequestMapping(value = "sync", method = RequestMethod.GET)
    public String sync(ModelMap model,
                       @RequestParam(required = false) String searchText,
                       @RequestParam(required = false, defaultValue = "0") int offset,
                       @RequestParam(required = false, defaultValue = "10") int limit) {
        List<Person> personList = PersonDBUtil.getAllpersonFromU8CRm();
//        userMapper.insertAllPerson(personList);
//        for (Person person : personList) {
//            userMapper.insertPerson(person);
//        }
        List<Person> personListNeed = userMapper.newPersonNeedtoInsert();
        for (Person personneed:personListNeed){
            User userInsert = new User();
                    userInsert.setEmail(personneed.getcEmail());
                    userInsert.setDepartment(personneed.getcDepartment());
                    userInsert.setName(personneed.getcName());
                    userInsert.setMobile(personneed.getCmobile());
                    userInsert.setPassword("123456");
                    userInsert.setAccountStatus("禁用");
                    userInsert.setAccountType("普通用户");
                    userMapper.insertUser(userInsert);
        }
        List<User> userNeedForbidden=userMapper.oldUserNeedToForbidden();
        for (User userneedFor:userNeedForbidden){
            User userxiugai = new User();
                    userxiugai.setId(userneedFor.getId());
                    userxiugai.setAccountStatus("禁用");
                    userMapper.updateUsers(userxiugai);
        }
        List<Person> peopleNeedUpdated=userMapper.userNeedUpdated();
        for (Person peopleNeedUp:peopleNeedUpdated){
            User userUpdate = new User();
                    userUpdate.setId(userMapper.getUserByEmail(peopleNeedUp.getcEmail()).getId());
                    userUpdate.setEmail(peopleNeedUp.getcEmail());
                    userUpdate.setDepartment(peopleNeedUp.getcDepartment());
                    userUpdate.setName(peopleNeedUp.getcName());
                    userUpdate.setMobile(peopleNeedUp.getCmobile());
                    userMapper.updateUserFromCRm(userUpdate);
        }
//        userMapper.deleteAllPerson();
        List<User> users = userMapper.getUsersAll(searchText, offset, limit);
        model.addAttribute("offset", offset);
        model.addAttribute("limit", limit);
        model.addAttribute("users", users);
        return "user/list_admin";
    }

    //当前登录用户个人信息
    @RequestMapping(value = "info", method = RequestMethod.GET)
    public String getInfo(ModelMap model, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        model.addAttribute("user", user);
        if (!("系统管理员".equals(user.getAccountType()))) {
            return "user/info_user";
        }
        return "user/info_admin";
    }

    @RequestMapping(value = "info", method = RequestMethod.POST)
    public String postInfo(ModelMap model,
                           User user) {
        userMapper.updateUser(user);
        model.addAttribute("user", user);
        return "redirect:/user/info";
    }


    //编辑用户
    @RequestMapping(value = "edit", method = RequestMethod.GET)
    public String getEdit(ModelMap model,
                          Integer id) {
        User user = userMapper.getUserById(id);
        model.addAttribute("user", user);
        return "user/edit_admin";
    }

    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public String postEdit(ModelMap model,
                           User user) {
        userMapper.updateUser(user);
        model.addAttribute("user", user);
        return "user/edit_admin";
    }

    //重置密码
    @RequestMapping(value = "resetpassword", method = RequestMethod.GET)
    public String getPassword(ModelMap model,
                              @RequestParam(required = false) Integer id) {
        User user = userMapper.getUserById(id);
        model.addAttribute("user", user);
        return "user/resetpassword";
    }

    @RequestMapping(value = "resetpassword", method = RequestMethod.POST)
    public String postPassword(ModelMap model,
                               @RequestParam(required = false) Integer id) throws Exception {
        User user = userMapper.getUserById(id);
        user.setId(id);
        user.setPassword("123456");
        userMapper.resetPassword(user);
        SendResetPasswordMail.Sendmail(user.getEmail(), user.getName());//发送重置密码通知邮件
        model.addAttribute("user", user);
        return "redirect:/user/edit?id=" + id;
    }

    //修改密码
    @RequestMapping(value = "changepassword", method = RequestMethod.GET)
    public String changePassword(ModelMap model, HttpServletRequest request) {
        UserPassword userPassword = new UserPassword();
        model.addAttribute("userPassword", userPassword);
        User user = (User) request.getSession().getAttribute("user");
        if (!("系统管理员".equals(user.getAccountType()))) {
            return "user/change_password_user";
        }
        return "user/change_password_admin";
    }

    @RequestMapping(value = "changepassword", method = RequestMethod.POST)
    public String postChanggePassword(ModelMap model,
                                      @RequestParam(required = false) Integer id,
                                      UserPassword userPassword,
                                      HttpServletRequest request) {
        User user = userMapper.getUserById(id);
        User users = (User) request.getSession().getAttribute("user");
        if (!user.getPassword().equals(userPassword.getOldPassword())) {
            model.addAttribute("defeat", "原密码输入错误！");
            if (!("系统管理员".equals(users.getAccountType()))) {
                model.addAttribute("defeat", "原密码输入错误！");
                return "user/change_password_user";
            }
            return "user/change_password_admin";
        }
        if (!userPassword.getNewPassword().equals(userPassword.getConfirmPassword())) {
            model.addAttribute("defeat1", "新密码输入不一致！请重新输入。！");
            if (!("系统管理员".equals(users.getAccountType()))) {
                model.addAttribute("defeat1", "新密码输入不一致！请重新输入。！");
                return "user/change_password_user";
            }
            return "user/change_password_admin";
        }
        user.setPassword(userPassword.getNewPassword());
        userMapper.updateUserPassword(user);
        model.addAttribute("success", "密码修改成功");
        if (!("系统管理员".equals(users.getAccountType()))) {
            return "user/change_password_user";
        }
        return "user/change_password_admin";
    }


//    //删除用户
//    @RequestMapping(value = "delete", method = RequestMethod.GET)
//    public String deleteUserByAccount(@RequestParam String account) {
//        userMapper.deleteUserByAccount(account);
//        return "redirect:/user/list";
//    }
//
//    //新建用户
//    @RequestMapping(value = "create", method = RequestMethod.GET)
//    public String getCreate(ModelMap model) {
//        User user = new User();
//        model.addAttribute("user", user);
//        return "user/create";
//    }
//
//    @RequestMapping(value = "create", method = RequestMethod.POST)
//    public String postCreate(ModelMap model, User user) {
//        String email = user.getEmail();
//        User sameEmailUser = userMapper.getUserByEmail(email);
//        if (sameEmailUser != null) {
//            return "user/create";
//        }
//        userMapper.insertUser(user);
//        return "redirect:/user/list";
//    }



    //
//    @RequestMapping(value = "editaccesscontrol", method = RequestMethod.POST)
//    public String editAccessControlPost(User user, ModelMap model) {
//        userMapper.updateUserAccessControl(user);
//        model.addAttribute("user", user);
//        model.addAttribute("success", "权限修改成功");
//        return "redirect:/user/editaccesscontrol?id=" + user.getId();
//    }




    //        for (Person o : personList) {
//            if (o.getPemail() != null) {
//                //如果统一演示中心数据库中没有此邮箱（CRM中间库中的邮箱）就新建一个插入到统一演示中心数据库中
//                if ((userMapper.getUserByEmail(o.getPemail())) == null) {
//                    User user = new User();
//                    user.setEmail(o.getPemail());
//                    user.setDepartment(o.getPdepartment());
//                    user.setName(o.getPersonname());
//                    user.setMobile(o.getPmobile());
//                    user.setPassword("123456");
//                    user.setAccountStatus("禁用");
//                    user.setAccountType("普通用户");
//                    userMapper.insertUser(user);
//                }
//                //如果同一邮箱在统一演示中心数据库和CRM中间库中所属部门、联系方式、姓名有不同的就更新到统一演示中心数据库中，以CRM中间库为准
//                User tjuser = userMapper.getUserByEmail(o.getPemail());//定义临时查找条件tjuser
//                if ((!o.getPmobile().equals(tjuser.getMobile())) || (!o.getPersonname().equals(tjuser.getName())) || (!o.getPdepartment().equals(tjuser.getDepartment()))) {
//                    User user = new User();
//                    user.setId(userMapper.getUserByEmail(o.getPemail()).getId());
//                    user.setEmail(o.getPemail());
//                    user.setDepartment(o.getPdepartment());
//                    user.setName(o.getPersonname());
//                    user.setMobile(o.getPmobile());
//                    userMapper.updateUserFromCRm(user);
//                }
//            }
//        }
    //查询统一演示中心数据库中所有不在U8CRM数据库中的用户，并把其状态设置为禁用。
//        List<User> userList = userMapper.getAllUsersEver();
//        for (User user : userList) {
//            if (user.getEmail() != null) {
//                if ((PersonDBUtil.getPersonFromU8CRmByEmail(user.getEmail())) != 1) {
//                    User userxiugai = new User();
//                    userxiugai.setId(user.getId());
//                    userxiugai.setAccountStatus("禁用");
//                    userMapper.updateUsers(userxiugai);
//                }
//            }
//        }
}

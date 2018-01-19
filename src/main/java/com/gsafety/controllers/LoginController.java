package com.gsafety.controllers;

import com.gsafety.Utils.ConnectToDeployDbByName;
import com.gsafety.mappers.DeployMapper;
import com.gsafety.mappers.UserMapper;
import com.gsafety.models.Deploy;
import com.gsafety.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class LoginController {
    @Autowired
    UserMapper userMapper;
    @Autowired
    DeployMapper deployMapper;

    //登陆系统
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(ModelMap model,
                        @RequestParam String email,
                        @RequestParam(required = false) String searchText,
                        @RequestParam(required = false, defaultValue = "0") int offset,
                        @RequestParam(required = false, defaultValue = "10") int limit,
                        @RequestParam String password, HttpServletRequest request,
                        HttpServletResponse response) {
        User user = null;
        user = userMapper.getUserByEmail(email);
        if (null == user) {
            model.addAttribute("fail", "账号不存在！");
            return "user/login";
        }
        if (!user.getPassword().equals(password)) {
            model.addAttribute("fail", "密码错误，请重新输入！");
            return "user/login";
        }
        if (user.getAccountStatus().equals("禁用")){
            model.addAttribute("fail", "当前账号不可用，请联系系统管理员！");
            return "user/login";
        }
        String accessControlArr = user.getAccessControl();
        if(accessControlArr==null){
            accessControlArr="1";
        }
        List<Deploy> deploys = deployMapper.getDeploysAllByAccessControl(searchText, offset, limit, accessControlArr);
        List<Map> maps = new ArrayList<>();
        for (Deploy deploy : deploys) {
            maps.add(ConnectToDeployDbByName.getDetailByname(deploy.getSystemName()));
        }
        List<Deploy> deploysNum=deployMapper.getDeploysAllByAccessControlPage(searchText,accessControlArr);
        int totalPages = (deploysNum.size() + limit-1) / limit;
        int pageNum=(offset+limit+1)/limit;

        model.addAttribute("pageNum",pageNum);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("offset", offset);
        model.addAttribute("limit", limit);
        model.addAttribute("deploys", deploys);
        model.addAttribute("maps", maps);
        request.getSession(true).setAttribute("user", user);
        if (!("系统管理员".equals(user.getAccountType()))) {

            return "deploy/list_user";
        }
        return "deploy/list_admin";

    }
}

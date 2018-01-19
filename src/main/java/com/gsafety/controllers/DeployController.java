package com.gsafety.controllers;

import com.alibaba.fastjson.JSONArray;
import com.gsafety.Utils.ConnectToDeployDbByName;
import com.gsafety.Utils.ConnectToImage;
import com.gsafety.Utils.FIleTooByte;
import com.gsafety.mappers.DeployMapper;
import com.gsafety.mappers.MasterMapper;
import com.gsafety.mappers.TestMapper;
import com.gsafety.models.Deploy;
import com.gsafety.models.Test;
import com.gsafety.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.*;
import java.util.jar.JarEntry;

@Controller
@RequestMapping(value = "deploy")
public class DeployController {
    @Autowired
    MasterMapper masterMapper;
    @Autowired
    DeployMapper deployMapper;

    //获取系统列表，含模糊查询，分页
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String geMasterList(ModelMap model,
                               @RequestParam(required = false) String searchText,
                               @RequestParam(required = false, defaultValue = "0") int offset,
                               @RequestParam(required = false, defaultValue = "10") int limit,
                               HttpServletRequest request) {

        User user = (User) request.getSession(true).getAttribute("user");
        String accessControlArr = user.getAccessControl();
        if (accessControlArr == null) {
            accessControlArr = "1";
        }
        List<Deploy> deploys = deployMapper.getDeploysAllByAccessControl(searchText, offset, limit, accessControlArr);
        List<Map> maps = new ArrayList<>();
        for (Deploy deploy : deploys) {
            maps.add(ConnectToDeployDbByName.getDetailByname(deploy.getSystemName()));
        }
        List<Deploy> deploysNum = deployMapper.getDeploysAllByAccessControlPage(searchText, accessControlArr);
        int totalPages = (deploysNum.size() + limit - 1) / limit;
        int pageNum = (offset + limit + 1) / limit;

        model.addAttribute("pageNum", pageNum);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("offset", offset);
        model.addAttribute("limit", limit);
        model.addAttribute("maps", maps);
        if (!("系统管理员".equals(user.getAccountType()))) {
            return "deploy/list_user";
        }
        return "deploy/list_admin";
    }

//    //获取系统列表，含模糊查询，分页
//    @RequestMapping(value = "list", method = RequestMethod.GET)
//    public String geMasterList(ModelMap model,
//                               @RequestParam(required = false) String searchText,
//                               @RequestParam(required = false, defaultValue = "0") int offset,
//                               @RequestParam(required = false, defaultValue = "10") int limit,
//                               HttpServletRequest request) {
//
//        User user = (User) request.getSession(true).getAttribute("user");
//        String accessControlArr = user.getAccessControl();
//        if(accessControlArr==null){
//            accessControlArr="1";
//        }
//        List<Deploy> deploys = deployMapper.getDeploysAllByAccessControl(searchText, offset, limit, accessControlArr);
//        List<Deploy> deploysNum=deployMapper.getDeploysAllByAccessControlPage(searchText,accessControlArr);
//        int totalPages = (deploysNum.size() + limit-1) / limit;
//        int pageNum=(offset+limit+1)/limit;
//        System.out.println(totalPages);
//        model.addAttribute("pageNum",pageNum);
//        model.addAttribute("totalPages", totalPages);
//        model.addAttribute("offset", offset);
//        model.addAttribute("limit", limit);
//        model.addAttribute("deploys", deploys);
//        if (!("系统管理员".equals(user.getAccountType()))) {
//            return "deploy/list_user";
//        }
//        return "deploy/list_admin";
//    }

    //查看系统详情
    @RequestMapping(value = "details", method = RequestMethod.GET)
    public String getDetails(ModelMap model, String name, HttpServletRequest request) {
        Map map = ConnectToDeployDbByName.getDetailByname(name);
        model.addAttribute("map", map);

        for(Object o : ((Object[]) map.get("script"))) {
            System.out.println(o);
            String aa=o.toString();

            request.getSession(true).setAttribute("script", aa);
           model.addAttribute("script",aa);
        }

        for(Object manual : ((Object[]) map.get("manual"))) {
           model.addAttribute("manual",manual);
        }
        for(Object screenshots : ((Object[]) map.get("screenshots"))) {
            if (screenshots == null) {
                model.addAttribute("isnull", " 图片暂缺！");
            }
            String sc=screenshots.toString();
            model.addAttribute("screenshots",sc);
        }


        if (map.get("status").equals("禁用")) {
            model.addAttribute("fail", "当前系统暂不可演示！");
        }
        User user = (User) request.getSession(true).getAttribute("user");
        if (!("系统管理员".equals(user.getAccountType()))) {
            return "deploy/details_user";
        }
        return "deploy/details_admin";
    }

    //访问图片
    @RequestMapping(value = "getpicture", method = RequestMethod.GET)
    public void getpp(String  obj, HttpServletResponse response) {
        byte[] data = ConnectToImage.getDetailByname(obj);
        response.setContentType("img/png");
        response.setCharacterEncoding("utf-8");
        try {

            OutputStream outputStream = response.getOutputStream();
            InputStream in = new ByteArrayInputStream(data);
            int len = 0;
            byte[] buf = new byte[1024];
            while ((len = in.read(buf, 0, 1024)) != -1) {
                outputStream.write(buf, 0, len);
            }
            outputStream.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
//    //查看系统详情
//    @RequestMapping(value = "details", method = RequestMethod.GET)
//    public String getDetails(ModelMap model, Integer id, HttpServletRequest request) {
//        Deploy deploy = deployMapper.getDeployById(id);
//        model.addAttribute("deploy", deploy);
//        request.getSession(true).setAttribute("id", id);
//        User user = (User) request.getSession(true).getAttribute("user");
//        if (deploy.getPicture() == null) {
//            model.addAttribute("isnull", " 图片暂缺！");
//        }
//        if (deploy.getSystemStatus().equals("禁用")) {
//            model.addAttribute("fail", "当前系统暂不可演示！");
//        }
//        if (!("系统管理员".equals(user.getAccountType()))) {
//            return "deploy/details_user";
//        }
//        return "deploy/details_admin";
//    }

//    //上传图片
//    @RequestMapping(value = "upload", method = RequestMethod.POST)
//    public String upload(Deploy deploy, HttpServletRequest request) {
//        // 转型为MultipartHttpRequest：
//        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
//        // 获得文件：
//        MultipartFile file = multipartRequest.getFile("file");
//        try {
//            byte[] img = FIleTooByte.File2byte(file.getInputStream());
//            deploy.setPicture(img);
//            deployMapper.updatePicture(deploy);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return "deploy/uploadpicture";
//    }

//    @RequestMapping(value = "upload", method = RequestMethod.GET)
//    public String getCreate(ModelMap model) {
//        Deploy deploy = new Deploy();
//        model.addAttribute("deploy", deploy);
//        return "deploy/uploadpicture";
//    }


//    //访问图片
//    @RequestMapping(value = "getpicture", method = RequestMethod.GET)
//    public void getpp(Integer id, HttpServletResponse response) {
//        byte[] data = (byte[]) deployMapper.getpictureById(id);
//        response.setContentType("img/png");
//        response.setCharacterEncoding("utf-8");
//        try {
//
//            OutputStream outputStream = response.getOutputStream();
//            InputStream in = new ByteArrayInputStream(data);
//            int len = 0;
//            byte[] buf = new byte[1024];
//            while ((len = in.read(buf, 0, 1024)) != -1) {
//                outputStream.write(buf, 0, len);
//            }
//            outputStream.close();
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//    }
}

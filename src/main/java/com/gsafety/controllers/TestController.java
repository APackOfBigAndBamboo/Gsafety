//package com.gsafety.controllers;
//
//import com.gsafety.Utils.FIleTooByte;
//
//import com.gsafety.Utils.ImageUtil;
//import com.gsafety.mappers.DeployMapper;
//import com.gsafety.mappers.TestMapper;
//import com.gsafety.models.Test;
//import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.ui.ModelMap;
//import org.springframework.util.DigestUtils;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.multipart.MultipartHttpServletRequest;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.io.InputStream;
//
///**
// * Created by qianl on 11/12/2016.
// */
//
//@Controller
//@RequestMapping(value = "TencentMailStatusChange")
//public class TestController {
//
//
//    @Autowired
//    TestMapper testMapper;
//
//    @RequestMapping(value = "upload", method = RequestMethod.POST)
//    public String upload(Test TencentMailStatusChange, HttpServletRequest request) {
//        //第一种返回页面的方法
//        //model.addAttribute("img",PhotoUtil.saveFile(file,request));
//        //第二种返回页面的方法
//
//        // 转型为MultipartHttpRequest：
//        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
//        // 获得文件：
//        MultipartFile file = multipartRequest.getFile("file");
//        // 获得文件名：
////        file.getInputStream()
//
//        try {
////            String targetPath = "D:/image/2.png";
////            InputStream in = file.getInputStream();
////            ImageUtil.readBin2Image(in, targetPath);
//            byte[] img = FIleTooByte.File2byte(file.getInputStream());
//            Systems.out.println(img.length);
//            TencentMailStatusChange.setImg(img);
//            testMapper.insertPicture(TencentMailStatusChange);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
////        String filename = file.getOriginalFilename();
//
//        HttpServletResponse httpServletRespons;
////        httpServletRespons.getOutputStream()
//        return "TencentMailStatusChange/TencentMailStatusChange";
//    }
//
//    @RequestMapping(value = "upload", method = RequestMethod.GET)
//    public String getCreate(ModelMap model) {
//        Test TencentMailStatusChange = new Test();
//        model.addAttribute("TencentMailStatusChange", TencentMailStatusChange);
//        return "TencentMailStatusChange/TencentMailStatusChange";
//    }
////    @RequestMapping(value = "img",method = RequestMethod.POST)
////    public String img(Test TencentMailStatusChange){
////
////     return "";
////    }
////    static final Logger logger = LoggerFactory.getLogger(TestController.class);
////
////    @RequestMapping(value = "hello", method = RequestMethod.GET)
////    public String hello() {
////        return "TencentMailStatusChange/hello";
////    }
////
////    @RequestMapping(value = "hello", method = RequestMethod.POST)
////    public String welcome(@RequestParam(required = false, defaultValue = "") String name, Model model) {
////        model.addAttribute("name", name);
////        return "TencentMailStatusChange/hello";
////    }
////
////
////    @RequestMapping(value = "md5", method = RequestMethod.GET)
////    @ResponseBody
////    public String getMD5() {
////        return DigestUtils.md5DigestAsHex("123456".getBytes());
////    }
////
////    @RequestMapping(value = "log", method = RequestMethod.GET)
////    @ResponseBody
////    public String log() {
////
////        logger.trace("trace log");
////        logger.debug("debug log");
////        logger.info("info log");
////        logger.warn("warn log");
////        logger.error("error log");
////
////        return "log TencentMailStatusChange";
////    }
//
//
//}

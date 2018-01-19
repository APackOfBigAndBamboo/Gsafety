package com.gsafety.controllers;

import com.gsafety.mappers.DeployMapper;
import com.gsafety.models.Deploy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class PdfController {
    @Autowired
    DeployMapper deployMapper;

    //查看pdf
    @RequestMapping(value = "pdf", method = RequestMethod.GET)
    public String getPdf(ModelMap model, String script, HttpServletRequest request) {

        request.getSession(true).setAttribute("script", script);
        model.addAttribute("script",script);
        return "deploy/PDF";
    }
}

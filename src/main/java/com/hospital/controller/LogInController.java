package com.hospital.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Jimmy on 2017/3/13.
 */
@Controller
public class LogInController {
    @RequestMapping(value = "login")
    public String login(HttpServletRequest request, String verifycode) {
        // 获取验证码
        String code = (String) request.getSession().getAttribute("code");
        if (!code.equalsIgnoreCase(verifycode.toLowerCase())) {
            request.setAttribute("errorMessage", "验证码错误！");
            return "index";
        } else {
            request.setAttribute("successMessage", "正确");
            return "index";
        }
    }
}
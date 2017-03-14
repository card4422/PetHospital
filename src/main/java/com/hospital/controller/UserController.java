package com.hospital.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hospital.entity.User;
import com.hospital.service.TestService;
import com.hospital.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.util.*;

/**
 * Created by zhuzheng on 17/3/9.
 */
@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "saveUser", method = RequestMethod.GET)
    @ResponseBody
    public String saveUser(){
        userService.saveUser();
        return "success!";
    }

    @RequestMapping(value = "getAllUser",method = RequestMethod.GET)
    @ResponseBody
    public List getAllUser(){
        List users = userService.getAllUser();
        return users;
    }
    class validateInfo{
        Boolean isValidated;
        Integer userType;
    }
    @RequestMapping(value = "validate",method = RequestMethod.POST)
    @ResponseBody
    public String validate(User user,HttpSession session){
        if (!(user.getUserCode().equalsIgnoreCase(session.getAttribute("captcha").toString()))){  //忽略验证码大小写
            validateInfo info = new validateInfo();
            ObjectMapper objectMapper = new ObjectMapper();
            User u = userService.getUser(user.getUserName());
            if(u!=null){
                info.isValidated = true;
                info.userType = u.getUserType();
            }
            else{
                info.isValidated = false;
                info.userType = null;
            }
            String json = null;
            try {
                json = objectMapper.writeValueAsString(info);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            return json;
        }
        else{
            return "false";
        }
    }

//    @RequestMapping(value = "test", method = RequestMethod.GET)
//    public String test(){
//        //实际返回的是views/test.jsp ,spring-mvc.xml中配置过前后缀
//        return "test";
//    }
//
//    @RequestMapping(value = "springtest", method = RequestMethod.GET)
//    public String springTest(){
//        return testService.test();
//    }
//
//    @RequestMapping("")
//    public String index(){
//        return "index";
//    }
//
//    @RequestMapping("/json")
//    @ResponseBody
//    public Map<String, String> json(){
//        Map<String, String> result = new HashMap<String, String>();
//        result.put("MarK", "hello");
//        result.put("Ken", "Hehe");
//        result.put("Fowafolo", "fool");
//        return result;
//    }
}
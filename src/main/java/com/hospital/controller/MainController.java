package com.hospital.controller;

import com.hospital.service.TestService;
import com.hospital.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhuzheng on 17/3/9.
 */
@Controller
@RequestMapping("/")
public class MainController {

    @Autowired
//    private TestService testService;
    private UserService userService;

    @RequestMapping(value = "saveUser", method = RequestMethod.GET)
    @ResponseBody
    public String saveUser(){
        userService.saveUser();
        return "success!";
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
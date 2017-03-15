package com.hospital.controller;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hospital.entity.User;
import com.hospital.service.UserService;
import org.hibernate.usertype.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sun.org.mozilla.javascript.internal.json.JsonParser;

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

//    @RequestMapping(value = "getAllUser",method = RequestMethod.GET)
//    @ResponseBody
//    public List getAllUser(){
//        List users = userService.getAllUser();
//        return users;
//    }

    @RequestMapping(value = "admin/user/{page}",method = RequestMethod.GET)
    @ResponseBody
    /**
     * 返回指定页面的user信息
     */
    public String getUsers(@PathVariable String page) {
        int pages = Integer.parseInt(page);
        List users = userService.getAllUser();
        List<User> subusers = null;
        int fromIndex = (pages - 1) * 10;
        if (users.size() >= fromIndex) {
            int toIndex = pages * 10;
            if (users.size() >= toIndex) {
                subusers = users.subList(fromIndex, toIndex);
            } else {
                subusers = users.subList(fromIndex, users.size());
            }
        }
        class templateInfo {
            Integer user_id;
            String user_name;
            Integer user_type;
        }
        List<templateInfo> result = new ArrayList<templateInfo>();
        for (User user : subusers) {
            templateInfo tempInfo = new templateInfo();//必须放在循环内
            tempInfo.user_id = user.getUserId();
            tempInfo.user_name = user.getUserName();
            tempInfo.user_type = user.getUserType();
            result.add(tempInfo);
        }
        String json = null;
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        try {
            json = objectMapper.writeValueAsString(result);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "{data:"+json+",pages:"+page+"}";
    }

    @RequestMapping(value = "admin/user",method = RequestMethod.PUT)
    @ResponseBody
    public String updateUser(@RequestBody User user){
        userService.updateUser(user);
        return " Update success";
    }

    @RequestMapping(value = "admin/user",method = RequestMethod.POST)
    @ResponseBody
    public String saveUser(@RequestBody User user){
        userService.saveUser(user);
        return "success!";
    }

    @RequestMapping(value = "admin/user",method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteUser(@RequestBody User user){
        Integer id = user.getUserId();
        userService.deleteUser(id);
        return id + "  has been deleted";
    }

    @RequestMapping(value = "validate",method = RequestMethod.POST)
    @ResponseBody
    @JsonIgnoreProperties(ignoreUnknown=true)
    public String validate(@RequestBody String jsonString,HttpSession session) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            class FirsttemplateInfo {
                String user_name;
                String user_pwd;
                String captcha;
            }
            FirsttemplateInfo firsttemplateInfo = objectMapper.readValue(jsonString, FirsttemplateInfo.class);
            class templateInfo {
                Boolean isValidated;
                Integer userType;
            }
            if (!(firsttemplateInfo.captcha.equalsIgnoreCase(session.getAttribute("captcha").toString()))) {  //忽略验证码大小写
                templateInfo info = new templateInfo();
                User u = userService.getUser(firsttemplateInfo.user_name);
                if (u != null) {
                    info.isValidated = true;
                    info.userType = u.getUserType();
                } else {
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
            } else {
                return "false";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "false";
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
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
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserService userService;

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
            Integer Id;
            String userName;
            Integer userType;
        }
        List<templateInfo> result = new ArrayList<templateInfo>();
        for (User user : subusers) {
            templateInfo tempInfo = new templateInfo();//必须放在循环内
            tempInfo.Id = user.getId();
            tempInfo.userName = user.getUserName();
            tempInfo.userType = user.getUserType();
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
        return "{\"data\":"+json+",\"pages\":"+page+"}";
    }

    /**
     * 更新用户
     * @param user
     * @return
     */
    @RequestMapping(value = "admin/user",method = RequestMethod.PUT)
    @ResponseBody
    public String updateUser(@RequestBody User user){
        userService.updateUser(user);
        return " Update success";
    }

    /**
     * 增加用户
     * @param user
     * @return
     */
    @RequestMapping(value = "admin/user",method = RequestMethod.POST)
    @ResponseBody
    public String saveUser(@RequestBody User user){
        userService.saveUser(user);
        return "success!";
    }


    /**
     * 删除用户
     */
    @RequestMapping(value = "admin/user",method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteUser(@RequestBody User user) {
        Integer id = user.getId();
        userService.deleteUser(id);
        return "{result:true}";
    }

    /**
     * 验证用户名和密码，返回权限
     */
    @RequestMapping(value = "validate",method = RequestMethod.POST)
    @ResponseBody
    @JsonIgnoreProperties(ignoreUnknown=true)
    public Map<String, String> validate(@RequestBody Map map,HttpSession session) {
        if (map.get("captcha").toString().equalsIgnoreCase(session.getAttribute("captcha").toString())) {  //忽略验证码大小写
            Map<String, String> result = new HashMap<String, String>();
            User u = userService.getUser(map.get("userName").toString());
            if (u != null && u.getUserPwd().equals(map.get("userPwd").toString())) {
                result.put("isValidated", "true");
                result.put("userType", u.getUserType().toString());
            } else {
                result.put("isValidated", "false");
                result.put("userType", u.getUserType().toString());
            }
            return result;
        } else {
            return null;
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
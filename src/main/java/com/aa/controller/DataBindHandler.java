package com.aa.controller;

import com.aa.entity.User;
import com.aa.entity.UserList;
import com.aa.entity.UserMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
@RequestMapping("/data")
public class DataBindHandler {

    //基本数据类型
    @RequestMapping("/baseType")
    @ResponseBody
    public String baseType(int id){
        return id+"";
    }

    //包装类
    @RequestMapping("/packageType")
    @ResponseBody
    public String packageType(@RequestParam(value = "num",required = false,defaultValue = "0") Integer id){
        return id+"";
    }

    //数组
    @RequestMapping("/array")
    public String array(String[] name){
        String str = Arrays.toString(name);
        return str;
    }

    //Spring MVC 不支持 List 类型的直接转换，需要对 List 集合进行包装。(创建一个集合类，以获得对象)
    @RequestMapping("/list")
    public String list(UserList userList){
        StringBuffer str = new StringBuffer();
        for(User user:userList.getUsers()){
            str.append(user);
        }
        return str.toString();
    }

    //自定义封装类的业务方法
    @RequestMapping("/map")
    public String map(UserMap userMap){
        StringBuffer str = new StringBuffer();
        for(String key:userMap.getUsers().keySet()){
            User user = userMap.getUsers().get(key);
            str.append(user);
        }
        return str.toString();
    }

    @RequestMapping("/json")
    public User json(@RequestBody User user){
        System.out.println(user);
        user.setId(6);
        user.setName("张六");
        return user;
    }
}

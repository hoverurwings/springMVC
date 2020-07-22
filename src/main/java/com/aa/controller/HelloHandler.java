package com.aa.controller;

import com.aa.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/hello")
public class HelloHandler {

    @RequestMapping(value = "/index",method = RequestMethod.GET,params ={"name","id=10"})
    public String index(@RequestParam("name")String string,@RequestParam("id")int id ){
        System.out.println(string);
        System.out.println(id);
        System.out.println("执行了index...");
        return "index";
    }

    //Spring MVC 也支持 RESTful 风格的 URL。
    @RequestMapping("/rest/{name}/{id}")
    public String rest(@PathVariable("name") String name, @PathVariable("id") int id){
        System.out.println(name);
        System.out.println(id);
        return "index";
    }

    //Spring MVC 通过映射可以直接在业务方法中获取 Cookie 的值。
    @RequestMapping("/cookie")
    public String cookie(@CookieValue(value = "JSESSIONID") String sessionId){
        System.out.println(sessionId);
        return "index";
    }

    //Spring MVC 会根据请求参数名和 JavaBean 属性名进行自动匹配，自动为对象填充属性值，同时支持及联属性。
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String save(User user){
        System.out.println(user);
        return "index";
    }

    //JSP 页面的转发和重定向：Spring MVC 默认是以转发的形式响应 JSP。
    @RequestMapping("/forward")//转发
    public String forward(){
        return "forward:/index.jsp";
        //        return "index";
    }
    @RequestMapping("/redirect")//重定向
    public String redirect(){
        return "redirect:/index.jsp";
    }


}

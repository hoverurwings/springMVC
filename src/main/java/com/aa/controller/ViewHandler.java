package com.aa.controller;


import com.aa.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.InternalResourceView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/view")
public class ViewHandler {
    //Spring MVC 提供了以下几种方式添加模型数据(Map、Model、ModelAndView、@SessionAttribute、@ModelAttribute)
    @RequestMapping("/map")
    public String map(Map<String, User> map){
        User user = new User();
        user.setId(1L);
        user.setName("张三");
        map.put("user",user);
        return "view";
    }

    @RequestMapping("/model")
    public String model(Model model){
        User user = new User();
        user.setId(1L);
        user.setName("张三");
        model.addAttribute("user",user);
        return "view";
    }

    @RequestMapping("/modelAndView")
    public ModelAndView modelAndView(){
        User user = new User();
        user.setId(1L);
        user.setName("张三");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user",user);
        modelAndView.setViewName("view");
        return modelAndView;
    }

    @RequestMapping("/modelAndView2")
    public ModelAndView modelAndView2(){
        User user = new User();
        user.setId(1L);
        user.setName("张三");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user",user);
        View view = new InternalResourceView("/view.jsp");
        modelAndView.setView(view);
        return modelAndView;
    }

    @RequestMapping("/modelAndView3")
    public ModelAndView modelAndView3(){
        User user = new User();
        user.setId(1L);
        user.setName("张三");
        ModelAndView modelAndView = new ModelAndView("view");
        modelAndView.addObject("user",user);
        return modelAndView;
    }

    @RequestMapping("/modelAndView4")
    public ModelAndView modelAndView4(){
        User user = new User();
        user.setId(1L);
        user.setName("张三");
        View view = new InternalResourceView("/view.jsp");
        ModelAndView modelAndView = new ModelAndView(view);
        modelAndView.addObject("user",user);
        return modelAndView;
    }

    @RequestMapping("/modelAndView5")
    public ModelAndView modelAndView5(){
        User user = new User();
        user.setId(1L);
        user.setName("张三");
        Map<String,User> map = new HashMap<>();
        map.put("user",user);
        ModelAndView modelAndView = new ModelAndView("view",map);
        return modelAndView;
    }

    @RequestMapping("/modelAndView6")
    public ModelAndView modelAndView6(){
        User user = new User();
        user.setId(1L);
        user.setName("张三");
        Map<String,User> map = new HashMap<>();
        map.put("user",user);
        View view = new InternalResourceView("/view.jsp");
        ModelAndView modelAndView = new ModelAndView(view,map);
        return modelAndView;
    }

    @RequestMapping("/modelAndView7")
    public ModelAndView modelAndView7(){
        User user = new User();
        user.setId(1L);
        user.setName("张三");
        ModelAndView modelAndView = new ModelAndView("view","user",user);
        return modelAndView;
    }

    @RequestMapping("/modelAndView8")
    public ModelAndView modelAndView8(){
        User user = new User();
        user.setId(1L);
        user.setName("张三");
        View view = new InternalResourceView("/view.jsp");
        ModelAndView modelAndView = new ModelAndView(view,"user",user);
        return modelAndView;
    }

    //HttpServletRequest
    @RequestMapping("/request")
    public String request(HttpServletRequest request){
        User user = new User();
        user.setId(1L);
        user.setName("张三");
        request.setAttribute("user",user);
        return "view";
    }


    //可以用@ModelAttribute定义一个方法，该方法专门用来返回要填充到模型数据中的对象。
    //然后业务方法中无需再处理模型数据，只需返回视图即可。
    @ModelAttribute
    public User getUser(){
        User user = new User();
        user.setId(1L);
        user.setName("张三");
        return user;
    }

    @ModelAttribute
    public void getUser(Map<String,User> map){
        User user = new User();
        user.setId(1L);
        user.setName("张三");
        map.put("user",user);
    }

    @ModelAttribute
    public void getUser(Model model){
        User user = new User();
        user.setId(1L);
        user.setName("张三");
        model.addAttribute("user",user);
    }

    @RequestMapping("/modelAttribute")
    public String modelAttribute(){
        return "view";
    }

    //将模型数据绑定到 session 对象
    @RequestMapping("/session")
    public String session(HttpServletRequest request){
        HttpSession session = request.getSession();
        User user = new User();
        user.setId(1L);
        user.setName("张三");
        session.setAttribute("user",user);
        return "view";
    }

    @RequestMapping("/session2")
    public String session2(HttpSession session){
        User user = new User();
        user.setId(1L);
        user.setName("张三");
        session.setAttribute("user",user);
        return "view";
    }

    @RequestMapping("/application")
    public String application(HttpServletRequest request){
        ServletContext application = request.getServletContext();
        User user = new User();
        user.setId(1L);
        user.setName("张三");
        application.setAttribute("user",user);
        return "view";
    }
}

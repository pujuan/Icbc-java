package com.icbc.sh.icbcjavaee.controller;

import com.icbc.sh.icbcjavaee.dao.UserDao;
import com.icbc.sh.icbcjavaee.entity.User;
import com.icbc.sh.icbcjavaee.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@ResponseBody
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/index")
    public ModelAndView index(){
        return new ModelAndView("index");
    }

    @RequestMapping(value = "/uindex",method = RequestMethod.GET)
    public ModelAndView uindex(String jump){
        if("注册".equals(jump)){
            return new ModelAndView("register");
        }else if ("登录".equals(jump)){
            return new ModelAndView("login");
        }else {
            return new ModelAndView("index");
        }

    }

    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public ModelAndView register(){
        return new ModelAndView("register");
    }

    @RequestMapping(value = "/uregister",method = RequestMethod.GET)
    public ModelAndView uregister(String username,String password){
        User user = userService.uregister(username,password);
        if (user!=null){
            return new ModelAndView("login");
        }else {
            return new ModelAndView("register");
        }
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public ModelAndView login(){
        return new ModelAndView("login");
    }


    @RequestMapping(value = "/ulogin",method = RequestMethod.GET)
    public ModelAndView ulogin(String username, String password){
        System.out.println(username);
        User user = userService.ulogin(username,password);
        if(user!=null && user.getPassword().equals(password)){
            return new ModelAndView("loginSuccess");
        } else {
            return new ModelAndView("login");
        }

    }
}

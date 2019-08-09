package com.icbc.sh.icbcjavaee.controller;

import com.icbc.sh.icbcjavaee.dao.UserDao;
import com.icbc.sh.icbcjavaee.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.UUID;

@Controller
@ResponseBody
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "/")
    public ModelAndView index(){
        return new ModelAndView("index");
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public ModelAndView login(String username, String password){
        User user = userDao.login(username,password);
        if(user!=null && user.getPassword().equals(password)){
           return new ModelAndView("index");
        } else {
            return new ModelAndView("login");
        }
//        if("jj".equals(username) && "123".equals(password)){
//            return "登陆成功";
//        }else{
//            return "登录失败";
//        }
    }

    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public ModelAndView register(){
        return new ModelAndView("register");
    }

    @RequestMapping(value = "/save",method = RequestMethod.GET)
    public ModelAndView save(String username,String password){
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        userDao.save(user);
        return new ModelAndView("login");
    }
}

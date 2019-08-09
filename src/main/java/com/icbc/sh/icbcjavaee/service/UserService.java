package com.icbc.sh.icbcjavaee.service;

import com.icbc.sh.icbcjavaee.dao.UserDao;
import com.icbc.sh.icbcjavaee.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Service
@ResponseBody
@RequestMapping("/user")
public class UserService {
    @Autowired
    private UserDao userDao;
    @RequestMapping(value = "/ulogin",method = RequestMethod.GET)
    public ModelAndView ulogin(String username, String password){
        System.out.println("用户名是："+username);
        System.out.println("密码是："+password);
        User user = userDao.login(username,password);
        if(user!=null && user.getPassword().equals(password)){
            return new ModelAndView("index");
        } else {
            return new ModelAndView("login");
        }

    }

    @RequestMapping(value = "/uregister",method = RequestMethod.GET)
    public ModelAndView save(String username,String password){
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        userDao.save(user);
        return new ModelAndView("login");
    }
}

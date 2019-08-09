package com.icbc.sh.icbcjavaee.service;

import com.icbc.sh.icbcjavaee.dao.UserDao;
import com.icbc.sh.icbcjavaee.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserService {

    @Autowired
    private UserDao userDao;
    public User ulogin(String username, String password){

        return userDao.login(username,password);

    }

    public User save(String username,String password){
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        userDao.save(user);
        return userDao.login(username,password);
    }
}

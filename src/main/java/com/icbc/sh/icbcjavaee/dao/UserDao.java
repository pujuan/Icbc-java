package com.icbc.sh.icbcjavaee.dao;

import com.icbc.sh.icbcjavaee.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserDao extends JpaRepository<User,String> {


    @Query("select u from User u where u.username= :username and u.password= :password")
     User login(String username,String password);
}

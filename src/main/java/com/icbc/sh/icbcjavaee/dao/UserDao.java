package com.icbc.sh.icbcjavaee.dao;

import com.icbc.sh.icbcjavaee.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserDao extends JpaRepository<User,String> {


    @Query("select username,password from User where username=#{username} and password = #{password}")
     User login(String username,String password);
}

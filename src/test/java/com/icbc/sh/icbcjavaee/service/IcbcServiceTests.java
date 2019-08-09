package com.icbc.sh.icbcjavaee.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IcbcServiceTests {



    @Before public void setUp(){

    }

    @Test public void testBusiness(){
        String args = "555";  //准备数据
    //    List<String> result = icbcService.doBusiness(args);//调用被测逻辑
       // Assert.notNull(result,"结果不为空");//做断言
    }
    @After public void tearDown(){

    }

}

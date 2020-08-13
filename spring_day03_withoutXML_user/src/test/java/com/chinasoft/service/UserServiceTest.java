package com.chinasoft.service;


import com.chinasoft.domain.User;
import config.JdbcConfig;
import config.SpringConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/*
*
* sping整合junit方法：
*    1.导入junit包：要求在使用5.x.x版本的spring时候，导入junit版本必须要4.1.2及以上
*    2.使用junit提供的注解替换main方法，替换为spring中的注解
*       RunWith
*         属性：value 为需要运行的类的字节码
*    3.告知spring运行器，spring ioc容器的创建是用的哪种形式，并告诉它地址在哪
*        @ContextConfiguration:
*          locations:指定xml的位置，加上了classpath关键字，表示在类路径下面
*          classes:指定配置类的位置
*
*
* */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class UserServiceTest {

    @Autowired
    private UserService service;

    @Test
    public void test1(){
        //使用注解时的配置类
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class, JdbcConfig.class);
        UserService service = (UserService) context.getBean("userService");
        List<User> all = service.findAll();
        System.out.println(all);
    }

}

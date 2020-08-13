package com.chinasoft.mapper.impl;

import com.chinasoft.domain.User;
import com.chinasoft.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("mapper")
public class UserMapperImpl implements UserMapper {

    @Autowired
    private JdbcTemplate template;



    public List<User> findAll() {
        String sql="select * from tab_user";
        return template.query(sql,new BeanPropertyRowMapper<>(User.class));
    }


}

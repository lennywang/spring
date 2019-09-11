package com.atguigu.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Random;
import java.util.UUID;

@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insert()
    {
        String sql="insert into student(name,age,sex) values(?,?,?)";//class,,?
        String username = UUID.randomUUID().toString().substring(0, 5);
        int age = new Random().nextInt(10)+10;
        jdbcTemplate.update(sql, new Object[]{username,age,"无"});//"0001",
    }

}

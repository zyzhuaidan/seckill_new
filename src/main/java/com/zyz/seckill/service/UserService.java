package com.zyz.seckill.service;


import com.zyz.seckill.mapper.UserMapper;
import com.zyz.seckill.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public User getById(Integer id){
        return userMapper.selectByPrimaryKey(id);

    }
    @Transactional
    public boolean tx(){
        User u1 = new User();
        User u2 = new User();
        u1.setId(2);
        u1.setName("test");
        userMapper.insert(u2);
        u1.setId(3);
        u1.setName("test");
        userMapper.insert(u1);


        return true;
    }
}

package com.zyz.seckill.mapper;

import com.zyz.seckill.pojo.User;
import com.zyz.seckill.util.MyMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends MyMapper<User> {
}
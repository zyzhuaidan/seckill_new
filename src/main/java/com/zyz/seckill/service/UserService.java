package com.zyz.seckill.service;


import com.zyz.seckill.exception.GlobalException;
import com.zyz.seckill.mapper.SeckillUserMapper;
import com.zyz.seckill.mapper.UserMapper;
import com.zyz.seckill.pojo.SeckillUser;
import com.zyz.seckill.pojo.User;
import com.zyz.seckill.redis.RedisService;
import com.zyz.seckill.redis.SeckillUserKey;
import com.zyz.seckill.result.CodeMsg;
import com.zyz.seckill.util.MD5Util;
import com.zyz.seckill.util.UUIDUtil;
import com.zyz.seckill.vo.LoginVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
public class UserService {
    public static final String COOKIE_NAME_TOKEN = "token";
    @Autowired
    private SeckillUserMapper userMapper;
    @Autowired
    private RedisService redisService;

    public SeckillUser getById(Long id) {
        return userMapper.selectByPrimaryKey(id);

    }

    public SeckillUser getByToken(HttpServletResponse response, String token) {
        //根据cookie值 获取user
        if (StringUtils.isEmpty(token)) {
            return null;
        }
        SeckillUser user = redisService.get(SeckillUserKey.token, token, SeckillUser.class);
        if (user != null) {
            //延长有限期
            //重新设置cookie
            addCookie(response, user);
        }
        return user;

    }

//    @Transactional
//    public boolean tx() {
//        User u1 = new User();
//        User u2 = new User();
//        u1.setId(2);
//        u1.setName("test");
//        userMapper.insert(u2);
//        u1.setId(3);
//        u1.setName("test");
//        userMapper.insert(u1);
//
//
//        return true;
//    }

    public boolean login(HttpServletResponse response, LoginVo loginVo) {
        if (loginVo == null) {
            //出现业务异常直接往外抛
            throw new GlobalException(CodeMsg.SERVER_ERROR);
        }

        String moblie = loginVo.getMobile();
        String formpass = loginVo.getPassword();
        //判断手机号是否存在
        SeckillUser user = getById(Long.parseLong(moblie));
        if (user == null) {
            throw new GlobalException(CodeMsg.MOBILE_NOTEXIST);
        }
        //验证密码
        String dbPass = user.getPassword();
        String slatDB = user.getSalt();
        String calcPass = MD5Util.formPassFormPass(formpass, slatDB);
        if (!calcPass.equals(dbPass)) {
            throw new GlobalException(CodeMsg.PASSWORD_ERROR);
        }

//        //1.生成cookie
//        String token = UUIDUtil.uuid();
//        redisService.set(SeckillUserKey.token,token,user);
//        //2.
//        Cookie cookie = new Cookie(COOKI_NAME_TOKEN,token);
//        //设置cookie有效时间 和session 一致
//        cookie.setMaxAge(SeckillUserKey.token.expireSeconds());
//        //设置path为网站的根目录
//        cookie.setPath("/");
//        //cookie写入客户端
//        response.addCookie(cookie);
//        1.生成cookie
        addCookie(response, user);


        return true;
    }

    private void addCookie(HttpServletResponse response, SeckillUser user) {
        //1.生成cookie
        String token = UUIDUtil.uuid();
        redisService.set(SeckillUserKey.token, token, user);
        //2.
        Cookie cookie = new Cookie(COOKIE_NAME_TOKEN, token);
        //设置cookie有效时间 和session 一致
        cookie.setMaxAge(SeckillUserKey.token.expireSeconds());
        //设置path为网站的根目录
        cookie.setPath("/");
        //cookie写入客户端
        response.addCookie(cookie);

    }


}

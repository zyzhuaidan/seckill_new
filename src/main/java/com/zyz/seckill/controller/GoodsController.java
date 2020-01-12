package com.zyz.seckill.controller;

import com.zyz.seckill.pojo.SeckillUser;
import com.zyz.seckill.pojo.User;
import com.zyz.seckill.result.Result;
import com.zyz.seckill.service.UserService;
import com.zyz.seckill.vo.LoginVo;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private UserService userService;

    private static Logger log = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping("/to_list")
    public String list(Model model,
//                       @CookieValue(value = UserService.COOKI_NAME_TOKEN, required = false) String cookieToken,
//                       //兼容某些手机客户端放在
//                       @RequestParam(value = UserService.COOKI_NAME_TOKEN, required = false) String paramToken,

                       //直接注入user对象
                       SeckillUser seckillUser) {
//        model.addAttribute("user",new SeckillUser());
//        if (StringUtils.isEmpty(cookieToken) && StringUtils.isEmpty(paramToken)) {
//            return "login";
//        }
//        String token = StringUtils.isEmpty(paramToken) ? cookieToken : paramToken;
//        SeckillUser seckillUser = userService.getByToken(response, token);
        model.addAttribute("user", seckillUser);
//        System.out.println(seckillUser.getNickname());


        return "goods_list";
    }


    @RequestMapping("/to_detail")
    public String detail(HttpServletResponse response, Model model,
                         @CookieValue(value = UserService.COOKIE_NAME_TOKEN, required = false) String cookieToken,
                         //兼容某些手机客户端放在
                         @RequestParam(value = UserService.COOKIE_NAME_TOKEN, required = false) String paramToken) {


        return null;
    }
}

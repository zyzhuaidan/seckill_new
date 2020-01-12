package com.zyz.seckill.controller;

import com.sun.org.apache.bcel.internal.classfile.Code;
import com.zyz.seckill.result.CodeMsg;
import com.zyz.seckill.result.Result;
import com.zyz.seckill.service.UserService;
import com.zyz.seckill.util.VaildatorUtil;
import com.zyz.seckill.vo.LoginVo;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService userService;
    /*
    使用指定类初始化日志对象,在日志输出的时候，可以打印出日志信息所在类

    如：Logger logger = LoggerFactory.getLogger(com.lz.Test.class);
       logger.debug("日志信息");
       将会打印出: com.lz.Test : 日志信息
     */
    private static Logger log = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping("/to_login")
//    @ResponseBody
    public String toLogin() {

//       log.info(loginVo.toString());
        return "login";
    }

    @RequestMapping("/do_login")
    @ResponseBody
    public Result<Boolean> doLogin(HttpServletResponse response,@Valid LoginVo loginVo) {
        log.info(loginVo.toString());
//        参数校验
//        String passInput = loginVo.getPassword();
//        String mobile = loginVo.getMobile();
//        if(StringUtils.isEmpty(passInput)){
//            return Result.error(CodeMsg.PASSWORD_EMPTY);
//        }
//        if(!VaildatorUtil.isMobile(mobile)){
//            return Result.error(CodeMsg.MOBILE_ERROR);
//        }
//        if(StringUtils.isEmpty(mobile)){
//            return Result.error(CodeMsg.PASSWORD_EMPTY);
//        }
        //登录
//        System.out.println(loginVo);



//        CodeMsg cm = userService.login(loginVo);
//        if(cm.getCode() == 0){
//            return Result.success(true);
//        }else{
//            return Result.error(cm);
//        }

        //登录E
        userService.login(response, loginVo);
        //异常处理在GlobalExpectionHandler中处理

        return Result.success(true);
    }

}

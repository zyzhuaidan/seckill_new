package com.zyz.seckill.exception;

//import org.springframework.stereotype.Controller;
import com.zyz.seckill.result.CodeMsg;
import com.zyz.seckill.result.Result;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.net.BindException;
import java.util.List;

/**
 * 全局异常处理器
 */

@ControllerAdvice
@ResponseBody
public class GlobleExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    public Result<String> exceptionHandler(HttpServletRequest request, Exception e) {
        e.printStackTrace();
        /**
         * boolean result = obj instanceof Class
         * 　　其中 obj 为一个对象，Class 表示一个类或者一个接口，当 obj 为 Class 的对象，
         * 或者是其直接或间接子类，或者是其接口的实现类，结果result 都返回 true，否则返回false。
         * 　　注意：编译器会检查 obj 是否能转换成右边的class类型，如果不能转换则直接报错，
         * 如果不能确定类型，则通过编译，具体看运行时定。
         */
        if(e instanceof GlobalException){
            GlobalException ex = (GlobalException) e;
            ex.getCm();
            return Result.error(ex.getCm());
        }
        if(e instanceof BindException){
            BindException ex = (BindException) e;
            ex.getMessage();
            String msg = "";
            return Result.error(CodeMsg.BIND_ERROR.fillArgs());

        }else if(e instanceof org.springframework.validation.BindException) {
            org.springframework.validation.BindException ex = (org.springframework.validation.BindException)e;
            List<ObjectError> errors = ex.getAllErrors();
            ObjectError error = errors.get(0);
            String msg = error.getDefaultMessage();
            return Result.error(CodeMsg.BIND_ERROR.fillArgs(msg));
        }else {
            return Result.error(CodeMsg.SERVER_ERROR);
        }
    }
}

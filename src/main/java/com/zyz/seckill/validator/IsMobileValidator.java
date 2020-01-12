package com.zyz.seckill.validator;

import com.zyz.seckill.util.VaildatorUtil;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IsMobileValidator implements ConstraintValidator<IsMobile,String> {
//    boolean required() default true;
    private boolean required = false;
    @Override
    public void initialize(IsMobile constraintAnnotation) {
        //定义成员变量接受注解值
        required = constraintAnnotation.required();

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
       if(required){//这个值是必须的
           return VaildatorUtil.isMobile(s);
        }else{//非必须
            if(StringUtils.isEmpty(s)){
                return true;
            }else {
                return VaildatorUtil.isMobile(s);
            }
        }
//        return false;
    }
}

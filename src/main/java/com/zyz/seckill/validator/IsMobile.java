package com.zyz.seckill.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.NotNull;
import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
//@Repeatable(NotNull.List.class)
@Documented
@Constraint(
        //系统调用IsMobileValidator校验器
        validatedBy = {IsMobileValidator.class}
)
public @interface IsMobile {
    boolean required() default false;
    String message() default "手机号码格式有误";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}

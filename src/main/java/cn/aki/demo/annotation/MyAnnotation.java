package cn.aki.demo.annotation;

import java.lang.annotation.*;

/**
 * Created by Administrator on 2017/6/12.
 * 一般注解
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited // 仅对class有效
public @interface MyAnnotation {
	String[] value() default {};
}

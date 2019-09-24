package cn.zhengsigen.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TestX {

	int count() default 1;
	
	long timeout() default 0;
	
	Class<?> expected() default NullPointerException.class;
}

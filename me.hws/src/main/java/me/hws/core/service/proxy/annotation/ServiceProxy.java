package me.hws.core.service.proxy.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ServiceProxy {

	public Class handlerClass();
	
	public String handlerMethod();
	
	public Class[] methodParamTypes() default {} ;
	
}

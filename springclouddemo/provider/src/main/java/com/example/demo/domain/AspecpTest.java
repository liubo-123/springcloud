package com.example.demo.domain;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @author lb
 * #Description AspecpTest
 * #Date:2020/9/14:14:26
 **/
@Aspect
@Component
public class AspecpTest {
    final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Pointcut("execution(* com.example.demo..*.*(..))")
    public void m(){

    }
    @Before(value = "m()")
    public void doBefore(JoinPoint joinPoint ){
        try {
            RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();//这个RequestContextHolder是Springmvc提供来获得请求的东西
            HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();

//         记录下请求内容
            logger.info("################URL : " + request.getRequestURL().toString());
            logger.info("################HTTP_METHOD : " + request.getMethod());
            logger.info("################IP : " + request.getRemoteAddr());
            logger.info("################THE ARGS OF THE CONTROLLER : " + Arrays.toString(joinPoint.getArgs()));
            logger.info("aaaaaaaa");
        }catch(Exception e){
            logger.info("bbbbb"+e);
        }
   }
   @After(value="m()")
   public void doAfter(JoinPoint joinPoint){
        logger.info("bbbbbbbb");

   }
}

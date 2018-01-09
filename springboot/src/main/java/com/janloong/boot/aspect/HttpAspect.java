package com.janloong.boot.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Janloong
 * @date 2017-12-27 15:31
 */
@Aspect
@Component
public class HttpAspect {
    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    @AfterReturning(
            returning = "object",
            pointcut = "log()"
    )
    public void afterReturn(Object object) {
        logger.info("\n返回值 - : " + "\n" + "object:" + object + "\n");
    }

    @Pointcut("execution( * com.janloong.boot.controller.HomeController.*(..))")
    public void log() {
    }

    @After("log()")
    public void logAfter() {
        logger.info("\n请求后 - : " + "\n" + ":" + "\n" + ":" + "\n");
    }


    @Before("log()")
    public void logBefore(JoinPoint joinPoint) {
        ServletRequestAttributes requestAttributes =
                (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        String remoteUser = request.getRemoteUser();
        int remotePort = request.getRemotePort();
        String remoteAddr = request.getRemoteAddr();
        String className = joinPoint.getSignature().getDeclaringTypeName();
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();

        logger.info("\n请求前 - : " + "\n" + "remoteUser:" + remoteUser + "\n" + "remotePort:" + remotePort + "\n"
                + "remoteAddr:" + remoteAddr + "\n" + "className:" + className + "\n" + "methodName:" + methodName
                + "\n" + "args:" + args[0] + "\n" + "args:" + args[1] + "\n");
    }
}



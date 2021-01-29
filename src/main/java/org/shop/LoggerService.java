package org.shop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerService {
    @Autowired
    private Logger logger;

    @AfterReturning(
            pointcut = "within(org.shop.repository.map..*)"
    )
    public void logging(JoinPoint joinPoint) {
        logger.info("{} started execution with args: {}", joinPoint.getSignature().getName(), joinPoint.getArgs());
    }
}

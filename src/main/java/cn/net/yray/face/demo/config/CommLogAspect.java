package cn.net.yray.face.demo.config;

import cn.net.cfss.fgbp.base.interceptor.BaseLogAspect;
import cn.net.cfss.fgbp.log.statistics.IStatsdLogService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class CommLogAspect extends BaseLogAspect {
    @Autowired
    private IStatsdLogService statsdLogService;

    @Pointcut("execution(public * cn.net.yray.face.demo.controller..*.*(..))")
    public void logPointcut() {

    }

    @Around("logPointcut()")
    @Override
    public Object logHandler(ProceedingJoinPoint process) throws Throwable {
        return super.logHandler(process);
    }
}


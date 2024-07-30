package log;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/* 1> 스프링부트 그래들
 * implementation 'org.springframework.boot:spring-boot-starter-aop'
 * 추가
 * 2> 프로젝트 우클릭 - gradle - refresh gradle project 실행
 * */

@Component
@Aspect
public class LogbackLoggerAOP {

    private static final Logger log = LoggerFactory.getLogger(LogbackLoggerAOP.class);

    /*    @Around("execution(* com.spring.jpa.controller..*Controller.*(..))"
            +" || execution(* com.spring.jpa.service..*Service*.*(..))"
            +" || execution(* com.spring.jpa.repository..*Repository.*(..))")*/
    
    @Around("execution(* boardmapper..*.*(..))"
            +" || execution(* com.example.demo.*Application.*(..))"
            +" || execution(* com.example.demo.Hello*.*(..))"
            +" || execution(* upload..*.*(..))"
    		+" || execution(* sse..*.*(..))")
    public Object logPrint(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        //객체명
        String type = proceedingJoinPoint.getSignature().getDeclaringTypeName();

        //proceedingJoinPoint.getSignature().getName() <- 실행 메서드명
        log.info("[[START]]"+type+"."+proceedingJoinPoint.getSignature().getName()+"() <=================");
        log.info("Argument/Parameter : "+ Arrays.toString(proceedingJoinPoint.getArgs()));//<-파라미터
        log.info("================[[END : "+proceedingJoinPoint.getSignature().getName()+"()]]==================");

        System.out.println("[[START]]"+type+"."+proceedingJoinPoint.getSignature().getName()+"() <=================");
        System.out.println("Argument/Parameter : "+ Arrays.toString(proceedingJoinPoint.getArgs()));
        System.out.println("================[[END : "+proceedingJoinPoint.getSignature().getName()+"()]]==================");
        
        return proceedingJoinPoint.proceed();
    }

}
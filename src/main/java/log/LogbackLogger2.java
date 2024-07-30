package log;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
//@Aspect
class LogbackLogger2 {
private  Logger logger = LoggerFactory.getLogger(LogbackLogger2.class);

/*
@Before("execution(* boardmapper..*.*(..))"
        +" || execution(* com.example.demo.*Application.*(..))"
        +" || execution(* com.example.demo.Hello*.*(..))"
        +" || execution(* upload..*.*(..))")
*/
void method() {
	System.out.println("aopf로그테스트");
	logger.trace("Trace");
	logger.debug("Debug");
	logger.info("Info");
	logger.warn("Warn");
	logger.error("Error");
}

public static void main(String args[]) throws Throwable {
	new LogbackLogger2().method();
	System.out.println("aop됩니다");
	
}
}


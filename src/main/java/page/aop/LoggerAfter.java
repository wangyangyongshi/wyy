package page.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * Created by wangyang on 2019/4/15.
 */
@Component
public class LoggerAfter implements AfterReturningAdvice{
    private Logger logger = LoggerFactory.getLogger(LoggerAfter.class);
    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        logger.info("im sorry,end!!!");
    }
}

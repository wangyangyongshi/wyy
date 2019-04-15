package page.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * Created by wangyang on 2019/4/15.
 */
@Component
public class LoggerBefore  implements MethodBeforeAdvice{
     Logger logger = LoggerFactory.getLogger(LoggerBefore.class);
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        logger.info("logger start!!!");
    }
}

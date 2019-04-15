package page.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by wangyang on 2019/4/15.
 * jdk动态代理
 */
public class JdkProxy implements InvocationHandler {
    private Object target;//需要代理的目标对象
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("jdk-------监听start..");
        Object result = null;
        try {
          result  = method.invoke(target, args);
        }catch (InvocationTargetException e){
            throw e.getCause();
        }
        System.out.println("jdk-------监听end..");
        return result;
    }

    //获取代理对象
    public Object getJdkProxy(Object targetObject){
        //为目标对象赋值
        this.target = targetObject;
        //JDK动态代理只能针对实现了接口的类进行代理，newProxyInstance 函数所需参数就可看出
        return Proxy.newProxyInstance(targetObject.getClass().getClassLoader(),targetObject.getClass().getInterfaces(),this);
    }

}

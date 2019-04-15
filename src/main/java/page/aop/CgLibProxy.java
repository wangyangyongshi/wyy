package page.aop;


import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by wangyang on 2019/4/15.
 */
public class CgLibProxy implements org.springframework.cglib.proxy.MethodInterceptor {
      private Object target;//需要代理的目标对象
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("Cglib动态代理，监听开始！");
        Object invoke = method.invoke(target, objects);
        System.out.println("Cglib动态代理，监听结束！");
        return invoke;
    }

    public Object getCglibProxy(Object objectTarget){
        this.target = objectTarget;
        Enhancer enhance = new Enhancer();
        //设置父类,因为Cglib是针对指定的类生成一个子类，所以需要指定父类
        enhance.setSuperclass(objectTarget.getClass());
        enhance.setCallback(this);
        Object o = enhance.create();
        return o;

    }


}

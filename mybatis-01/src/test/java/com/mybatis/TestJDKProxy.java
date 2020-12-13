package com.mybatis;

import org.apache.ibatis.annotations.Select;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.List;

/**
 * @author Aiden
 * @version 1.0
 * @description
 * @date 2020-12-7 22:38:21
 */
public class TestJDKProxy {

    public interface UserMapper{
        @Select("select * from table_vip")
        List<String> getUsers();
    }
    public static void main(String[] args) {
        UserMapper proxyInstance = (UserMapper)Proxy.newProxyInstance(TestJDKProxy.class.getClassLoader(), new Class[]{UserMapper.class}, new InvocationHandler() {
            /**
             * 代理模式--->每次调用getUsers()方法就会被拦截进入invoke方法
             *
             * @param proxy proxy为UserMapper的代理对象 proxyInstance
             * @param method method为被代理接口中的方法 getUsers
             * @param args args为方法参数值
             * @return Object
             * @throws Throwable Throwable
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Select annotation = method.getAnnotation(Select.class);
                if (annotation != null){
                    String[] value = annotation.value();
                    Arrays.stream(value).forEach(System.err::println);
                }
                System.out.println(annotation);
                System.err.println(method.getName());
                return null;
            }
        });
        List<String> list = proxyInstance.getUsers();
    }
}



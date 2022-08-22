package com.xxx.test;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Mr.Li
 * @version 1.0
 * @ClassName TestProxy
 * @Description
 * @Date 2022-08-03 9:08
 */
public class TestProxy {
    public static void main(String[] args) {
//        Proxy proxy = new Proxy();
//        String result = proxy.sing("如果我开挖掘机你还会爱我吗");
//        System.out.println(result);

//        BaiBai baiBai = new BaiBai();
//        IStar jj = (IStar) Proxy.newProxyInstance(baiBai.getClass().getClassLoader(), baiBai.getClass().getInterfaces(), new InvocationHandler() {
//            @Override
//            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                if ("sing".equals(method.getName())) {
//                    System.out.println("找场地");
//                    String result = (String) method.invoke(baiBai, args);
//                    System.out.println("庆功宴");
//                    return result;
//                } else if ("play".equals(method.getName())) {
//                    System.out.println("找场地2");
//                    String result = (String) method.invoke(baiBai, args);
//                    System.out.println("庆功宴2");
//                }
//                return null;
//            }
//        });

//        jj.sing("如果我开挖掘机你还会爱我吗");
//        jj.play("泰囧");

//        Son son = new Son();
//        son.sing("如果我开挖掘机你还会爱我吗");
//        son.play("泰囧");

        BaiBai baiBai = new BaiBai();
        BaiBai jj = (BaiBai) Enhancer.create(baiBai.getClass(), new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                String result = null;
                try {
                    System.out.println("找场地前置增强");
                    result = (String) method.invoke(baiBai, args);
                    System.out.println("庆功宴后置增强");
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("异常增强");
                } finally {
                    System.out.println("最终增强");
                }
                return result;
            }
        });

//        jj.sing("如果我开挖掘机你还会爱我吗");
        jj.play("泰囧");
    }
}

//interface IStar {
//    String sing(String song);
//    void play(String movie);
//}

class BaiBai /*implements IStar*/ {

//    @Override
    public String sing(String song) {
        System.out.println("唱歌:" + song);
        return "100万";
    }

//    @Override
    public void play(String movie) {
        System.out.println("演电影:" + movie);
//        int i = 1/0;
    }
}

//class Son extends BaiBai {
//    @Override
//    public String sing(String song) {
//        System.out.println("找场地");
//        String result = super.sing(song);
//        System.out.println("庆功宴");
//        return result;
//    }
//
//    @Override
//    public void play(String movie) {
//        System.out.println("找场地2");
//        super.play(movie);
//        System.out.println("庆功宴2");
//    }
//}

//class Proxy implements IStar {
//
//    private BaiBai baiBai;
//
////    public Proxy(BaiBai baiBai) {
////        this.baiBai = baiBai;
////    }
//
//
//    public Proxy() {
//        this.baiBai = new BaiBai();
//    }
//
//    @Override
//    public String sing(String song) {
//        System.out.println("找场地");
//        String result = baiBai.sing(song);
//        System.out.println("庆功宴");
//        return result;
//    }
//}
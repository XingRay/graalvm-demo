package com.xingray.nativeimage.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyApplication {
    public static void main(String[] args) {

        Dog dog = new Dog();
        Cat cat = new Cat();
        Animal animal = (Animal) Proxy.newProxyInstance(ProxyApplication.class.getClassLoader(), new Class[]{Animal.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (method.getName().equals("hello")) {
                    return dog.hello() + " ... " + cat.hello();
                }
                return null;
            }
        });

        System.out.println(animal.hello());
    }
}
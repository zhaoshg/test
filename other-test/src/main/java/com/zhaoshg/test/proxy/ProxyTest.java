package com.zhaoshg.test.proxy;

public class ProxyTest {
    public static void main(String[] args) throws InterruptedException {
//        UserService userService = ProxyFactory.getUserServiceCglib();
//        UserService userService = ProxyFactory.getUserServiceStaticProxy();
        UserService userService = ProxyFactory.getUserServiceJdkProxy();
        userService.addUser(new User("zhaoshg","ssssss"));
        System.out.println("------------------------------------------------------------------------------");
        userService.login(new User("zhaoshg","ssssss"));
    }
}

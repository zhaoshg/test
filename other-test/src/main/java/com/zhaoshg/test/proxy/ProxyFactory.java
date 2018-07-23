package com.zhaoshg.test.proxy;

public class ProxyFactory {
    public static UserService getUserServiceCglib() {
        var proxy = new UserServiceCglibProxy();
        //通过生成子类的方式创建代理类
        UserService service = (UserService) proxy.getProxy(UserServiceImpl.class);
        return service;
    }

    public static UserService getUserServiceJdkProxy() {
        UserService userServiceImpl = new UserServiceImpl();
        UserServiceJdKProxy proxy = new UserServiceJdKProxy();
        UserService userService = (UserService) proxy.bind(userServiceImpl);
        return userService;
    }

    public static UserService getUserServiceStaticProxy() {
        UserService userService = new UserStaticProxy(new UserServiceImpl());
        return userService;
    }
}

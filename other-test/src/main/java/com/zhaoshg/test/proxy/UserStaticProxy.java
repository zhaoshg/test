package com.zhaoshg.test.proxy;

public class UserStaticProxy implements UserService {

    private UserService userService;

    public UserStaticProxy(UserServiceImpl userService) {
        this.userService = userService;
    }

    @Override
    public void addUser(User user) {
        System.out.println("UserStaticProxy addUser prior **********");
        userService.addUser(user);
        System.out.println("UserStaticProxy addUser posterior **********");
    }

    @Override
    public boolean login(User user) {

        System.out.println("UserStaticProxy addUser prior **********");
        boolean res = userService.login(user);
        System.out.println("UserStaticProxy addUser posterior **********");
        return res;
    }
}
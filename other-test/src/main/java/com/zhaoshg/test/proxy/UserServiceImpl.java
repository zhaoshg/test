package com.zhaoshg.test.proxy;

public class UserServiceImpl implements UserService {
    @Override
    public void addUser(User user) {
        System.out.println("add User :" + user.toString());
    }

    @Override
    public boolean login(User user) {
        boolean res = Boolean.TRUE;
        if (user == null || !user.getUsername().equalsIgnoreCase("zhaoshg") || !user.getPassword().equalsIgnoreCase("ssssss"))
            res = Boolean.FALSE;
        System.out.println("the result is " + res);
        return res;
    }
}
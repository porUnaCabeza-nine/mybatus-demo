package com.controller;

import com.entity.User;

/**
 * @description:
 * @author: ljc
 * @createDate: 2019/12/13 14:07
 */
public class Test3 {

    public static void main(String[] args) {
        User user = new User();
        user.setAddress("2");
        if ("2".equals(user.getAddress())) {
            System.out.println("等于2");
        }
    }
}

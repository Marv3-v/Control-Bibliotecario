/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tests;

import com.daos.UserDao;
import com.models.User;
import java.sql.SQLException;

/**
 *
 * @author User
 */
public class TestGetC {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        String userName = "admin";
        User user = UserDao.getUser(userName);
        System.out.println(user.getPassword());
    }
}

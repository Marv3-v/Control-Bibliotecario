/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tests;

import com.models.Customer;

/**
 *
 * @author User
 */
public class ShowCustomer {
    public static void main(String[] args) {
        
        Customer c = new Customer("Robert");
        System.out.println(c.getName());
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tests;

import com.daos.CustomerDao;
import com.models.Customer;

/**
 *
 * @author User
 */
public class AddCustomer {
    
    public static void main(String[] args) throws ClassNotFoundException {
        Customer c = new Customer("Charlie","la","char@gmail.com");
        
        boolean yes = CustomerDao.addCustomer(c);
        
        if(yes) {
            System.out.println("Query Ok!");
        } else {
            System.out.println("No funcionó");
        }
    }
    
}

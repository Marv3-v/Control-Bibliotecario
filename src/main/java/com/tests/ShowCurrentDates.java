/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tests;

import com.daos.RentedDao;
import com.models.Rented;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class ShowCurrentDates {
    
    public static void main(String[] args) throws ClassNotFoundException {
        
        List<Rented> rents;
        rents = RentedDao.getCurrentRents("2");
        for(Rented r : rents){
            System.out.println("Titulo: " + r.getBook().getTitle());
            System.out.println("Fecha inicial: " + r.getStartDate());
            System.out.println("Final: " + r.getFinalDate());
            System.out.println("Cliente:" + r.getCustomerName());
        }
         
       
    }
}

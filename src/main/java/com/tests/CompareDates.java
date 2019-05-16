/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tests;

import com.daos.RentedDao;
import com.models.Rented;
import java.sql.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author User
 */
public class CompareDates {
    
        
        
    public static void main(String[] args) throws ClassNotFoundException {
        
        
        
        List<Rented> rents = RentedDao.getPreviousRents("5");
        for(Rented r: rents) {
            System.out.println(r.getFinalDate());
            System.out.println(r.getReceivedDate());
            long days = RentedDao.getDifferenceDays(Date.valueOf(r.getFinalDate()),Date.valueOf(r.getReceivedDate()));
            System.out.println("Días de diferencia " + days);
           
            int mora = (int) (days * 20);
            
          
            System.out.println("Esta es tu mora:" + mora);
        }
    }
}

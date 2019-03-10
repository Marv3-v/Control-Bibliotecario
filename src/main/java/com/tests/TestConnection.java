/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tests;

import com.conexion.Conexion;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class TestConnection {
    
    public static void main(String[] args) {
        try {
            
            Conexion.getConnection();
            System.out.println("Exito, funciona Marv");
        } catch (SQLException ex) {
            System.out.println("Excepción SQL - error: " +  ex.getMessage());
            Logger.getLogger(TestConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFound - error: " +  ex.getMessage());
            Logger.getLogger(TestConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

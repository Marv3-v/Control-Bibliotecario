/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase Java, sirve para conectar la app web con la base de datos
 * @author User
 */
public class Conexion {
     private static Connection con;
    private static String stringConexion;
    private static boolean connected = false;
    
    /**
     * 
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
         Class.forName("com.mysql.jdbc.Driver");
        stringConexion = "jdbc:mysql://localhost/biblioteca?useSSL=FALSE&allowPublicKeyRetrieval=true";
        con = DriverManager.getConnection(stringConexion,"root","1234");
        connected = true; 
        return con;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daos;

    import com.conexion.Conexion;
    import com.models.Customer;
    import java.sql.Connection;
    import java.sql.PreparedStatement;
    import java.sql.ResultSet;
    import java.sql.SQLException;
    import java.util.ArrayList;
    import java.util.List;
/**
 *
 * @author User
 */
public class CustomerDao {
    
    
    //    Método para añadir un cliente
    public static boolean addCustomer(Customer customer) throws ClassNotFoundException {
        Connection con;
        PreparedStatement ps;
        String  sql = "insert into costumer values (null,?,?,?)";
        try {
            con = Conexion.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, customer.getName());
            ps.setString(2, customer.getAddress());
            ps.setString(3, customer.getEmail());
            ps.executeUpdate();
            con.close();
            ps.close();
            return true;
            
        } catch(SQLException e) {
            System.out.println("Error de inserción el CustomerDao : " + e.getMessage());
            return false;
        }
    }

}

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
        String  sql = "insert into customer values (null,?,?,?)";
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
    
        public static List<Customer> getAll() throws SQLException, ClassNotFoundException {
        List<Customer> customerList;
        customerList = new ArrayList<>();

        String sql = "select * from customer";

        try {
            Connection con = Conexion.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                customerList.add(new Customer(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("address"),
                        rs.getString("email")
                            )
                );
            }
            return customerList;

        } catch (SQLException e) {
            System.out.println(e + "Error: " + e);
            return null;
        }
    }
        
    public static List<Customer> findCustomer(String name) throws ClassNotFoundException {
        Connection con;
        PreparedStatement ps;
        ResultSet rs;
        List<Customer> customers;
        customers = new ArrayList<>();
        String sql = "select * from customer where name='"+name+"%'";
        
        try {
            con = Conexion.getConnection();
            ps = con.prepareStatement(sql);
//            ps.setString(1, name);
            rs = ps.executeQuery();
            int i = 1;
            while(rs.next()) {          
//                if((i%2)!=0) {
                
                    customers.add(
                           new Customer(
                                rs.getInt("id"),
                                rs.getString("name"),
                                rs.getString("address"),
                                rs.getString("email")
                           )
                    );
//                }
            }
            return customers;
        } catch(SQLException e) {
            System.out.println("Error en el Dao findCustomer: " + e.getMessage());
            return null;
        }
    }

}

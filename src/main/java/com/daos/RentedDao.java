/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daos;

import com.conexion.Conexion;
import com.models.Book;
import com.models.Customer;
import com.models.Rented;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class RentedDao {
    
    public static boolean add(Rented rented) throws SQLException, ClassNotFoundException {
        Connection con;
        String sql = "insert into rented values(null,?,?,?,?,?,null,?,null)";
        PreparedStatement ps;
        
        try {
            
            con = Conexion.getConnection();
            ps = con.prepareStatement(sql);
            ps.setDate(1,Date.valueOf(rented.getStart_date()));
            ps.setDate(2,Date.valueOf(rented.getFinal_date()));
            ps.setInt(3,rented.getIdBook());
            ps.setInt(4, rented.getIdCustomer());
            ps.setInt(5, rented.getPayment());
            ps.setBoolean(6, true);
            ps.executeUpdate();
            ps.close();   
            con.close();
            return true;
            
        } catch(SQLException e) {
            System.out.println("Error al insertar, es: " + e.getMessage());
            return false;
        }
        
    }
    
    
    /**
     * 
     * @param newAvailable
     * @param idBook
     * @return
     * Método que se procesa posteriormente de rentBook para disminuir una copia del libro en DISPONIBLES
     */
    public static boolean updateAvailable(int newAvailable, String idBook) throws ClassNotFoundException {
        Connection con;
        PreparedStatement ps;
        String sql = "update book SET available_units=? where id=?";
        
        try {
            con = Conexion.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, newAvailable);
            ps.setString(2, idBook);
            ps.executeUpdate();
            ps.close();
            con.close();
            return true;
        } catch(SQLException e) {
            System.out.println("Error al restar una unidad Disponible DAO" + e.getMessage());
            return false;
        }
    }
    
    
//    método finishRent() que actualizará los campos, Fecha Recibido, si es true o false y la mora
//    Modificar el isReceived true or false en DATABASE
    
    /**
     * Método que termina con la renta y actualiza el estado isReceived y la fecha de recibido
     * @param renta
     * @return
     * @throws ClassNotFoundException 
     */
    public static boolean finishRent(Rented renta) throws ClassNotFoundException {
        Connection con;
        PreparedStatement ps;
        String sql ="UPDATE rented SET received_date=?, is_received=?";
        
        try {
            con = Conexion.getConnection();
            ps = con.prepareStatement(sql);
            ps.setDate(1, Date.valueOf(r.getReceivedDate()));
            ps.setBoolean(2, r.getIsReceived());
            ps.executeUpdate();
            ps.close();
            con.close();
            return true;
        } catch(SQLException e) {
            System.out.println("Error en el Dao finishRent: " + e.getMessage());
            return false;
        }
    }
//    Hacer método, bookReceived() aumentará un valor a Disponibles
    
    
//    Hacer método compareDates() que verá la fecha del libro recibido con la fecha final de renta
//    Si son iguales, entonces la mora es 0
//     Si no son iguales, contar los dias de diferencia y tomar Q10 por día de retraso
    
    /**
     * Metodo que obtiene dos tipos de renta segun el parámetro, 
     * si es TRUE: obtendrá los libros rentados anteriormente
     * si es FALSE: obtendrá los libros rentados que no se han devuelto
     * @param status
     * @return
     * @throws ClassNotFoundException 
     */
    public static List<Rented> getRents(boolean status) throws ClassNotFoundException {
        Connection con;
        PreparedStatement ps;
        ResultSet rs;
        List<Rented> rents = new ArrayList<>();
        String sql = "select * from rented where is_received=?";
        
        try {
            con = Conexion.getConnection();
            ps = con.prepareStatement(sql);
            ps.setBoolean(1, status);
            rs = ps.executeQuery();
            while(rs.next()) {
                rents.add(new Rented(
                        rs.getInt("id"),
                        rs.getDate("start_date"),
                        rs.getDate("final_date"),
                            new Book(
                                    rs.getInt("id_book")
                            ),
                            new Customer(
                                    rs.getInt("id_customer")
                            ),
                        rs.getInt("rent_cost"),
                        rs.getInt("penalty_fee"),
                        rs.getDate("received_date"),
                        rs.getBoolean("is_received")
                ));
            }
            return rents;
        }catch(SQLException e) {
            System.out.println("Error Dao, GetRents:"  + e.getMessage());
            return null;
        }
    } 
    
    /**
     * Método para obtener el detalle de una renta, todos los datos
     * @param idRent
     * @return
     * @throws ClassNotFoundException 
     */
    public static Rented getRent(String idRent) throws ClassNotFoundException{
        Connection con;
        PreparedStatement ps;
        ResultSet rs;
        String sql = "select * from rented where id=?";
        
        try {
            con = Conexion.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, idRent);
            rs = ps.executeQuery();
            rs.first();
            Rented r = new Rented(
                        rs.getInt("id"),
                        rs.getDate("start_date"),
                        rs.getDate("final_date"),
                            new Book(
                                    rs.getInt("id_book")
                            ),
                            new Customer(
                                    rs.getInt("id_customer")
                            ),
                        rs.getInt("rent_cost"),
                        rs.getInt("penalty_fee"),
                        rs.getDate("received_date"),
                        rs.getBoolean("is_received")
            );
            return r;
        } catch(SQLException e) {
            System.out.println("Error al obtener una renta: DAO " + e.getMessage());
            return null;
        }
    }
    
}

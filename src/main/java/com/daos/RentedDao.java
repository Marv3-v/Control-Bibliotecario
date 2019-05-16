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
import java.util.concurrent.TimeUnit;

/**
 *
 * @author User
 */
public class RentedDao {

    /**
     * Método que sirve para agregar el objeto Renta, es el primero para
     * ejecutar un renta, antes trabajar el método de la clase getBook para
     * saber las unidades
     *
     * @param rented
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static boolean add(Rented rented) throws SQLException, ClassNotFoundException {
        Connection con;
        String sql = "insert into rented values(null,?,?,?,?,?,?,null,?)";
        PreparedStatement ps;

        try {

            con = Conexion.getConnection();
            ps = con.prepareStatement(sql);
            ps.setDate(1, Date.valueOf(rented.getStartDate()));
            ps.setDate(2, Date.valueOf(rented.getFinalDate()));
            ps.setInt(3, rented.getIdBook());
            ps.setInt(4, rented.
                    getIdCustomer());
            ps.setInt(5, rented.getPayment());
            ps.setInt(6, 0);
            ps.setBoolean(7, false);
            ps.executeUpdate();
            ps.close();
            con.close();
            return true;

        } catch (SQLException e) {
            System.out.println("Error al insertar, es: " + e.getMessage());
            return false;
        }

    }

    /**
     *
     * Método que se procesa posteriormente de rentBook, es el segundo método,
     * para disminuir una copia del libro en DISPONIBLES
     *
     * @param newAvailable
     * @param idBook
     * @return
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
        } catch (SQLException e) {
            System.out.println("Error al restar una unidad Disponible DAO" + e.getMessage());
            return false;
        }
    }

//    método finishRent() que actualizará los campos, Fecha Recibido, si es true o false y la mora
//    Modificar el isReceived true or false en DATABASE
    /**
     * Método que termina con la renta y actualiza el estado isReceived y la
     * fecha de recibido
     *
     * @param renta
     * @return
     * @throws ClassNotFoundException
     */
    public static boolean finishRent(Rented renta) throws ClassNotFoundException {
        Connection con;
        PreparedStatement ps;
        String sql = "UPDATE rented SET received_date=?, is_received=?";

        try {
            con = Conexion.getConnection();
            ps = con.prepareStatement(sql);
            ps.setDate(1, Date.valueOf(renta.getReceivedDate()));
            ps.setBoolean(2, renta.getIsReceived());
            ps.executeUpdate();
            ps.close();
            con.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Error en el Dao finishRent: " + e.getMessage());
            return false;
        }
    }
//    Hacer método, bookReceived() aumentará un valor a Disponibles

//    Hacer método compareDates() que verá la fecha del libro recibido con la fecha final de renta
//    Si son iguales, entonces la mora es 0
//     Si no son iguales, contar los dias de diferencia y tomar Q10 por día de retraso
    /**
     * Metodo que obtiene dos tipos de renta segun el parámetro, si es FALSE:
     * obtendrá los libros rentados actualmente
     *
     * @param status
     * @return
     * @throws ClassNotFoundException
     */
    public static List<Rented> getCurrentRents(String idBook) throws ClassNotFoundException {
        Connection con;
        PreparedStatement ps;
        ResultSet rs;
        List<Rented> rents = new ArrayList<>();

        String sql = "select rented.id, rented.start_date, rented.final_date, "
                + "book.id idBook, book.title, "
                + "customer.id idCust, customer.name, "
                + "rented.rent_cost, "
                + "rented.is_received from rented, book, customer "
                + "where rented.id_book = book.id "
                + "and rented.id_customer = customer.id "
                + "and is_received=false "
                + "and book.id=?";

        try {
            con = Conexion.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, idBook);
            rs = ps.executeQuery();
            while (rs.next()) {
                rents.add(
                        new Rented(
                                rs.getInt("id"),
                                rs.getDate("start_date"),
                                rs.getDate("final_date"),
                                new Book(
                                        rs.getInt("idBook"),
                                        rs.getString("title")
                                ),
                                new Customer(
                                        rs.getInt("idCust"),
                                        rs.getString("name")
                                ),
                                rs.getInt("rent_cost"),
                                rs.getBoolean("is_received")
                        ));
            }
            return rents;
        } catch (SQLException e) {
            System.out.println("Error Dao, GetRents:" + e.getMessage());
            return null;
        }
    }

    /**
     * Método que sirve para obtener todas las rentas donde el libro ya ha sido
     * devuelto
     *
     * @return
     * @throws ClassNotFoundException
     */
    public static List<Rented> getPreviousRents(String idBook) throws ClassNotFoundException {
        Connection con;
        PreparedStatement ps;
        ResultSet rs;
        List<Rented> rents = new ArrayList<>();

        String sql = "select rented.id, rented.start_date, rented.final_date, "
                + "book.id idBook, book.title, "
                + "customer.id idCust, customer.name, "
                + "rented.rent_cost, rented.penalty_fee, rented.received_date, "
                + "rented.is_received from rented, book, customer "
                + "where rented.id_book = book.id "
                + "and rented.id_customer = customer.id "
                + "and is_received=true "
                + "and book.id=?";

        try {
            con = Conexion.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, idBook);
            rs = ps.executeQuery();
            while (rs.next()) {
                rents.add(
                        new Rented(
                                rs.getInt("id"),
                                rs.getDate("start_date"),
                                rs.getDate("final_date"),
                                new Book(
                                        rs.getInt("idBook"),
                                        rs.getString("title")
                                ),
                                new Customer(
                                        rs.getInt("idCust"),
                                        rs.getString("name")
                                ),
                                rs.getInt("rent_cost"),
                                rs.getInt("penalty_fee"),
                                rs.getDate("received_date"),
                                rs.getBoolean("is_received")
                        ));
            }
            ps.close();
            con.close();
            rs.close();
            return rents;
        } catch (SQLException e) {
            System.out.println("Error en método previousRents: " + e.getMessage());
            return null;
        }
    }

    /**
     * Método que al regresar el libro, actualiza si existiera una mora en tal libro con tal cliente
     * @param penalty_fee
     * @param idRent
     * @return
     * @throws ClassNotFoundException 
     */
    public static boolean updatePenalty(int penalty_fee, String idRent) throws ClassNotFoundException {
        Connection con;
        PreparedStatement ps;
        String sql = "update rented SET penalty_fee=? where id=?";

        try {
            con = Conexion.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, penalty_fee);
            ps.setString(2, idRent);
            ps.executeUpdate();
            ps.close();
            con.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al actualizar la mora DAO" + e.getMessage());
            return false;
        }
    }

    /**
     * Método para obtener el detalle de una renta, todos los datos
     *
     * @param idRent
     * @return
     * @throws ClassNotFoundException
     */
    public static Rented getRentDetail(String idRent) throws ClassNotFoundException {
        Connection con;
        PreparedStatement ps;
        ResultSet rs;

        String sql = "select rented.id, rented.start_date, rented.final_date, "
                + "book.id idBook, book.title, "
                + "customer.id idCust, customer.name, "
                + "rented.rent_cost, rented.penalty_fee, "
                + "rented.is_received from rented, book, customer "
                + "where rented.id_book = book.id "
                + "and rented.id_customer = customer.id "
                + "and is_received=false "
                + "and rented.id=?";

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
                            rs.getInt("idBook"),
                            rs.getString("title")
                    ),
                    new Customer(
                            rs.getInt("idCust"),
                            rs.getString("name")
                    ),
                    rs.getInt("rent_cost"),
                    rs.getBoolean("is_received")
            );
            return r;
        } catch (SQLException e) {
            System.out.println("Error al obtener una renta: DAO " + e.getMessage());
            return null;
        }
    }

    public static Rented getRent(String idRent) throws ClassNotFoundException {
        Connection con;
        PreparedStatement ps;
        ResultSet rs;

        String sql = "select rented.id, rented.start_date, rented.final_date, "
                + "book.id idBook, book.title, book.available_units, "
                + "customer.id idCust, customer.name, "
                + "rented.rent_cost, rented.penalty_fee, "
                + "rented.is_received from rented, book, customer "
                + "where rented.id_book = book.id "
                + "and rented.id_customer = customer.id "
                + "and is_received=true "
                + "and rented.id=?";

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
                            rs.getInt("idBook"),
                            rs.getString("title"),
                            rs.getInt("available_units")
                    ),
                    new Customer(
                            rs.getInt("idCust"),
                            rs.getString("name")
                    ),
                    rs.getInt("rent_cost"),
                    rs.getBoolean("is_received")
            );
            return r;
        } catch (SQLException e) {
            System.out.println("Error al obtener una renta: DAO " + e.getMessage());
            return null;
        }
    }

    
    /**
     * Método de RentedDao para añadir y actualizar la fecha de entrega de un libro
     * @param rent
     * @return
     * @throws ClassNotFoundException 
     */
    public static boolean addReceivedDate(Rented rent) throws ClassNotFoundException {
        Connection con;
        PreparedStatement ps;
        String sql = "update rented SET received_date=?, is_received=true where id=?";

        try {
            con = Conexion.getConnection();
            ps = con.prepareStatement(sql);
            ps.setDate(1, Date.valueOf(rent.getReceivedDate()));
            ps.setInt(2, rent.getId());
            ps.executeUpdate();
            ps.close();
            con.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al agregar la fecha de entrega DAO" + e.getMessage());
            return false;
        }
    }

    /**
     * Método para comparar los días entre la fecha final de renta y la fecha de entrega
     * @param d1
     * @param d2
     * @return 
     */
    public static long getDifferenceDays(Date d1, Date d2) {
        long diff = d2.getTime() - d1.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

}

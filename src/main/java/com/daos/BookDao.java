/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daos;

import com.conexion.Conexion;
import com.models.Book;
import com.models.Topic;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 * 
 */

/*
 * Clase que contiene los métodos CRUD, para administrar libros
 */
public class BookDao {
    
//    Método para añadir un libro 
    public static boolean addBook(Book book) throws ClassNotFoundException {
        Connection con;
        PreparedStatement ps;
        String sql = "insert into book values (null,?,?,?,?)";
        try {
            con = Conexion.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, book.getTitle());
            ps.setString(2, book.getDescription());
            ps.setBoolean(3, book.isRentedNow());
            ps.setInt(4, book.getTopicI());
            ps.executeUpdate();
            con.close();
            ps.close();
            return true;
            
        } catch(SQLException e) {
            System.out.println("Error de inserción el BookDao : " + e.getMessage());
            return false;
        }
    }
    
    public static List<Book> getBooks() throws ClassNotFoundException {
        Connection con;
        PreparedStatement ps;
        ResultSet rs;
        List<Book> books = new ArrayList<>();
        String sql = "SELECT book.id, book.title, topic.name FROM book, topic WHERE book.id_topic = topic.id";
        
        try {
            con = Conexion.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()) {
                books.add(new Book(
                        rs.getInt("id"),
                        rs.getString("title"),
                        new Topic(
                            rs.getInt("id"),
                            rs.getString("name")
                        )
                    ));
            }
            ps.close();
            rs.close();
            con.close();
            return books;
            
        } catch (SQLException ex) {
            System.out.println("Error en obtener los libros: " + ex.getMessage());
            return null;
        }
        
    }
    
    public static List<Book> getTopicBooks(String idTopic) throws ClassNotFoundException {
        Connection con;
        PreparedStatement ps;
        ResultSet rs;
        List<Book> topicBooks = new ArrayList<>();
        String sql =  "SELECT book.id, book.title, topic.name "
                    + "FROM book, topic "
                    + "WHERE book.id_topic = topic.id "
                    + "AND topic.id=?";
        try {
            con = Conexion.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, idTopic);
            rs = ps.executeQuery();
            
            while(rs.next()) {
                topicBooks.add(
                        new Book(
                                rs.getInt("id"),
                                rs.getString("title"),
                        new Topic(
                                rs.getInt("id"),
                                rs.getString("name")
                        )
                        ));
            }
            ps.close();
            rs.close();
            con.close();
            return topicBooks;
        } catch(SQLException e) {
            System.out.println("Error al mostrar libros segun su tema: " + e.getMessage());
            return null;
        }
    }
    
    
    public static Book getBook(String idBook) throws ClassNotFoundException {
       Connection con;
       PreparedStatement ps;
       ResultSet rs;
       String sql = "select book.id idBook, book.title, book.description, book.rented_now, topic.id, topic.name, topic.description " +
                    "from book,topic " +
                    "where book.id_topic = topic.id " + 
                    "and book.id =?";
       try {
           con = Conexion.getConnection();
           ps = con.prepareStatement(sql);
           ps.setString(1, idBook);
           rs = ps.executeQuery();
           rs.first();
           
           Book book = new Book(
                   rs.getInt("idBook"),
                   rs.getString("title"),
                   rs.getString("description"),
                   rs.getBoolean("rented_now"),
                   new Topic(
                           rs.getInt("id"),
                           rs.getString("name"),
                           rs.getString("description")
                   ));
           ps.close();
           con.close();
           rs.close();
           return book;
           
       } catch (SQLException e) {
           System.out.println("ERROR AL MOSTRAR DETALLE: " + e.getMessage());
           return null;
       }
        
    }
    
    public static boolean updateBook(String idBook, String newTitle, String newDesc, String newIdTopic) throws ClassNotFoundException {
        Connection con;
        PreparedStatement ps;
        String sql = "UPDATE book SET title=?, description =?, id_topic=? WHERE id=?";
        try {
            con = Conexion.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1,newTitle);
            ps.setString(2,newDesc);
            ps.setString(3,newIdTopic);
            ps.setString(4,idBook);
            ps.executeUpdate();
            ps.close();
            con.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al actualizar libro: " + e.getMessage());
            return false;
        }
    }
 
}

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

/**
 * Clase que contiene los métodos CRUD, para administrar libros
 * @author User
 */
public class BookDao {
    
//    Método para añadir un libro
    /**
     * Método de la clase Book, utilizado para la creación de un libro
     * necesita un objeto book
     * @param book
     * @return
     * @throws ClassNotFoundException 
     */
    public static boolean addBook(Book book) throws ClassNotFoundException {
        Connection con;
        PreparedStatement ps;
        String sql = "insert into book values(null,?,?,?,?,?,?)";
        try {
            con = Conexion.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, book.getTitle());
            ps.setString(2, book.getDescription());
            ps.setInt(3, book.getTopicI());
            ps.setBoolean(4, book.isActive());
            ps.setInt(5, book.getUnits());
            ps.setInt(6, book.getAvailableUnits());
            ps.executeUpdate();
            con.close();
            ps.close();
            return true;
            
        } catch(SQLException e) {
            System.out.println("Error de inserción el BookDao : " + e.getMessage());
            return false;
        }
    }
    
    /**
     * método de la clase Book, sirve para obtener la lista completa de todos los libros
     * Tipo List<Book>
     * @return
     * @throws ClassNotFoundException 
     */
    public static List<Book> getBooks() throws ClassNotFoundException {
        Connection con;
        PreparedStatement ps;
        ResultSet rs;
        List<Book> books = new ArrayList<>();
        String sql = "SELECT book.id, book.title, book.description, topic.id_topic, topic.name FROM book, topic WHERE book.id_topic = topic.id_topic";
        
        try {
            con = Conexion.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()) {
                books.add(new Book(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("description"),
                        new Topic(
                            rs.getInt("id_topic"),
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
    
    /**
     * Método de la clase Book, sirve para filtrar los libros según el tema
     * requiere un String idTopic
     * @param idTopic
     * @return
     * @throws ClassNotFoundException 
     */
    public static List<Book> getTopicBooks(String idTopic) throws ClassNotFoundException {
        Connection con;
        PreparedStatement ps;
        ResultSet rs;
        List<Book> topicBooks = new ArrayList<>();
        String sql =  "SELECT book.id, book.title, topic.name "
                    + "FROM book, topic "
                    + "WHERE book.id_topic = topic.id_topic "
                    + "AND topic.id_topic=?";
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
    
    /**
     * Método de la clase Book, sirve para obtener el detalle de un libro en específico
     * @param idBook
     * @return
     * @throws ClassNotFoundException 
     */
    public static Book getBook(String idBook) throws ClassNotFoundException {
       Connection con;
       PreparedStatement ps;
       ResultSet rs;
       String sql = "select book.id id_book, book.title, book.description, book.units, book.available_units, book.is_active, topic.id_topic, topic.name " +
                    "from book,topic " +
                    "where book.id_topic = topic.id_topic " + 
                    "and book.id =?";
       try {
           con = Conexion.getConnection();
           ps = con.prepareStatement(sql);
           ps.setString(1, idBook);
           rs = ps.executeQuery();
           rs.first();
           
           Book book = new Book(
                   rs.getInt("id_book"),
                   rs.getString("title"),
                   rs.getString("description"),
                   rs.getInt("units"),
                   rs.getInt("available_units"),
                   rs.getBoolean("is_active"),
                   new Topic(
                           rs.getInt("id_topic"),
                           rs.getString("name")
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
    
    /**
     * Método de la clase Book, utilizado para actualizar un libro
     * @param idBook
     * @param newTitle
     * @param newDesc
     * @param newIdTopic
     * @return
     * @throws ClassNotFoundException 
     */
    public static boolean updateBook(String idBook, String newTitle, String newDesc, String newIdTopic) throws ClassNotFoundException {
        Connection con;
        PreparedStatement ps;
        String sql = "UPDATE book SET title=?, description=?, id_topic=? WHERE id=?";
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
//    En el servlet debo sumar las unidades actuales con las nuevas, lo mismo para las disponibles
//    Hacer primero la consulta de libros para actualizar las unidades
//    Este newUnits ya hizo la operación para solo actualizar todo el campo, ya sumó o restó
    
    /**
     * Método que sirve para agregar unidades nuevos según el libro, antes se debe realizar la operación para sumar con las anteriores
     * @param newUnits
     * @param newAvailables
     * @param idBook
     * @return
     * @throws ClassNotFoundException 
     */
    public static boolean updateUnits(int newUnits, int newAvailables, String idBook) throws ClassNotFoundException {
        Connection con;
        PreparedStatement ps;
        String sql = "update book set units=?, available_units=? where id=?";
        
        try{
            con = Conexion.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, newUnits);
            ps.setInt(2, newAvailables);
            ps.setString(3, idBook);
            ps.executeUpdate();
            ps.close();
            con.close();
            return true;
        } catch(SQLException e) {
            System.out.println("Error al actualizar las unidades: " + e.getMessage());
            return false;
        }
    }
    
//    Hacer posible metodo de eliminar unidades de libros
//    Solo eliminará las unidades, si existen al menos una en Disponibles.
//    Si quiere eliminar 3 
//    Primero ve las DISPONIBLES
//      Si hay 
//          entonces mirará el número...
//          eliminar máximo el número de unidades DISPONIBLES
//      No hya
//          No podrá eliminar
 
}

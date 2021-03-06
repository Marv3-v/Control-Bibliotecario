/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daos;

import com.conexion.Conexion;
import com.models.Topic;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase topicDao para el crud del libro según su tema
 *
 * @author User
 */
public class TopicDao {

    /**
     * Método para añadir un tema / categoria para un libro
     *
     * @param topic
     * @return
     * @throws ClassNotFoundException
     */
    public static boolean addTopic(Topic topic) throws ClassNotFoundException {
        Connection con;
        PreparedStatement ps;
        String sql = "insert into topic values(null,?)";
        try {
            con = Conexion.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, topic.getName());
            ps.executeUpdate();
            ps.close();
            con.close();

            return true;
        } catch (SQLException e) {
            System.out.println("ERROR METODO ADDTOPIC: " + e.getMessage());
            return false;
        }
    }

    /**
     * Método que obtiene toda la lista de temas
     *
     * @return
     * @throws ClassNotFoundException
     */
    public static List<Topic> getTopics() throws ClassNotFoundException {
        Connection con;
        PreparedStatement ps;
        ResultSet rs;
        List<Topic> topics = new ArrayList<>();

        String sql = "select * from topic";
        try {
            con = Conexion.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                topics.add(new Topic(
                        rs.getInt("id_topic"),
                        rs.getString("name")
                ));
            }
            ps.close();
            rs.close();
            con.close();
            return topics;
        } catch (SQLException e) {
            System.out.println("No se pudieron mostrar los temas: " + e.getMessage());
            return null;
        }
    }

}

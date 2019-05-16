/*
 * Contiene los métodos necesarios para la autenticación de usuarios
 * 
 */
package com.daos;

import com.conexion.Conexion;
import com.models.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author User
 */
public class UserDao {

    /**
     * Método que sirve para obtener el usuario que esta registrado
     *
     * @param userName
     * @return
     * @throws ClassNotFoundException
     */
    public static User getUser(String userName) throws ClassNotFoundException {
        String sql = "SELECT user_name, password FROM user WHERE user_name=?";
        Connection con;
        PreparedStatement stmt;
        ResultSet rs;
        try {
            con = Conexion.getConnection();
            stmt = con.prepareStatement(sql);
            stmt.setString(1, userName);
            rs = stmt.executeQuery();

            rs.first();
            User usuario = new User(
                    rs.getString("user_name"),
                    rs.getString("password")
            );
            stmt.close();
            con.close();
            rs.close();
            return usuario;

        } catch (SQLException e) {
            System.out.println("EL ERROR ES: " + e.getMessage());
            return null;
        }
    }
}

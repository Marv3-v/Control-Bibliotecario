/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controllers;

import com.daos.UserDao;
import com.models.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author User
 */
@WebServlet(name = "LogIn", urlPatterns = {"/LogIn"})
public class LogIn extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        
//        Creamos la sesion
        HttpSession isAuthenticated = request.getSession();
//        Obtenemos los valores de los input de:
//        usuario y contrasena
        String userName, password;
        userName = request.getParameter("usuario").trim();
        password = request.getParameter("contrasena").trim();
//        Datos obtenidos
        System.out.println(userName);
        System.out.println(password);
//        Realizamos la consulta a la base de datos, para saber 
//        si ese usuario existe
        User user = UserDao.getUser(userName);
        
//        Si el usuario es nulo, entonces no existe
        if (user == null) {
            System.out.println("El usuario no existe");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else {
//            Si existe el usuario
            System.out.println("Si existe");
            
            if(password.equals(user.getPassword())) {
//            Usuario y contrasena son correctos    
                System.out.println("Si esta correcto");
//                request.getRequestDispatcher("Books").forward(request, response);
                isAuthenticated.setAttribute("isAuthenticated", true);
//                request.getRequestDispatcher("Books").forward(request,response);
                response.sendRedirect("Books");
            } else {
//                Contrasena incorrecta
                System.out.println("contraseña incorrecta");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
            
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LogIn.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

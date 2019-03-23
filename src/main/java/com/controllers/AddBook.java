/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controllers;

import com.daos.BookDao;
import com.models.Book;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author User
 */
@WebServlet(name = "AddBook", urlPatterns = {"/AddBook"})
public class AddBook extends HttpServlet {

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
        
        String title = request.getParameter("title").trim();
        String desc = request.getParameter("description").trim();
        String topic = request.getParameter("topics").trim();
        String units = request.getParameter("units").trim();
        
        System.out.println("Tema : " + topic);
        System.out.println("Titulo : " + title);
        System.out.println("desc : " + desc);
        System.out.println("units : " + units);
        
        
        if(!title.equals("") && !desc.equals("") && !topic.equals("") && !units.equals("")) {
        
//            Hacer consulta para saber las unidades disponibles y asi operar al actualizar 
            Book book = new Book(title,desc,Integer.parseInt(topic),Integer.parseInt(units), Integer.parseInt(units));
            if(BookDao.addBook(book)) {
                System.out.println("Query ok!");
                  response.sendRedirect("Books");
            } else {
                System.out.println("Error al insertar libro: ");
            }
        } else {
            System.out.println("No puedes ingresar vacío");
            response.sendRedirect("insertBook");
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
            Logger.getLogger(AddBook.class.getName()).log(Level.SEVERE, null, ex);
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

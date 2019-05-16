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
 * Clase Servlet para actualizar las unidades generales
 * @author User
 */
@WebServlet(name = "UpdateUnits", urlPatterns = {"/UpdateUnits"})
public class UpdateUnits extends HttpServlet {

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
        
        String newUnits = request.getParameter("newUnits");
        String id = request.getParameter("id");
        
        Book  b = BookDao.getBook(id);
        System.out.println("Unidades actuales: " + b.getUnits());
        System.out.println("Disponibles: " + b.getAvailableUnits());
        System.out.println("Las que se agregan : " + newUnits);
        
        int finalUnits = b.getUnits() + Integer.parseInt(newUnits);
        int finalAva = b.getAvailableUnits() + Integer.parseInt(newUnits);
        
        System.out.println("Las que se agregaran: " + finalUnits  + " y  " + finalAva);
        
        boolean updated = BookDao.updateUnits(finalUnits, finalAva, id);
        if(updated) {
            System.out.println("Query Ok!");
//            request.getRequestDispatcher("BookDetail?libro="+b.getTitle()+"&id="+id).forward(request, response);
              response.sendRedirect("BookDetail?libro="+b.getTitle()+"&id="+id);
        } else{
            System.out.println("Well, it just didn´t work");
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
            Logger.getLogger(UpdateUnits.class.getName()).log(Level.SEVERE, null, ex);
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

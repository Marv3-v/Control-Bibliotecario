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
@WebServlet(name = "UpdateBook", urlPatterns = {"/UpdateBook"})
public class UpdateBook extends HttpServlet {

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
        
        String idBook = request.getParameter("idB").trim();
        String title = request.getParameter("updatedTitle").trim();
        String desc = request.getParameter("updatedDesc").trim();
        String idTopic;
        String idT = request.getParameter("idT").trim();
        
//        Hacer consulta para saber las unidades disponibles y asi operar al actualizar
        try {
            
        idTopic = request.getParameter("topics").trim();
        
        } catch(Exception e) {
            
            System.out.println("Es nulo asi que le asignamos este valor");
            idTopic = idT;
            System.out.println("Idtopic :" + idTopic);
        }
 
        System.out.println("id: " + idBook +
                            "  titulo : " + title +
                            "  desc: " + desc +
                            "  idTopic: " + idTopic);
        
        if(idBook != null && title != null && desc != null && idTopic != null) {
//            No son nulos 
            if(!" ".equals(idBook) && !"".equals(title) && !"".equals(desc) && !"".equals(idTopic)) {
//            No estan vacíos

                boolean updated = BookDao.updateBook(idBook, title, desc, idTopic);
                if(updated) {
                    System.out.println("Exito!, query Ok!");
//                    request.getRequestDispatcher("BookDetail?libro="+title+"&id="+idBook).forward(request, response);
                      response.sendRedirect("BookDetail?libro="+title+"&id="+idBook);
                } else {
                    System.out.println("Erro");
                }
            }
        } else {
            System.out.println("Datos nulos");
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
            Logger.getLogger(UpdateBook.class.getName()).log(Level.SEVERE, null, ex);
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

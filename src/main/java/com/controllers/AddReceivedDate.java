/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controllers;

import com.daos.RentedDao;
import com.models.Rented;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *Funcionamiento para agregar la fecha de entrega de un libro, y actualiza las unidades disponibles a 1
 * @author User
 */
@WebServlet(name = "AddReceivedDate", urlPatterns = {"/AddReceivedDate"})
public class AddReceivedDate extends HttpServlet {

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

        String receivedDate = request.getParameter("receivedDate");
        String idRent = request.getParameter("idRent");

        Date sqlDate = Date.valueOf(receivedDate);

        boolean updated = RentedDao.addReceivedDate(new Rented(sqlDate, Integer.parseInt(idRent)));
        if (updated) {
            System.out.println("Bien!, funciona");
            System.out.println(idRent);
            Rented r = RentedDao.getRent(idRent);
            System.out.println(r.getBook().getAvailableUnits());
            int newAvailable = r.getBook().getAvailableUnits() + 1;

            boolean updatedA = RentedDao.updateAvailable(newAvailable, Integer.toString(r.getBook().getId()));
            if (updatedA) {
                System.out.println("Bien, ya se le volvío a sumar la unidad");

                response.sendRedirect("BookDetail?title=" + r.getBook().getTitle() + "&id=" + r.getBook().getId());
            } else {
                System.out.println("No se le sumó");
            }
        } else {
            System.out.println("Mal, no funciona");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AddReceivedDate.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(AddReceivedDate.class.getName()).log(Level.SEVERE, null, ex);
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

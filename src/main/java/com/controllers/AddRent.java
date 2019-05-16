/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controllers;

import com.daos.BookDao;
import com.daos.RentedDao;
import com.models.Book;
import com.models.Rented;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *Añade los atributos básicos de una renta y así mismo resta una unidad disponibles a la base de datos
 * @author User
 */
@WebServlet(name = "AddRent", urlPatterns = {"/AddRent"})
public class AddRent extends HttpServlet {

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
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");

        String idBook = request.getParameter("id");
        String idCustomer = request.getParameter("customer");

        String startDate = request.getParameter("startDate");
        String finalDate = request.getParameter("finalDate");
        String payment = request.getParameter("payment");

        Date sqlInicio = Date.valueOf(startDate);
        Date sqlFinal = Date.valueOf(finalDate);

//        No ejecutar hasta asegurarse el número de Disponibles > 0
        Book b = BookDao.getBook(idBook);

//        Primera condición ve si existen las suficientes unidades disponibles
        if (b.getAvailableUnits() > 0) {
            System.out.println("Si hay más de una");

//            Así que añade la renta, las fechas, cliente, libro, costo
            boolean added = RentedDao.add(
                    new Rented(
                            sqlInicio, sqlFinal, Integer.parseInt(idBook),
                            Integer.parseInt(idCustomer), Integer.parseInt(payment)
                    ));
//            Si es correcto el insert
            if (added) {
                System.out.println("Si se agregó la renta");

//                Restará una unidad disponible
//                Se resta una unidad
                int currentA = b.getAvailableUnits();
                int newAvailable = currentA - 1;

//            Así mismo ejecutar el removeAvailable
                boolean updated = RentedDao.updateAvailable(newAvailable, idBook);
                if (updated) {
                    System.out.println("Funcionó todo");
                    request.setAttribute("right", true);
                    response.sendRedirect("BookDetail?libro=" + b.getTitle() + "&id=" + idBook);
//                    request.getRequestDispatcher("BookDetail?libro="+b.getTitle()+"&id="+idBook).forward(request, response);

                } else {
                    System.out.println("No se restó la unidad");
                    request.setAttribute("right", false);
                    response.sendRedirect("BookDetail?libro=" + b.getTitle() + "&id=" + idBook);
                }
            } else {
                request.setAttribute("right", false);
                response.sendRedirect("BookDetail?libro=" + b.getTitle() + "&id=" + idBook);
                System.out.println("No se agregó la renta");
            }
        } else {
            request.setAttribute("right", false);
            response.sendRedirect("BookDetail?libro=" + b.getTitle() + "&id=" + idBook);
//            request.getRequestDispatcher("BookDetail?libro="+b.getTitle()+"&id="+idBook).forward(request, response);
            System.out.println("No tienes las unidades suficientes para rentar");
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
            Logger.getLogger(AddRent.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AddRent.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(AddRent.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AddRent.class.getName()).log(Level.SEVERE, null, ex);
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

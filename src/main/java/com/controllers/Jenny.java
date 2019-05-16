/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author User
 */
@WebServlet(name = "Jenny", urlPatterns = {"/Jenny"})
public class Jenny extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        
//        Este cliente viene de un select, y su <select name="cliente">
//        String cliente = request.getParameter("cliente");
//        Venta v = new Venta(cliente);
////        Este método guardara el cliente verdad que compró, y tambien el dao debe guardar la fecha
//// y todo lo demas de vendedor verdad
//        boolean inserted = VentaDao.añadirVenta(v);
//        
//        if(inserted) {
////            Si lo guarda entonces
////            Este método tendra la consulta que te envie
//            Venta venta = VentaDao.obtenerUltimoRegistro();
//            
//            
////            Ahora el objeto venta tiene el ultimo registro de venta
////          Le añadis todo el constructor (IDDETALLE, 
////                                         IDVENTA"
////                                          que este es el objeto llamado venta.obtenerId()")
//            DetalleVenta = DetalleVentaDao.añadirDetalle();
//            
//            
//        }
        
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
        processRequest(request, response);
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
        processRequest(request, response);
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

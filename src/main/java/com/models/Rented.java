/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;

import java.sql.Date;
import java.time.LocalDate;

/**
 *
 * @author User
 */
public class Rented {
    
    private int id;
    private LocalDate startDate;
    private LocalDate finalDate;
    private int idCustomer;
    private int idBook;
    private int payment;
    private int penaltyFee;
    private LocalDate receivedDate;
    private boolean isReceived;
    private Customer customer;
    private Book book;
    

    public Rented(Date startDate, Date finalDate, int idBook, int idCustomer, int payment) {
       
        this.startDate = startDate.toLocalDate();
        this.finalDate = finalDate.toLocalDate();
        this.idBook = idBook;
        this.idCustomer = idCustomer;
        this.payment = payment;
    }
    
    public Rented(Date receivedDate, int idRent) {
        this.receivedDate = receivedDate.toLocalDate();
        this.id = idRent;
    }
    
    
    public Rented(Customer customer) {
        this.customer = customer;
    }

    public Rented(Date startDate, Date finalDate, Customer customer, Book book) {
        this.startDate = startDate.toLocalDate();
        this.finalDate = finalDate.toLocalDate();
        this.customer = customer;
        this.book = book;
    }

    public Rented(int id, Date startDate, Date finalDate, int idCustomer, int idBook) {
        this.id = id;
        this.startDate = startDate.toLocalDate();
        this.finalDate = finalDate.toLocalDate();
        this.idCustomer = idCustomer;
        this.idBook = idBook;
    }
    
    
    /**
     * Método de la clase Rented que sirve para obtener las rentas que ya han devuelto el libro
     * @param id
     * @param startDate
     * @param finalDate
     * @param book
     * @param customer
     * @param rentCost
     * @param penaltyFee
     * @param receivedDate
     * @param isReceived 
     */
//    public Rented(int id, Date startDate, Date finalDate, Book book, Customer customer, 
//                  int rentCost, boolean isReceived) {
//        this.id = id;
//        this.startDate = startDate.toLocalDate();
//        this.finalDate = finalDate.toLocalDate();
//        this.book = book;
//        this.customer = customer;
//        this.payment = rentCost;
//        this.isReceived = isReceived;
//    }
    
        /**
         * Constructor para obtener la lista de rentas donde el libro ya esta devuelta en la biblioteca
         * @param id
         * @param startDate
         * @param finalDate
         * @param book
         * @param customer
         * @param rentCost
         * @param penaltyFee
         * @param receivedDate
         * @param isReceived 
         */
        public Rented(int id, Date startDate, Date finalDate, Book book, Customer customer, 
                  int rentCost, int penaltyFee, Date receivedDate, boolean isReceived) {
        this.id = id;
        this.startDate = startDate.toLocalDate();
        this.finalDate = finalDate.toLocalDate();
        this.book = book;
        this.customer = customer;
        this.payment = rentCost;
        this.penaltyFee = penaltyFee;
        this.receivedDate = receivedDate.toLocalDate();
        this.isReceived = isReceived;
    }
    
    /**
     * Método constructor de la clase Rented que sirve para obtener las rentas actuales
     * @param id
     * @param startDate
     * @param finalDate
     * @param book
     * @param customer
     * @param rentCost
     * @param isReceived 
     */ 
    public Rented(int id, Date startDate, Date finalDate, Book book, Customer customer, 
                  int rentCost, boolean isReceived) {
        this.id = id;
        this.startDate = startDate.toLocalDate();
        this.finalDate = finalDate.toLocalDate();
        this.book = book;
        this.customer = customer;
        this.payment = rentCost;
        this.isReceived = isReceived;
    }
    
    public Rented(Date receivedDate, boolean isReceived) {
        this.receivedDate = receivedDate.toLocalDate();
        this.isReceived = isReceived;
    }

    public int getId() {
        return id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate.toLocalDate();
    }

    public LocalDate getFinalDate() {
        return finalDate;
    }

    public void setFinalDate(Date finalDate) {
        this.finalDate = finalDate.toLocalDate();
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public int getIdBook() {
        return idBook;
    }

    public Customer getCustomer() {
        return customer;
    }
    
    public String getCustomerName(){
        return customer.getName();
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Book getBook() { 
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getPayment() {
        return payment;
    }

    public void setPayment(int payment) {
        this.payment = payment;
    }

    public int getPenaltyFee() {
        return penaltyFee;
    }

    public void setPenaltyFee(int penaltyFee) {
        this.penaltyFee = penaltyFee;
    }

    public LocalDate getReceivedDate() {
        return receivedDate;
    }

    public void setReceivedDate(LocalDate receivedDate) {
        this.receivedDate = receivedDate;
    }

    public boolean getIsReceived() {
        return isReceived;
    }

    public void setIsReceived(boolean isReceived) {
        this.isReceived = isReceived;
    }
    
    
    
}

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
    private LocalDate start_date;
    private LocalDate final_date;
    private int idCustomer;
    private int idBook;
    private int payment;
    private int penaltyFee;
    private LocalDate receivedDate;
    private boolean isReceived;
    private Customer customer;
    private Book book;
    

    public Rented(Date start_date, Date final_date, int idBook, int idCustomer, int payment) {
       
        this.start_date = start_date.toLocalDate();
        this.final_date = final_date.toLocalDate();
        this.idBook = idBook;
        this.idCustomer = idCustomer;
        this.payment = payment;
    }

    public Rented(Date start_date, Date final_date, Customer customer, Book book) {
        this.start_date = start_date.toLocalDate();
        this.final_date = final_date.toLocalDate();
        this.customer = customer;
        this.book = book;
    }

    public Rented(int id, Date start_date, Date final_date, int idCustomer, int idBook) {
        this.id = id;
        this.start_date = start_date.toLocalDate();
        this.final_date = final_date.toLocalDate();
        this.idCustomer = idCustomer;
        this.idBook = idBook;
    }
    
    public Rented(int id, Date start_date, Date final_date, Book book, Customer customer, 
                  int rentCost, int penaltyFee, Date receivedDate, boolean isReceived) {
        this.id = id;
        this.start_date = start_date.toLocalDate();
        this.final_date = final_date.toLocalDate();
        this.idBook = book.getId();
        this.idCustomer = customer.getId();
        this.payment = rentCost;
        this.penaltyFee = penaltyFee;
        this.receivedDate = receivedDate.toLocalDate();
        this.isReceived = isReceived;
    }
    
    public Rented(Date receivedDate, boolean isReceived) {
        this.receivedDate = receivedDate.toLocalDate();
        this.isReceived = isReceived;
    }

    public int getId() {
        return id;
    }

    public LocalDate getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date.toLocalDate();
    }

    public LocalDate getFinal_date() {
        return final_date;
    }

    public void setFinal_date(Date final_date) {
        this.final_date = final_date.toLocalDate();
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

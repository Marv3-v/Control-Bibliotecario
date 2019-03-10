/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;

import java.time.LocalDate;

/**
 *
 * @author User
 */
public class Rented {
    
    private int id;
    private LocalDate start_date;
    private LocalDate final_date;
    private int idCostumer;
    private int idBook;
    private Customer costumerName;
    private Book bookTitle;

    public Rented(int id, LocalDate start_date, LocalDate final_date, int idCostumer, int idBook, Customer costumerName, Book bookTitle) {
        this.id = id;
        this.start_date = start_date;
        this.final_date = final_date;
        this.idCostumer = idCostumer;
        this.idBook = idBook;
        this.costumerName = costumerName;
        this.bookTitle = bookTitle;
    }

    public Rented(LocalDate start_date, LocalDate final_date, Customer costumerName, Book bookTitle) {
        this.start_date = start_date;
        this.final_date = final_date;
        this.costumerName = costumerName;
        this.bookTitle = bookTitle;
    }

    public Rented(int id, LocalDate start_date, LocalDate final_date, int idCostumer, int idBook) {
        this.id = id;
        this.start_date = start_date;
        this.final_date = final_date;
        this.idCostumer = idCostumer;
        this.idBook = idBook;
    }

    public int getId() {
        return id;
    }

    public LocalDate getStart_date() {
        return start_date;
    }

    public void setStart_date(LocalDate start_date) {
        this.start_date = start_date;
    }

    public LocalDate getFinal_date() {
        return final_date;
    }

    public void setFinal_date(LocalDate final_date) {
        this.final_date = final_date;
    }

    public int getIdCostumer() {
        return idCostumer;
    }

    public int getIdBook() {
        return idBook;
    }

    public Customer getCostumerName() {
        return costumerName;
    }

    public void setCostumerName(Customer costumerName) {
        this.costumerName = costumerName;
    }

    public Book getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(Book bookTitle) {
        this.bookTitle = bookTitle;
    }
    
}

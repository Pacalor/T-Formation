/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.curso.ejercicios3;

import static com.curso.ejercicios3.Constants.*;
import java.util.GregorianCalendar;

/**
 * class ticket, simulate the ticket you can buy
 * @author dpadilla
 */
public class Ticket {
    
    private int price;
    private static int totalId=0;
    private int id;
    private GregorianCalendar date;

    public Ticket(GregorianCalendar date) {
        this.id = totalId++;
        this.price = PRICE;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public GregorianCalendar getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Ticket{" + "price=" + price + ", id=" + id + ", date=" + date.getTime() + '}';
    }
    
    
    
    
    
}

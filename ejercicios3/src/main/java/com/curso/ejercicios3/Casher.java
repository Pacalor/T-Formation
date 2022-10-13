/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.curso.ejercicios3;

import java.util.Scanner;
import static com.curso.ejercicios3.Constants.*;
import java.util.InputMismatchException;

/**
 * class that control the money
 * @author dpadilla
 */
public class Casher {

    private Scanner keyboard;
    private int totalCost;

    public Casher() {
        this.keyboard = new Scanner(System.in);

    }

    /**
     * Buy the number of tickets
     * @param numTickets to buy
     */
    public void buyTickets(int numTickets) {
        totalCost = numTickets * PRICE;
        
        askMoney();
    }

    /**
     * Ask the money needed
     */
    private void askMoney() {
        
        boolean choosed = false;
        int option=DEFAULTOPTION;
        
        while (!choosed) {    
            System.out.println("Total cost-> "+totalCost);        
            System.out.println("Insert money:");
            try {
                option= keyboard.nextInt();
                choosed=(option==totalCost)? true:false;
                //choosed=true;
            } catch (InputMismatchException e) {
                System.out.println("Incorrect money cuantity");
            }            
        }
        
 
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.curso.ejercicios3;

import static com.curso.ejercicios3.Constants.*;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author dpadilla
 */
public class UserInterface {

    private Scanner keyboard;
    
    public UserInterface() {
        this.keyboard = new Scanner(System.in);
    }
    
    public int show() {
        boolean choosed = false;
        int option=DEFAULTOPTION;
        
        while (!choosed) {            
            System.out.println("Choose an option: ");
            try {
                 option= keyboard.nextInt();
                choosed=true;
            } catch (InputMismatchException e) {
                System.out.println("Incorrect option");
            }            
        }
        
        return option;
    }
    
    /**
     * 
     * @return 
     */
    public int askNumberTicket(){
        boolean choosed = false;
        int option=DEFAULTOPTION;
        
        while (!choosed) {            
            System.out.println("How many tickets: ");
            try {
                 option= keyboard.nextInt();
                choosed=true;
            } catch (InputMismatchException e) {
                System.out.println("Incorrect number");
            }            
        }
        
        return option;
    }
    
    public ArrayList<Integer> askDate() {
         ArrayList<Integer> dateNumber = new ArrayList<>();
        int option=DEFAULTOPTION;
        
        while (dateNumber.size()<3) {            
            
            switch (dateNumber.size()) {
                case 0:
                    System.out.println("Choose a year");
                    break;
                case 1:
                    System.out.println("Choose a month");
                    break;
                case 2:
                    System.out.println("Choose a day");
                    break;

            }
            
            try {
                option= keyboard.nextInt();
                dateNumber.add(option);
            } catch (InputMismatchException e) {
                System.out.println("Incorrect option");
            }           
            
        }
        
        return dateNumber;
    }
    
}

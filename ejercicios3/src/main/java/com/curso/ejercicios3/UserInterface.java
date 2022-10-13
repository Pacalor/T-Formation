/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.curso.ejercicios3;

import static com.curso.ejercicios3.Constants.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * User Interface that show text commands
 * @author dpadilla
 */
public class UserInterface {

    private Scanner keyboard;
    
    public UserInterface() {
        this.keyboard = new Scanner(System.in);
    }
    
    /**
     * Show text menu where you can select
     * @return option selected
     */
    public int show() {
        //variable creation
        boolean choosed = false;
        int option=DEFAULTOPTION;
        
        while (!choosed) { //repeat until i choose
            System.out.println("Choose an option: ");
            try {
                option= Integer.parseInt(keyboard.nextLine());
                choosed=true;
                
            } catch (NumberFormatException e) {
                choosed=true;
                System.out.println("Incorrect option");
                
            }            
        }
        
        return option;
    }
    
    /**
     * ask the user for the number of tickets
     * @return number of tickets
     */
    public int askNumberTicket(){
        boolean choosed = false;
        int option=DEFAULTOPTION;
        
        while (!choosed) {//meanwhile i dont choose the number of tickets
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
    /**
     * ask the user for a date
     * @return list of year,month and date
     */
    public ArrayList<Integer> askDate() {
         ArrayList<Integer> dateNumber = new ArrayList<>();
        int option=DEFAULTOPTION;
        
        while (dateNumber.size()<3) {            
            
            switch (dateNumber.size()) {//mensaje
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
                option= keyboard.nextInt();//get the number
                dateNumber.add(option);
            } catch (InputMismatchException e) {
                System.out.println("Incorrect option");
            }           
            
        }
        
        return dateNumber;
    }
    
}

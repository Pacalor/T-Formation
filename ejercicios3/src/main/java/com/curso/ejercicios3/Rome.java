/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.curso.ejercicios3;

import static com.curso.ejercicios3.Constants.*;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.InputMismatchException;

/**
 *
 * @author dpadilla
 */
public class Rome {
    private GregorianCalendar baseTime;
    private boolean exit;
    private UserInterface ui;
    private Casher casher;
    private HashSet<GregorianCalendar> daysTaken;
    public Rome() {
        //iniciar cal
        exit= false;
        ui = new UserInterface();
        casher= new Casher();
        baseTime=new GregorianCalendar();
        daysTaken = new HashSet<>();
    }
    
    public void run(){
        int numTickets=0;
        baseTime.set(GregorianCalendar.MILLISECOND, 0);
        baseTime.set(GregorianCalendar.SECOND, 0);
        baseTime.set(GregorianCalendar.MINUTE, 0);
        baseTime.set(GregorianCalendar.HOUR, 0);
        
        System.out.println(MENU);
        while (!exit) {  
            
            int option = ui.show();
            
            switch (option) {
                case BUY:
                    numTickets=ui.askNumberTicket();
                    casher.buyTickets(numTickets);
                    newTicket(numTickets);
                    break;
                    case EXIT:
                    exit = true;
                    break;
                    case DEFAULTOPTION:
                        System.out.println(MENU);
                    break;
                default:
                    System.out.println(MENU);
            }
        }
    }

    private void newTicket(int numTickets) {
        GregorianCalendar ticketTime = (GregorianCalendar)baseTime.clone();
        ArrayList<Ticket> ticketList = new ArrayList<>();
        ArrayList<Integer> dateNumber;
        
        for (int i = 0; i < numTickets;) {
            dateNumber=ui.askDate();
            ticketTime=editCalendar(dateNumber, ticketTime);
            if (checkCalendar(ticketTime)) {
                ticketList.add(new Ticket((GregorianCalendar)ticketTime.clone()));
                daysTaken.add((GregorianCalendar)ticketTime.clone());
                 i++;
            }else{
                System.out.println("Date already taken or invalid");
            }
            
        }
        
        for (Ticket ticket : ticketList) {
            System.out.println(ticket);
        }
    }
    
    private GregorianCalendar editCalendar(ArrayList<Integer> dateNumber, GregorianCalendar calendar){
        calendar.set(GregorianCalendar.YEAR, dateNumber.get(0));
        calendar.set(GregorianCalendar.MONTH, dateNumber.get(1)-1);
        calendar.set(GregorianCalendar.DAY_OF_MONTH, dateNumber.get(2));
        
        return calendar;
    }
    
    private boolean checkCalendar(GregorianCalendar day){
        return !daysTaken.contains(day) && baseTime.before(day);
        
    }

    
    
}

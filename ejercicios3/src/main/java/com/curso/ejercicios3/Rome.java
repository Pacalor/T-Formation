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
 * main class
 * @author dpadilla
 */
public class Rome {

    private GregorianCalendar baseTime;
    private boolean exit;
    private UserInterface ui;
    private Casher casher;
    private HashSet<GregorianCalendar> daysTaken;

    public Rome() {
        exit = false;
        ui = new UserInterface();
        casher = new Casher();
        baseTime = new GregorianCalendar();
        daysTaken = new HashSet<>();
    }

    /**
     * method that start the program
     */
    public void run() {
        //inith a base time, where millisecods, seconds, minutes and hours dont
        //matter. I will only use, year, month and day, other data will be 0
        int numTickets = 0;
        baseTime.set(GregorianCalendar.MILLISECOND, 0);
        baseTime.set(GregorianCalendar.SECOND, 0);
        baseTime.set(GregorianCalendar.MINUTE, 0);
        baseTime.set(GregorianCalendar.HOUR, 0);

        System.out.println(MENU);//start the menu
        while (!exit) {

            int option = ui.show();

            switch (option) {
                case BUY:
                    numTickets = ui.askNumberTicket();
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

    /**
     * create new tickets
     * @param numTickets how many tickets i wanna
     */
    private void newTicket(int numTickets) {
        GregorianCalendar ticketTime = (GregorianCalendar) baseTime.clone();
        ArrayList<Ticket> ticketList = new ArrayList<>();
        ArrayList<Integer> dateNumber;

        for (int i = 0; i < numTickets;) {
            dateNumber = ui.askDate();//interface ask for date
            ticketTime = editCalendar(dateNumber, ticketTime);
            
            if (checkCalendar(ticketTime)) {//is the day avaliable?
                ticketList.add(new Ticket((GregorianCalendar) ticketTime.clone()));
                daysTaken.add((GregorianCalendar) ticketTime.clone());
                i++;
            } else {
                System.out.println("Date already taken or invalid");
            }

        }

        for (Ticket ticket : ticketList) {
            System.out.println(ticket);
        }
    }

    /**
     * edit the calendar with the new date
     * @param dateNumber arraylist with year, month and day
     * @param calendar  date to edit
     * @return new date with year month and day
     */
    private GregorianCalendar editCalendar(ArrayList<Integer> dateNumber, GregorianCalendar calendar) {
        calendar.set(GregorianCalendar.YEAR, dateNumber.get(0));
        calendar.set(GregorianCalendar.MONTH, dateNumber.get(1) - 1);
        calendar.set(GregorianCalendar.DAY_OF_MONTH, dateNumber.get(2));

        return calendar;
    }

    /**
     * check in my database if the day is already taken and if the time it's
     * before me, because i can't buy tickets in the past
     * @param day day i wanna check
     * @return true if i can use the date
     */
    private boolean checkCalendar(GregorianCalendar day) {
        return !daysTaken.contains(day) && baseTime.before(day);

    }

}

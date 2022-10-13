/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.curso.ejercicio4;

import static com.curso.ejercicio4.Constants.*;

/**
 *
 * @author dpadilla
 */
public class AuthSystem {

    UserInterface ui;
    DB db;

    public AuthSystem() {
        ui = new UserInterface();
        db = new DB(FILEDATABASE);
    }

    public void run() {
        boolean exit = false;
        int option = DEFAULTOPTION;
        db.start();

        while (!exit) {
            System.out.println(MENU);
            option = ui.show();

            switch (option) {
                case LOGIN:
                    login();
                    break;
                case REGISTER:
                    register();
                    break;
                case EXIT:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option");
            }

        }

    }

    private void register() {
        User user=null;
        boolean canRegister=false;
        
        while (!canRegister) {            
            user=ui.askName();
            if(!db.exist(user))canRegister=true;
            else System.out.println("User already taken");
        }
        
        user.setPass(ui.askPasword());
          
        db.add(user);
        
        System.out.println("Register succesfull");
    }

    private void login() {
        User user=null;
        boolean canLogin=false;
        boolean correct=true;
        String pasword;
                   
        user=ui.askName();
        if(!db.exist(user))correct=false;
       
        
        pasword=ui.askPasword();
        
        if(correct){
          correct=db.check(user,pasword);
        }
        
        if(correct){
           user=db.getUser(user.getUserName());
            System.out.println(USERWELCOME);
        }else{
            System.out.println(USERERROR);
        }
        
    }

}

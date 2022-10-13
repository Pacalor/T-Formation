/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.curso.ejercicio4;

import static com.curso.ejercicio4.Constants.SEPARE;

/**
 *
 * @author dpadilla
 */
public class User {
    private String userName;
    private String pass;

    public User(String userName, String pass) {
        this.userName = userName;
        this.pass = pass;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return this.getUserName() + SEPARE + this.getPass() + "\n";
    }
    
    
    
    
    
    
    
}

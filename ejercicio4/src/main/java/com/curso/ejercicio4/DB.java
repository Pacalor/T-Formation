/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.curso.ejercicio4;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import java.util.logging.Logger;

/**
 *
 * @author dpadilla
 */
public class DB {
    HashMap<String,User> db;
    Reader reader;
    Writer writer;

    public DB(String fileName) {
        db = new HashMap<>();
        reader = new Reader(fileName);
        writer = new Writer(fileName);
    }
    
    public void start(){
        ArrayList<User> users=null;
        try {
            users = reader.readFile();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DB.class.getName()).info("Database reader, file not found");
        }
        
        for (User user : users) {
            db.put(user.getUserName(), user);
        }
    }
    
    public boolean exist(User s){
        return db.containsKey(s.getUserName());
    }
    
    public void add(User s){
        db.put(s.getUserName(), s);
        try {
            writer.writeFile(db);
        } catch (IOException ex) {
            Logger.getLogger(DB.class.getName()).info("Database writer, file not found");
        }
    }

    public boolean check(User user, String pasword) {
       return pasword.equals(db.get(user.getUserName()).getPass());
    }
    
    public User getUser(String name){
        return db.get(name);
    }
   
    
}

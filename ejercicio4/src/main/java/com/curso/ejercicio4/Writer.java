/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.curso.ejercicio4;

import static com.curso.ejercicio4.Constants.SEPARE;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author dpadilla
 */
public class Writer {
    private FileWriter writer;
    private String fileName;

    public Writer(String file) {
        this.fileName = file;
    }
    
    public void writeFile(HashMap<String,User> db) throws IOException {

        File file = new File(fileName);
        writer = new FileWriter(file);
        String toWrite;

        for (Map.Entry<String, User> entry : db.entrySet()) {
            String key = entry.getKey();
            User val = entry.getValue();
            
            toWrite = val.toString();
            writer.write(toWrite);
        }
        
        
        writer.close();

    }
}

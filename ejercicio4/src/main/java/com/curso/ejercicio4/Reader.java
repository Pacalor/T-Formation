/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.curso.ejercicio4;

import static com.curso.ejercicio4.Constants.SEPARE;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dpadilla
 */
public class Reader {

    private Scanner reader;
    private String fileName;

    public Reader(String file) {
        this.fileName = file;
    }

    public ArrayList<User> readFile() throws FileNotFoundException {
        ArrayList<User> fileUser = new ArrayList<>();

        File file = new File(fileName);
        reader = new Scanner(file);

        String line;
        String[] words;

        while (reader.hasNext()) {
            line = reader.nextLine();

            if (line != null) {
                words = line.split("\\Q" + SEPARE);

                /////////////////
                String pass = words[1];
                String userName = words[0];

                User toAdd = new User(userName, pass);
                fileUser.add(toAdd);
            }

        }
        reader.close();
        return fileUser;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    
    
}

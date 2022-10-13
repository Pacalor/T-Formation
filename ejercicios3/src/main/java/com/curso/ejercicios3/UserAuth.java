package com.curso.ejercicios3;

import java.util.Scanner;
import java.math.BigInteger;
import java.security.MessageDigest;

import javax.security.auth.login.LoginException;

public class UserAuth {
    private UserDB userDB;
    private Scanner scan = new Scanner(System.in);


    public UserAuth(UserDB userDB) {
        this.userDB = userDB;
    }


    public User login () throws LoginException {
        System.out.println("What's your NIF?");
        System.out.print("> ");
        String dni = scan.nextLine();

        System.out.println("Password for " + dni + ":");
        System.out.print("> ");
        String password = scan.nextLine();
        String hashedPassword = getSHA512(password);

        User user = null;

        try {
            user = userDB.login(dni, hashedPassword);
        }
        catch (LoginException e) {
            throw new LoginException("Incorrect user or/and password");
        }

        return user;
    }


    public User registerUser() throws LoginException {
        System.out.println("What's your name?");
        System.out.print("> ");
        String name = scan.nextLine();

        System.out.println("What's your NIF?");
        System.out.print("> ");
        String dni = scan.nextLine();

        System.out.println("Provide your password:");
        System.out.print("> ");
        String password = scan.nextLine();
        String hashedPassword = getSHA512(password);

        User user = new User(name, dni, hashedPassword);

        if (!userDB.addUser(user)) {
            throw new LoginException("User already exists in the database");
        }

        return user;
    }


    public String getSHA512(String input){

        String toReturn = null;
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-512");
            digest.reset();
            digest.update(input.getBytes("utf8"));
            toReturn = String.format("%0128x", new BigInteger(1, digest.digest()));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return toReturn;
    }
}

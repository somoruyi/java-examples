package com.demo.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Discovered these security classes while tutoring
 */
public class Myclass {

    public static void main(String[] args){
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

}

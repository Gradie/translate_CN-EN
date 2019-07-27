package com.company;

import java.io.*;
public class consoleMain {
    public static void main(String[] args){
        try {
            System.out.println("Input a word:");
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

            String toLookup = bf.readLine();

            malicTranslator mt = new malicTranslator(toLookup);
            System.out.println(mt.translate());
            System.out.println(mt.transInfo());


        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

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

            apiiDictTranslator adt = new apiiDictTranslator(toLookup);
            System.out.println(adt.translate());
            System.out.println(adt.transInfo());

            youdaoXMLtranslator yxt = new youdaoXMLtranslator(toLookup);
            System.out.println(yxt.translate());
            System.out.println(yxt.transInfo());

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

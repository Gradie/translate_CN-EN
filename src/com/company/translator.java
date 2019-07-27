package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.MalformedURLException;

public abstract class translator {
    public String apiResource;
    public String meaning;
    public String webpageCtx;

    public translator(String url){
        readWebcontent(url);
        parse();
    }

    private void readWebcontent(String strUrl){
        try {
            URL url = new URL(strUrl);
            InputStream is = url.openStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader bf = new BufferedReader(isr);
            String str;
            webpageCtx = "";
            while ((str = bf.readLine())!=null){
                webpageCtx += str;
            }
            bf.close();
            isr.close();
            is.close();
        }
        catch (MalformedURLException e){
            System.out.println("Connect error");
            System.exit(0);
        }
        catch (IOException e){
            System.out.println("Input error");
            System.exit(0);
        }
    }
    //有这个抽象方法，translator类也定义为abstract类，若没有abstract，可以new，但类里有抽象方法，不能new一个对象
    abstract void parse();

    public String transInfo(){
        return "\t===translated by [" + apiResource +"]\n";
    }
    public String translate(){
        return meaning;
    }
}

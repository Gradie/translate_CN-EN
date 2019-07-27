package com.company;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class apiiDictTranslator extends translator{
    public apiiDictTranslator(String wd){
        super("http://apii.dict.cn/mini.php?q="+wd);
        apiResource = "apii.dict.cn";
    }
    void parse(){
        //解析
        //正则表达式
        String meaningPattern="<div id=\"e\">(.*?)</div>";

        Pattern meanRegex=Pattern.compile(meaningPattern);
        Matcher meanGp = meanRegex.matcher(webpageCtx);
        meaning="";
        if(meanGp.find()) {
            String ctxLines[] = meanGp.group(1).split("<br>");
            for(String it : ctxLines)
                meaning = meaning+it + "\n";
        }
    }
}

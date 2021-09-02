package com.jinkui.java.Exception;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

public class TestClass3 {
    private static Logger logger = Logger.getLogger("Logging Exception2");
    static void logException(Exception e){
        StringWriter trace = new StringWriter();
        e.printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());
    }

    public static void main(String[] args){
        try{
            throw new NullPointerException();
        }catch(NullPointerException e){
            logException(e);
        }
    }
}

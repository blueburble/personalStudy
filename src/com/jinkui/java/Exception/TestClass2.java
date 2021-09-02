package com.jinkui.java.Exception;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

public class TestClass2 {
    public static void main(String[] args){
        try{
            throw new LoggingException();
        }catch (LoggingException e){
            System.out.println("Caught e");
        }
        try{
            throw new LoggingException();
        }catch (LoggingException e){
            System.out.println("Caught e");
        }
    }
}

class LoggingException extends Exception{
    private static Logger logger = Logger.getLogger("LoggingExcception");
    LoggingException(){
        StringWriter trace = new StringWriter();
        printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());
    }
}

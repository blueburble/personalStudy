package com.jinkui.java;

import jdk.nashorn.internal.codegen.CompilerConstants;
import jdk.nashorn.internal.codegen.MethodEmitter;

public class LambdaTest4 {
    static void hello(String name){
        System.out.println("hello, " + name);
    }
    static class Description{
        String about;
        Description(String desc){
            about  = desc;
        }
        void help(String msg){
            System.out.println(about + "" + msg);
        }
    }
    static class Helper{
        static void assist(String msg){
            System.out.println(msg);
        }
    }

    public static void main(String[] args){
        Describe d = new Describe();
        Callable callable = d :: show;
        callable.call("call()");

        callable = LambdaTest4 :: hello;
        callable.call("bob");

        callable = new Description("valueable")::help;
        callable.call("information");

        callable = Helper::assist;
        callable.call("help!");
    }
}

interface Callable{
    void call(String s);
}

class Describe{
    void show(String msg){
        System.out.println(msg);
    }
}
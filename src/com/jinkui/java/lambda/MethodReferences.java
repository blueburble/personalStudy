package com.jinkui.java.lambda;

public class MethodReferences {
    static void hello(String name) {
        System.out.println("hello" + name);
    }

    static class Description {
        String about;

        Description(String desc) {
            about = desc;
        }

        ;

        void help(String msg) {
            System.out.println(about + "" + msg);
        }
    }

    static class Helper {
        static void assist(String msg) {
            System.out.println(msg);
        }
    }

    public static void main(String[] args) {

        Describe describe = new Describe();
        Callable c = describe::show;
        c.call("call()");

        c = MethodReferences::hello;
        c.call("liming");

        c = new Description("mydesc")::help;
        c.call("haha");

        c= Helper::assist;
        c.call("99999");

    }

    interface Callable {
        void call(String s);
    }

}

class Describe {
    void show(String msg) {
        System.out.println(msg);
    }
}
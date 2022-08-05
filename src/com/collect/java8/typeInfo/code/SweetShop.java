package com.collect.java8.typeInfo.code;

public class SweetShop {
    public static void main(String[] args){
        System.out.println("inside main");
        new Candy();
        System.out.println("After creating Candy");
        try{
            Class.forName("com.collect.java8.typeInfo.code.Gum");
        } catch (ClassNotFoundException e){
            System.out.println("找不到GUM");
        }
        System.out.println("After creating Gum");
        new Cookie();
        System.out.println("After creating cookie");
    }
}


class Cookie{
    static {
        System.out.println("LOADING COOKIE");
    }
}

class Gum{
    static{
        System.out.println("Loading GUM");
    }
}

class Candy{
    static{
        System.out.println("Loading candy");
    }
}
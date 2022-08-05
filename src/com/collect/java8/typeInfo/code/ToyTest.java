package com.collect.java8.typeInfo.code;

public class ToyTest {

    static void printInfo(Class cc){
        System.out.println("Class Name :" + cc.getName() + "isInterface ? [" + cc.isInterface() + "]");
        System.out.println("SimpleName" + cc.getSimpleName());
        System.out.println("Canonical Name: " + cc.getCanonicalName());
    }

    public static void main(String[] args){
        Class c = null;
        try{
            c = Class.forName("com.collect.java8.typeInfo.code.FancyToy");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }
        printInfo(c);
        for(Class face : c.getInterfaces()){
            printInfo(face);
        }
        Class up = c.getSuperclass();
        Object obj = null;
        try{
            obj = up.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
            System.exit(1);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            System.exit(1);
        }
        printInfo(obj.getClass());
    }

}


class Toy{
    Toy(){}
    Toy(int i){}
}

interface HasBatteries {}
interface Waterproof {}
interface Shoots {}

class FancyToy extends Toy implements HasBatteries,Waterproof,Shoots{
    FancyToy() { super(1) ;}
}
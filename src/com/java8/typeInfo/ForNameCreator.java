package com.java8.typeInfo;

import java.util.ArrayList;
import java.util.List;

public class ForNameCreator extends PetCreator{

    private static List<Class<? extends Pet>> types = new ArrayList<>();

    private static String[] typeNames = {
            "com.java8.typeInfo.Mutt",
            "com.java8.typeInfo.Pug",
            "com.java8.typeInfo.EgyptianMau",
            "com.java8.typeInfo.Manx",
            "com.java8.typeInfo.Cymric",
            "com.java8.typeInfo.Rat",
            "com.java8.typeInfo.Mouse",
            "com.java8.typeInfo.Hamster"
    };

    private static void loader(){
        try{
            for(String name : typeNames){
                types.add((Class<? extends Pet>) Class.forName(name));
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    static {
        loader();
    }

    @Override
    public List<Class<? extends Pet>> types() {
        return types;
    }
}

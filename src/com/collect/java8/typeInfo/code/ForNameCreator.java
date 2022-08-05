package com.collect.java8.typeInfo.code;

import com.collect.java8.typeInfo.code.pets.Pet;

import java.util.ArrayList;
import java.util.List;

public class ForNameCreator extends PetCreator{

    private static List<Class<? extends Pet>> types = new ArrayList<>();

    private static String[] typeNames = {
            "com.collect.java8.typeInfo.code.pets.Mutt",
            "com.collect.java8.typeInfo.code.pets.Pug",
            "com.collect.java8.typeInfo.code.pets.EgyptianMau",
            "com.collect.java8.typeInfo.code.pets.Manx",
            "com.collect.java8.typeInfo.code.pets.Cymric",
            "com.collect.java8.typeInfo.code.pets.Rat",
            "com.collect.java8.typeInfo.code.pets.Mouse",
            "com.collect.java8.typeInfo.code.pets.Hamster" };

    static {
        try {

            for(String name : typeNames){
                types.add((Class<? extends Pet>) Class.forName(name));
            }
        } catch (ClassNotFoundException e) {
           throw new RuntimeException(e);
        }
    }



    @Override
    public List<Class<? extends Pet>> types() {
        return types;
    }
}

package com.collect.java8.typeInfo.code;

public class ClassCasts {
    public static void main(String[] args){
        Building b = new House();
        Class<House> h = House.class;
        House house = h.cast(b);
        house = (House) b;
    }
}

class Building{

}

class House extends Building{

}

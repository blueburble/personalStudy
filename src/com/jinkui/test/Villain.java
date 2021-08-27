package com.jinkui.test;

public class Villain {

    private String name;

    protected void set(String nm){
        name = nm;
    }

    Villain(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return "Villain" +
                "name IS'" + name ;
    }
}

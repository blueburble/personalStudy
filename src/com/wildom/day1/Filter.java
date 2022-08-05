package com.wildom.day1;

public class Filter {
    public String name(){
        return getClass().getSimpleName();
    };

    public WaveForm process(WaveForm input){
        return  input;
    }
}

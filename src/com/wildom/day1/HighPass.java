package com.wildom.day1;

public class HighPass  extends Filter{
    double cutoff;

    public HighPass(double cutoff){
        this.cutoff = cutoff;
    }

    public WaveForm process(WaveForm input){
        return  input;
    }
}

package com.wildom.day1;

public class LowPass extends Filter {
    double cutoff;

    public LowPass(double cutoff){
        this.cutoff = cutoff;
    }

    @Override
    public  WaveForm   process(WaveForm input){
        return  input;
    }
}

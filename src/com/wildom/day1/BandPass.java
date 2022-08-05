package com.wildom.day1;

public class BandPass extends Filter {
        double lowCutoff, highCutoff;

        public BandPass(double low, double high){
            this.lowCutoff  = low;
            this.highCutoff = high;
        }

    @Override
    public WaveForm process(WaveForm input) {
        return input;
    }
}


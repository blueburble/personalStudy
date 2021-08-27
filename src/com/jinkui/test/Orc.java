package com.jinkui.test;

public class Orc extends Villain {
    private int ocrNumber;

    public Orc(String name, int ocrNumber){
        super(name);
        this.ocrNumber = ocrNumber;
    }

    public void change(String name, int ocrNumber){
        set(name);
        this.ocrNumber = ocrNumber;
    }
}

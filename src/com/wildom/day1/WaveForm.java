package com.wildom.day1;

public class WaveForm {
    private static long counter;
    private final long id = counter++;

    @Override
    public String toString() {
        return "WaveForm{" +
                "id=" + id +
                '}';
    }
}

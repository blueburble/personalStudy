package com.jinkui.java;

import javax.sound.midi.Sequence;

public class InnerClass1 {
    private Object[] items;
    private int next = 0;
    public InnerClass1(int size){
        items =  new Object[size];
    }
    public void add(Object x){
        if(next < items.length){
            items[next++] = x;
        }
    }

    private class SequenceSelector implements Selector{

        private int i = 0;

        @Override
        public boolean end() {
            return i == items.length;
        }

        @Override
        public Object current() {
            return items[i];
        }

        @Override
        public void next() {
            if(i < items.length){
                i++;
            }
        }
    }

    public Selector selector(){
        return new SequenceSelector();
    }

    public static void main(String[] args){
        InnerClass1 innerClass1 = new InnerClass1(10);

        for(int i = 0; i < 10; i++){
            innerClass1.add(Integer.toString(i));
        }

        Selector selector = innerClass1.selector();

        while (!selector.end()){
            System.out.print(selector.current());
            selector.next();;
        }
    }



}


interface Selector{
    boolean end();
    Object  current();
    void next();
}

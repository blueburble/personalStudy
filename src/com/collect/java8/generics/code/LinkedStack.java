package com.collect.java8.generics.code;

import java.util.Arrays;

public class LinkedStack<T>{
    private static class Node<U>{
        U item;
        Node<U> next;
        Node() {
            item = null;
            next = null;
        }

        Node(U item, Node<U> next){
            this.item = item;
            this.next = next;
        };

        boolean end(){
            return item == null  && next == null;
        }
    }

    private Node<T> top = new Node<>();

    public void push(T item){
        top = new Node<>(item, top);
    }

    public T pop() {
        T result = top.item;
        if(!top.end()){
            top = top.next;
        }
        return result;
    }

    public static void main(String[] args){
        LinkedStack<String> lss = new LinkedStack<>();
        Arrays.stream("Hello word generic".split(" ")).forEach(lss::push);
        String s;
        while ((s = lss.pop()) != null){
            System.out.println(s);
        }
    }
}

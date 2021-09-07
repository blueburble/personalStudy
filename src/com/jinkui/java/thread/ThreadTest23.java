package com.jinkui.java.thread;

import javax.annotation.PostConstruct;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public class ThreadTest23 {

    public static void main(String[] args){
        User user = new User("CAA", 10);
        for(int i = 0; i< 10; i++){
            new Mythread78( user).start();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(user);
    }

}

class User{
    String id;
    volatile int age;

    public User(String id, int age){
        this.id = id;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", age=" + age +
                '}';
    }
}


class Mythread78 extends Thread{

    private User user;

    private AtomicIntegerFieldUpdater<User> updater = AtomicIntegerFieldUpdater.newUpdater(User.class, "age");

    public Mythread78(User user){
        this.user = user;
    }

    @Override
    public void run() {
        for(int i = 0; i<10; i++){
           System.out.println( updater.incrementAndGet(user));
        }
    }
}
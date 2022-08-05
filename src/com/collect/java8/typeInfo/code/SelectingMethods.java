package com.collect.java8.typeInfo.code;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Optional;

public class SelectingMethods {

    public static void main(String[] args){
        SomeMethods proxy = (SomeMethods) Proxy.newProxyInstance(SomeMethods.class.getClassLoader(),
                new Class[]{SomeMethods.class},
                new MethodSelector(new Implementation()));
        proxy.boring1();
        proxy.boring2();
        proxy.boring3();
        proxy.interesting("NANAN");
    }

}

class Person {
    public final Optional<String> first;
    public final Optional<String> last;
    public final Optional<String> address;
    // etc.
    public final boolean empty;
    Person(String first, String last, String address) {
        this.first = Optional.ofNullable(first);
        this.last = Optional.ofNullable(last);
        this.address = Optional.ofNullable(address);
        empty = !this.first.isPresent()
                && !this.last.isPresent()
                && !this.address.isPresent();
    }
    Person(String first, String last) {
        this(first, last, null);
    }
    Person(String last) { this(null, last, null); }
    Person() { this(null, null, null); }

    @Override
    public String toString() {
        if(empty)
            return "<Empty>";
        return (first.orElse("") +
                " " + last.orElse("") +
                " " + address.orElse("")).trim();
    }
    public static void main(String[] args) {
        System.out.println(new Person());
        System.out.println(new Person("Smith"));
        System.out.println(new Person("Bob", "Smith"));
        System.out.println(new Person("Bob", "Smith",
                "11 Degree Lane, Frostbite Falls, MN"));
    }
}


class MethodSelector implements InvocationHandler{

    private Object proxied;

    MethodSelector(Object proxied){
        this.proxied = proxied;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(method.getName().equals("interesting")){
            System.out.println("proxy detected the interesting method");
        }
        return method.invoke(proxied, args);
    }
}

interface SomeMethods{
    void boring1();

    void boring2();

    void boring3();

    void interesting(String arg);
}

class Implementation implements SomeMethods{

    @Override
    public void boring1() {
        System.out.println("boring1");
    }

    @Override
    public void boring2() {
        System.out.println("boring2");
    }

    @Override
    public void boring3() {
        System.out.println("boring3");
    }

    @Override
    public void interesting(String arg) {
        System.out.println("interesting" + arg);
    }
}
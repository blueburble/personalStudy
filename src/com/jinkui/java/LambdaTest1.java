package com.jinkui.java;

import java.util.Locale;

public class LambdaTest1 {
    Strategy strategy;
    String msg;
    LambdaTest1(String msg){
        strategy = new Soft();
        this.msg = msg;
    }
    void communicate() {
        System.out.println(strategy.approach(msg));
    }

    void changeStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public static void main(String[] args) {
        Strategy[] strategies = {
            new Strategy() {
            @Override
            public String approach(String msg) {
                return msg.toUpperCase() + "!.";
            }
        },
        msg -> msg.substring(0, 5),
        Unrelated::twice
        };
        LambdaTest1 s = new LambdaTest1("Hello there");
        s.communicate();
        for(Strategy newStrategy: strategies){
            s.changeStrategy(newStrategy);
            s.communicate();
        }
    }
}

interface Strategy{
    String approach(String msg);
}

class Soft implements Strategy{
    @Override
    public String approach(String msg) {
        return msg.toLowerCase() + "?";
    }
}

class Unrelated{
    static String twice(String msg){
        return msg + " " + msg;
    }
}
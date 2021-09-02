package com.jinkui.java.lambda;

import java.util.Locale;

public class Strategize {
    Strategy strategy;
    String msg;

    public Strategize(String msg){
        strategy = new Soft();
        this.msg = msg;
    }

    void communicate(){
        System.out.println(strategy.approach(msg));
    }

    void changeStrategy(Strategy strategy){
        this.strategy = strategy;
    }

    public static void main(String[] args){
        Strategy[] strategies = {
                new Strategy(){
                    @Override
                    public String approach(String msg) {
                        return msg.toUpperCase() +  "!";
                    }
                },
                msg -> msg.substring(0, 5),
                Unrelated :: twice
        };
        Strategize s = new Strategize("Hello there");
        s.communicate();
        for(Strategy strategy : strategies){
            s.changeStrategy(strategy);
            s.communicate();
        }
    }

}

interface Strategy{
    String approach(String msg);
}

class Soft implements Strategy{
    public String approach(String msg){
        return msg.toLowerCase() + "?";
    }
}

class Unrelated{
    static String twice(String msg){
        return msg + " " + msg;
    }
}
package com.jinkui.java.lambda;

public class LambdaExpressions {
    static Body bod = h ->  h + "No thanks";

    static Body bod2 = h -> h + "more details";

    static Description desc = () -> "Short Info";

    static Multi mult = (h, n) -> h  + n;

    static Description moreLines = () -> {
        System.out.println("more Lines() ");
        return "from moreLines()";
    };

    public static void main(String[] args){
        System.out.println(bod.detailed("oH"));
        System.out.println(bod2.detailed("Hi"));
        System.out.println(desc.brief());
        System.out.println(mult.twoArg("test", 1.0));
        System.out.println(moreLines.brief());
    }
}

interface Description{
    String brief();
}

interface Body{
    String detailed(String head);
}

interface Multi{
    String twoArg(String head, Double d);
}
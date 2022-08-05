package com.collect.java8.typeInfo.code;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public interface Robot {
    String name();
    String model();

    List<Operation> operations();

    static void test(Robot r){
        if(r instanceof Null){
            System.out.println("Null robot");
        }
        System.out.println("Robot name：" + r.name());
        System.out.println("Robot model:" +  r.model());
        for(Operation operation : r.operations()){
            System.out.println(operation.description.get());
            operation.command.run();
        }
    }
}

class Operation {
    public final Supplier<String> description;
    public final Runnable command;

    Operation(Supplier<String> dsc, Runnable cmd){
        this.description = dsc;
        this.command = cmd;
    }
}

class SnowRemoveRobot implements Robot{
    private String name;

    public SnowRemoveRobot(String name){
        this.name = name;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public String model() {
        return "SnowBot sereied 1";
    }

    @Override
    public List<Operation> operations() {
        return Arrays.asList(new Operation(
                () -> name + " can shovel snow",
                () -> System.out.println(name + " shoving snow"  )
        ),new Operation(
                () -> name + " can chip ice",
                () -> System.out.println(name + " chipping ice"  )
        ),new Operation(
                () -> name + " can clear the roof",
                () -> System.out.println(name + "clearing roof"  )
        ));
    }

    public static void main(String[] args){
        Robot.test(new SnowRemoveRobot("slusher"));
    }
}

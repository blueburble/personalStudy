package com.collect.java8.typeInfo.code;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

class NullRobotProxyHandler implements InvocationHandler {

    private String nullName;
    private Robot proxied = new NRobot();

     NullRobotProxyHandler(Class<? extends Robot> type){
        nullName = type.getSimpleName() + " Null robot";
    }

    private class NRobot implements  Null, Robot{

        @Override
        public String name() {
            return nullName;
        }

        @Override
        public String model() {
            return nullName;
        }

        @Override
        public List<Operation> operations() {
            return Collections.EMPTY_LIST;
        }
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(proxied, args);
    }
}

public class NullRobot{
    public static Robot newNullRobot(Class<? extends  Robot> type){
        return (Robot) Proxy.newProxyInstance(NullRobot.class.getClassLoader(), new Class[]{Null.class, Robot.class}, new NullRobotProxyHandler(type));
    }

    public static void main(String[] args){
        Stream.of(new SnowRemoveRobot("SnowBee"), newNullRobot(SnowRemoveRobot.class)).forEach(Robot::test);
    }
}

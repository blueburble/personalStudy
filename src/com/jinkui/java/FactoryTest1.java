package com.jinkui.java;

public class FactoryTest1 {
    public static void playGame(GameFactory factory){
        Game s = factory.geiGame();
        while (s.move()){
            ;
        }
    }

    public static void main(String[] args){
        playGame(new CheckFactory());
        playGame(new ChessFactory());
    }
}

interface Game{
    boolean move();
}

interface GameFactory{
    Game geiGame();
}

class  Checkers implements Game{
    private  int moves = 0;
    private static  int MOVES = 3;

    @Override
    public boolean move() {
        System.out.println("Checkers move" + moves);
        return ++moves != MOVES;
    }
}

class CheckFactory implements GameFactory{
    @Override
    public Game geiGame() {
        return new Checkers();
    }
}

class Chess implements  Game{
    private int moves = 0;
    private static final  int MOVES = 4;

    @Override
    public boolean move() {
        System.out.println("Chess move" + moves);
        return ++moves != MOVES;
    }
}

class ChessFactory implements GameFactory{

    @Override
    public Game geiGame() {
        return new Chess();
    }
}

package com.collect.java8.stream.code;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RandomWords implements Supplier<String> {
    List<String> words = new ArrayList<>();
    Random rand = new Random(47);
    RandomWords(String fileName){
        try {
            List<String> lines = Files.readAllLines(Paths.get(fileName));
            for(String line:lines){
                for(String word: line.split(",")){
                    words.add(word);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public String get() {
        return words.get(rand.nextInt(words.size()));
    }

    @Override
    public String toString(){
        return words.stream().collect(Collectors.joining(" "));
    }

    public static void main(String[] args){
        System.out.println(Stream.generate(new RandomWords("D:/tools/FILE/测试.txt")).limit(3).collect(Collectors.joining(" ")));
    }

}

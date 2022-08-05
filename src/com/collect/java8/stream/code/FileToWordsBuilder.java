package com.collect.java8.stream.code;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileToWordsBuilder {
    Stream.Builder<String> builder = Stream.builder();

    public FileToWordsBuilder(String filePath) throws Exception {
        Files.lines(Paths.get(filePath))
                .forEach(line ->{
                    for(String w: line.split(",")){
                        builder.add(w);
                    }
                });
    }

    Stream<String> stream(){
        return builder.build();
    }

    public static void main(String[] args) throws Exception {
        new FileToWordsBuilder("D:/tools/FILE/测试.txt").stream().forEach(System.out::println);
    }
}

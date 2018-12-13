package com.epam.training.Calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PasswordTestConcurrency {
    //find password up to 5 letter (lower case) with using concurrency
    public static void main(String[] arg) {
        List<String> list = defineChars();
        HashCalculator hashCalc = new HashCalculator();
        //input your password below
        Password password = new Password(hashCalc.hash("a"));

        long d1 = System.currentTimeMillis();
        int threadCount = 0;
        ExecutorService exec = Executors.newCachedThreadPool();
        for (String letter: list){
            for(String letter1: list){
                if (!Objects.equals(letter, "") && Objects.equals(letter1, ""))
                {
                    continue;
                }

                for(String letter2: list) {
                    if (!Objects.equals(letter1, "") && Objects.equals(letter2, "")){
                        continue;
                    }
                    for(String letter3: list) {
                        if (!Objects.equals(letter2, "") && Objects.equals(letter3, "")) {
                            continue;
                        }

                            String base = letter + letter1 + letter2 + letter3;
                            exec.execute(new FindPasswordTask(hashCalc, password, list.subList(0, list.size() - 1), base));
                            threadCount++;

                    }
                }
            }
        }
        exec.shutdown();
        long d2 = System.currentTimeMillis();
        System.out.println("Time to found: " + (d2 - d1) + " ms. Threads count: " + threadCount);
    }

    public static List<String> defineChars(){
        List<String> list = new ArrayList<>();
        for(int x = 97; x < 123; x++) {
            list.add(Character.toString((char)(x)));
        }
        list.add("");
        return  list;
    }

}


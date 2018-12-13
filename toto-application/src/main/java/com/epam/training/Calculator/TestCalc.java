package com.epam.training.Calculator;

import java.util.ArrayList;
import java.util.List;

public class TestCalc {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        HashCalculator hashCalc = new HashCalculator();
        list.stream().map(hashCalc::hash).forEach(System.out::println);
        //System.out.println(hashCalc.hash("aa"));
    }
}

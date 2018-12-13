package com.epam.training.Calculator;

import java.util.List;

public class FindPasswordTask implements Runnable    {

    List<String> valueIn;
    int start;
    private static int taskCount;
    private final int id = taskCount++;
    String valueOut;
    HashCalculator calculator;
    Password password;
    String base;

    public FindPasswordTask(HashCalculator calculator, Password password, List<String> valueIn, String base) {
        this.valueIn = valueIn;
        this.calculator = calculator;
        this.password = password;
        this.base = base;
    }

    @Override
    public void run() {
        String val;
        //System.out.println(id + ". Check for " + base);
        for (String value: valueIn){
            if (!password.getIsFound()) {
                val = base + value;
                valueOut = calculator.hash(val);
                //System.out.println(id + ". Check for " + val + ": " + valueOut);
                password.stop(valueOut, val);
                //System.out.println(id + ".Found: " + password.getIsFound());
                continue;
            }
            break;
        }
    }
}

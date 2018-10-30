package Calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PasswordTestSimple{
    //find password up to 5 letter (lower case) with using simple consecutive algorithm
    public static void main(String[] arg) {
        List<String> list = defineChars();
        HashCalculator hashCalc = new HashCalculator();
        //input your password below
        Password password = new Password(hashCalc.hash("a"));

        long d1 = System.currentTimeMillis();
        int threadCount = 0;
        String currValue;
        ExecutorService exec = Executors.newCachedThreadPool();
        for (String letter: list){
            for(String letter1: list){
                if (letter != "" && letter1 == "") {
                    continue;
                }
                for(String letter2: list) {
                    if (letter1 != "" && letter2 == ""){
                        continue;
                    }
                    for(String letter3: list) {
                        if (letter2 != "" && letter3 == "") {
                            continue;
                        }
                        for (String letter4: list.subList(0, list.size()-1)) {
                            threadCount++;
                            currValue = letter + letter1 + letter2 + letter3 + letter4;
                            password.stop(hashCalc.hash(currValue), currValue);
                            if (password.getIsFound()){break;}
                        }
                    }
                }
            }
        }
        exec.shutdown();
        long d2 = System.currentTimeMillis();
        System.out.println("Time to found: " + (d2 - d1) + " ms. Attempt count: " + threadCount);
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



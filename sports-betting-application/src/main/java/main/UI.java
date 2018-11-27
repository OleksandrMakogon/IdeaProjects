package main;

import java.util.Scanner;

public class UI {
    Scanner scanner = new Scanner(System.in);
    public String getStringFromConsole(){
        return scanner.nextLine();
    }
    public Double getDoubleFromConsole(){
        return scanner.nextDouble();
    }
}

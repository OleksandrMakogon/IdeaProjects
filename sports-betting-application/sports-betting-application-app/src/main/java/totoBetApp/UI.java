package totoBetApp;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class UI implements View{
    Scanner scanner = new Scanner(System.in);

    @Override
    public String read(){
        System.out.println("Console input:");
        return scanner.nextLine();
    }

    @Override
    public void write(String string){
        System.out.println("Console output: " + string);
    }
}

package arcane;

import java.util.Scanner;

public class Adventurer extends Entity{
    public Adventurer(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Hello Adventurer! Please enter your name: ");
        String newAdventurer = scan.nextLine();
        setName(newAdventurer);
    }
}

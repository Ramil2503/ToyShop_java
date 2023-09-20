package view;

import java.util.Scanner;

public class Console {
    Scanner scanner = new Scanner(System.in);
    public int start() {
        int choice;
        System.out.println("""
                1. Create a new toy
                2. Change a toy
                3. Start a game
                4. Exit
                """);
        choice = scanner.nextInt();
        return choice;
    }
}

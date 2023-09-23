package view;

import java.util.Scanner;
import java.util.List;

import model.Toy;

public class Console {
    Scanner scanner = new Scanner(System.in);
    
    public int start() {
        int choice;
        System.out.println("""
                1. Print all toys
                2. Create a new toy
                3. Change a toy
                4. Start the game
                5. Exit
                """);
        choice = scanner.nextInt();
        return choice;
    }

    public void printToys(List<Toy> toys) {
        for (Toy toy : toys) {
            System.out.println(toy);
        }
    }

    public void printToy(Toy toy) {
        System.out.println(toy);
    }

    public Toy createToy() {
        System.out.println("Enter the name of a toy: ");
        scanner.nextLine();
        String name = scanner.nextLine();
        System.out.println("Enter the amount of toys of this type: ");
        long amount = scanner.nextLong();
        scanner.nextLine();
        Toy toy = new Toy(name, amount);
        return toy;
    }

    public long enterToyID() {
        System.out.println("Enter Toy ID: ");
        long id = scanner.nextLong();
        return id;
    }

    public long enterToyAmount() {
        System.out.println("Enter Toy amount: ");
        long amount = scanner.nextLong();
        return amount;
    }
}

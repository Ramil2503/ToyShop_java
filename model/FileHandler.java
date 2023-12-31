package model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
    private static final String CSV_FILE_PATH = "toys.csv";

    public void saveToCSV(Toy toy) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CSV_FILE_PATH, true))) {
            String line = toy.getId() + "," + toy.getName() + "," + toy.getAmount() + "," + toy.getDrop_chance();
            writer.write(line);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Toy> readFromCSV() {
        List<Toy> toys = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(CSV_FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    int id = Integer.parseInt(parts[0].trim());
                    String name = parts[1].trim();
                    long amount = Long.parseLong(parts[2].trim());
                    int dropChance = Integer.parseInt(parts[3].trim());
                    Toy toy = new Toy(id, name, amount, dropChance);
                    toys.add(toy);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return toys;
    }

    public void updateCSVFile(List<Toy> toys) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CSV_FILE_PATH))) {
            for (Toy toy : toys) {
                String line = toy.getId() + "," + toy.getName() + "," + toy.getAmount() + "," + toy.getDrop_chance();
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

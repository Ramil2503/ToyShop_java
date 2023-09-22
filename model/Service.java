package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Service {
    FileHandler fileHandler = new FileHandler();
    Random random = new Random();

    public void createToy(Toy toy) {
        toy.setId(generateUniqueID());
        fileHandler.saveToCSV(toy);
    }

    public List<Toy> allToys() {
        return countChances(fileHandler.readFromCSV());
    }

    private long generateUniqueID() {
        List<Toy> toys = fileHandler.readFromCSV();
        long lastID = 0;

        for (Toy toy : toys) {
            lastID = Math.max(lastID, toy.getId());
        }

        return lastID + 1;
    }

    public List<Toy> countChances(List<Toy> toys) {
        long amountSum = 0;
        for (Toy toy : toys) {
            amountSum += toy.getAmount();
        }
        for (Toy toy : toys) {
            toy.setDrop_chance(toy.getAmount() * 100 / amountSum);
        }
        return toys;
    }

    public int getRandomToyId() {
        List<Toy> toys = fileHandler.readFromCSV();
        List<Integer> weightedToyIds = new ArrayList<>();

        for (Toy toy : toys) {
            int dropChance = (int) toy.getDrop_chance();
            for (int i = 0; i < dropChance; i++) {
                weightedToyIds.add((int) toy.getId());
            }
        }

        if (!weightedToyIds.isEmpty()) {
            int randomIndex = random.nextInt(weightedToyIds.size());
            return weightedToyIds.get(randomIndex);
        }

        return -1;
    }
}

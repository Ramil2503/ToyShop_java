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
        fileHandler.updateCSVFile(countChances(fileHandler.readFromCSV()));
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

    public void deleteToyById(long id) {
        List<Toy> toys = fileHandler.readFromCSV();
        List<Toy> updatedToys = new ArrayList<>();

        for (Toy toy : toys) {
            if (toy.getId() != id) {
                updatedToys.add(toy);
            }
        }

        fileHandler.updateCSVFile(updatedToys);
    }

    public int getRandomToyId() {
        List<Toy> toys = fileHandler.readFromCSV();
        List<Integer> weightedToyIds = new ArrayList<>();

        for (Toy toy : toys) {
            int dropChance = (int) toy.getAmount();
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

    public Toy getToyById(long id) {
        return getToyFromFile(id);
    }

    public Toy getToyFromFile(long id) {
        List<Toy> toys = fileHandler.readFromCSV();

        for (Toy toy : toys) {
            if (toy.getId() == id) {
                return toy;
            }
        }

        return null;
    }

    public void decreaseToy(long id) {
        decreaseToyById(id);
    }

    public void decreaseToyById(long id) {
        List<Toy> toys = fileHandler.readFromCSV();
        boolean found = false;

        for (Toy toy : toys) {
            if (toy.getId() == id) {
                toy.setAmount(toy.getAmount() - 1);
                found = true;
                break;
            }
        }

        if (found) {
            fileHandler.updateCSVFile(toys);
        } else {
            System.out.println("Toy with ID " + id + " not found.");
        }
    }
}

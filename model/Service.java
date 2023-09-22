package model;

//import java.util.ArrayList;
import java.util.List;

public class Service {
    // private List<Toy> toys = new ArrayList<>();
    FileHandler fileHandler = new FileHandler();

    public void createToy(Toy toy) {
        // toys.add(toy);
        toy.setId(fileHandler.generateUniqueID());
        fileHandler.saveToCSV(toy);
    }

    public List<Toy> allToys() {
        return fileHandler.readFromCSV();
    }
}

package model;

import java.util.ArrayList;
import java.util.List;

public class Service {
    private List<Toy> toys = new ArrayList<>();

    public void createToy(Toy toy) {
        toys.add(toy);
    }

    public List<Toy> allToys() {
        return toys;
    }
}

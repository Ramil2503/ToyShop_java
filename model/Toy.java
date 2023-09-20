package model;
public class Toy {
    private long id;
    private String name;
    private long amount;
    private int drop_chance;

    public Toy (long id, String name, long amount, int drop_chance) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.drop_chance = drop_chance;
    }
}

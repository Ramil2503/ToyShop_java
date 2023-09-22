package model;

public class Toy {
    private long id;
    private String name;
    private long amount;
    private long drop_chance;

    public Toy (long id, String name, long amount, long drop_chance) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.drop_chance = drop_chance;
    }
    
    @Override
    public String toString() {
        return "Toy [id=" + id + ", name=" + name + ", amount=" + amount + ", drop_chance=" + drop_chance + "]";
    }
    
    public Toy (String name, long amount) {
        this.name = name;
        this.amount = amount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public long getDrop_chance() {
        return drop_chance;
    }

    public void setDrop_chance(long drop_chance) {
        this.drop_chance = drop_chance;
    }
}

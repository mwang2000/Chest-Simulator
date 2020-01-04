package model;

public abstract class RareCard extends Card {
    public RareCard(String name) {
        super(name);
        level = 3;
    }
}

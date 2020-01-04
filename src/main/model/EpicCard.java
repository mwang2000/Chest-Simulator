package model;

public abstract class EpicCard extends Card {
    public EpicCard(String name) {
        super(name);
        level = 6;
    }
}

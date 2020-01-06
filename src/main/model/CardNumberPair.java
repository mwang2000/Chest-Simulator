package model;

import java.io.Serializable;
import java.util.ArrayList;

public class CardNumberPair implements Serializable {
    private Card card;
    private int number;
    private int numberToNextLevel;
    private ArrayList<Integer> cardsToUpgrade;

    public CardNumberPair(Card card, int number) {
        this.card = card;
        this.number = number;
        numberToNextLevel = 2;
        cardsToUpgrade = new ArrayList<>();
        cardsToUpgrade.add(2);
        cardsToUpgrade.add(4);
        cardsToUpgrade.add(10);
        cardsToUpgrade.add(20);
        cardsToUpgrade.add(50);
        cardsToUpgrade.add(100);
        cardsToUpgrade.add(200);
        cardsToUpgrade.add(400);
        cardsToUpgrade.add(800);
        cardsToUpgrade.add(1000);
        cardsToUpgrade.add(2000);
        cardsToUpgrade.add(5000);
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void addNumber(int number) {
        this.number += number;
    }

    public Card getCard() {
        return card;
    }

    public int getNumberToNextLevel() {
        return numberToNextLevel;
    }

    public void update() {
        if (card instanceof CommonCard) {
            numberToNextLevel = cardsToUpgrade.get(card.level - 1);
        } else if (card instanceof RareCard) {
            numberToNextLevel = cardsToUpgrade.get(card.level - 3);
        } else if (card instanceof EpicCard) {
            numberToNextLevel = cardsToUpgrade.get(card.level - 6);
        } else {
            numberToNextLevel = cardsToUpgrade.get(card.level - 9);
        }
    }

    public boolean upgradeable() {
        if (card instanceof CommonCard) {
            return number >= numberToNextLevel;
        } else if (card instanceof RareCard) {
            return number >= numberToNextLevel;
        } else if (card instanceof EpicCard) {
            return number >= numberToNextLevel;
        } else {
            return number >= numberToNextLevel;
        }
    }

    public void print() {
        System.out.println(card.getName() + " Level " + card.level + " " + number + "/" + numberToNextLevel);
    }

    public void upgrade() {
        card.level++;
        number -= numberToNextLevel;
    }
}

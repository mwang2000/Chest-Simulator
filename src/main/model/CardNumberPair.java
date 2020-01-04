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
        cardsToUpgrade.add(6);
        cardsToUpgrade.add(16);
        cardsToUpgrade.add(36);
        cardsToUpgrade.add(86);
        cardsToUpgrade.add(186);
        cardsToUpgrade.add(386);
        cardsToUpgrade.add(786);
        cardsToUpgrade.add(1586);
        cardsToUpgrade.add(2586);
        cardsToUpgrade.add(4586);
        cardsToUpgrade.add(9586);
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

//    @Override
//    public void update(Observable o, Object arg) {
//        if (card instanceof CommonCard) {
//            numberToNextLevel = cardsToUpgrade.get(card.level - 1);
//        } else if (card instanceof RareCard) {
//            numberToNextLevel = cardsToUpgrade.get(card.level - 3);
//        } else if (card instanceof EpicCard) {
//            numberToNextLevel = cardsToUpgrade.get(card.level - 6);
//        } else {
//            numberToNextLevel = cardsToUpgrade.get(card.level - 9);
//        }
//    }
}

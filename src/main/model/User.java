package model;

import model.chests.GiantChest;
import model.chests.GoldenChest;
import model.chests.MagicalChest;
import model.chests.SilverChest;

import java.io.*;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Scanner;

public class User implements Serializable {
    private int gold;
    private int xp;
    private int level;
    private ArrayList<Card> deck;
    private ArrayList<CardNumberPair> collection;
    private ArrayList<String> chestCycle;
    private ArrayList<Integer> upgradeCost;
    private int cursor;

    public User () {
        gold = 0;
        xp = 0;
        level = 1;
        deck = new ArrayList<>();
        collection = new ArrayList<>();
        cursor = (int)(Math.random()*(241));
        chestCycle = new ArrayList<>();
        upgradeCost = new ArrayList<>();
        upgradeCost.add(5);
        upgradeCost.add(20);
        upgradeCost.add(50);
        upgradeCost.add(150);
        upgradeCost.add(400);
        upgradeCost.add(1000);
        upgradeCost.add(2000);
        upgradeCost.add(4000);
        upgradeCost.add(8000);
        upgradeCost.add(20000);
        upgradeCost.add(50000);
        upgradeCost.add(100000);
        addChests(240);
        replaceChest(3,"Gold");
        replaceChest(6,"Gold");
        replaceChest(14,"Gold");
        replaceChest(18,"Gold");
        replaceChest(23,"Gold");
        replaceChest(25,"Gold");
        replaceChest(30,"Gold");
        replaceChest(35,"Gold");
        replaceChest(38,"Gold");
        replaceChest(43,"Gold");
        replaceChest(46,"Gold");
        replaceChest(54,"Gold");
        replaceChest(58,"Gold");
        replaceChest(63,"Gold");
        replaceChest(65,"Gold");
        replaceChest(70,"Gold");
        replaceChest(75,"Gold");
        replaceChest(78,"Gold");
        replaceChest(86,"Gold");
        replaceChest(91,"Gold");
        replaceChest(94,"Gold");
        replaceChest(98,"Gold");
        replaceChest(103,"Gold");
        replaceChest(105,"Gold");
        replaceChest(110,"Gold");
        replaceChest(115,"Gold");
        replaceChest(118,"Gold");
        replaceChest(123,"Gold");
        replaceChest(126,"Gold");
        replaceChest(134,"Gold");
        replaceChest(138,"Gold");
        replaceChest(143,"Gold");
        replaceChest(145,"Gold");
        replaceChest(150,"Gold");
        replaceChest(155,"Gold");
        replaceChest(163,"Gold");
        replaceChest(166,"Gold");
        replaceChest(171,"Gold");
        replaceChest(174,"Gold");
        replaceChest(178,"Gold");
        replaceChest(183,"Gold");
        replaceChest(185,"Gold");
        replaceChest(195,"Gold");
        replaceChest(198,"Gold");
        replaceChest(206,"Gold");
        replaceChest(211,"Gold");
        replaceChest(214,"Gold");
        replaceChest(218,"Gold");
        replaceChest(223,"Gold");
        replaceChest(225,"Gold");
        replaceChest(235,"Gold");
        replaceChest(238,"Gold");
        replaceChest(11,"Magical");
        replaceChest(83,"Magical");
        replaceChest(131,"Magical");
        replaceChest(203,"Magical");
        replaceChest(51,"Giant");
        replaceChest(158,"Giant");
        replaceChest(190,"Giant");
        replaceChest(230,"Giant");

    }

    private void replaceChest(int index, String chest) {
        chestCycle.remove(index);
        chestCycle.add(index,chest);
    }

    public void addChests(int number) {
        for (int i = 0; i < number; i++) {
            chestCycle.add("Silver");
        }
    }

    public void addGold(int gold) {
        this.gold += gold;
    }

    public void addXp(int exp) {
        xp += exp;
        if (xp > 20 && xp <70) {
            level = 2;
        } else if (xp < 170) {
            level = 3;
        } else if (xp < 370) {
            level = 4;
        } else if (xp < 770) {
            level = 5;
        } else if (xp < 1770) {
            level = 6;
        } else if (xp < 3770) {
            level = 7;
        } else if (xp < 8770) {
            level = 8;
        } else if (xp < 18770) {
            level = 9;
        } else if (xp < 48770) {
            level = 10;
        } else if (xp < 88770) {
            level = 11;
        } else if (xp < 168770) {
            level = 12;
        } else {
            level = 13;
        }
    }

    public void showDeck() {
        System.out.println("You have " + gold + " gold");
        System.out.println("Level: " + level);d` `
        System.out.println("Deck:\n" + printDeck());
    }

    private String printDeck() {
        StringBuilder print = new StringBuilder();
        for (Card c : deck) {
            print.append(c.getName()).append("\n");
        }
        return print.toString();
    }

    public void printCollection() {
        for (CardNumberPair c : collection) {
            c.print();
        }
    }

    void changeDeck() {
        showDeck();
        printCollection();
        if (deck.size() == 0) {
            addCard();
        } else if (deck.size() < 8) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Would you like to:" +
                    "1. Add a card" +
                    "2. Change a card");
            int choice = scanner.nextInt();
            if (choice == 1) {
                addCard();
            } else if (choice == 2) {
                changeCard();
            } else {
                changeDeck();
            }
        } else {
            changeCard();
        }
    }

    private Card chooseCard() {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        for (CardNumberPair c : collection) {
            if (c.getCard().getName().equals(name)) {
                return c.getCard();
            }
        }
        return null;
    }

    private void addCard() {
        System.out.println("What card would you like to add to your deck?");
        Card toBeAdded = chooseCard();
        if (deck.contains(toBeAdded)) {
            System.out.println("Card already in deck. Try again.");
            addCard();
        } else {
            deck.add(toBeAdded);
            showDeck();
        }
    }

    private void changeCard() {
        System.out.println("What card would you like to add to your deck?");
        Card toBeAdded = chooseCard();
        if (deck.contains(toBeAdded)) {
            System.out.println("Card already in deck. Try again.");
            changeCard();
        } else {
            System.out.println("What card would you like to remove?");
            Card toBeRemoved = chooseCard();
            deck.remove(toBeRemoved);
            deck.add(toBeAdded);
            showDeck();
        }
    }

    void openNextChest() {
        switch (chestCycle.get(cursor)) {
            case "Silver":
                addRewards(new SilverChest());
                break;
            case "Gold":
                addRewards(new GoldenChest());
                break;
            case "Giant":
                addRewards(new GiantChest());
                break;
            default:
                addRewards(new MagicalChest());
                break;
        }
        if (cursor == 240) {
            cursor = 1;
        } else {
            cursor++;
        }
    }

    private void addRewards(Chest chest) {
        addGold(chest.getGold());
        for (CardNumberPair c : chest.getCardRewards()) {
            if (collectionHasCard(c) != null) {
                collectionHasCard(c).addNumber(c.getNumber());
            } else {
                collection.add(c);
            }
        }
    }

    private CardNumberPair collectionHasCard(CardNumberPair c) {
        if (collection.size() > 0) {
            for (CardNumberPair cardNumberPair : collection) {
                if (cardNumberPair.getCard().equals(c.getCard())) {
                    return cardNumberPair;
                }
            }
        }
        return null;
    }

    public void upgradeCard() {
        System.out.println("Which card would you like to upgrade?");
        Card card = chooseCard();
        CardNumberPair cardNumberPair = findPair(card);
        if (cardNumberPair != null) {
            if (cardNumberPair.upgradeable()) {
                cardNumberPair.setNumber(cardNumberPair.getNumber() - cardNumberPair.getNumberToNextLevel());
                assert card != null;
                card.upgrade();
                cardNumberPair.update();
                if (gold >= requiredGold(card)) {
                    gold -= requiredGold(card);
                    cardNumberPair.print();
                } else {
                    System.out.println("Not enough gold to upgrade.");
                }
            } else {
                System.out.println("Not enough cards to upgrade. Please try again.");
            }
        } else {
            System.out.println("The card does not exist in your collection.");
        }
    }

    private int requiredGold(Card card) {
        if (card instanceof CommonCard || card instanceof RareCard) {
            return upgradeCost.get(card.level - 1);
        } else if (card instanceof EpicCard) {
            if (card.level == 6) {
                return 600;
            } else {
                return upgradeCost.get(card.level - 1);
            }
        } else {
            if (card.level == 9) {
                return 5000;
            } else {
                return upgradeCost.get(card.level - 1);
            }
        }
    }

    private CardNumberPair findPair(Card card) {
        for (CardNumberPair c : collection) {
            if (c.getCard() == card) {
                return c;
            }
        }
        return null;
    }

    public void save() throws IOException {
        FileOutputStream fos = new FileOutputStream("UserSavedData");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(this);
        oos.close();
    }

    public User load() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("UserSavedData");
        ObjectInputStream ois = new ObjectInputStream(fis);
        User user = (User)ois.readObject();
        ois.close();
        return user;
    }
}

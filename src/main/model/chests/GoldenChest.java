package model.chests;

import model.Card;
import model.CardNumberPair;
import model.Chest;
import java.util.ArrayList;

public class GoldenChest extends Chest {
    public GoldenChest() {
        gold = getRandomInt(532,608);
        getLegendary();
        getEpic();
        getRares();
        getCommons();
        printRewards();
    }

    public void getLegendary() {
        if (getRandomDouble(0,100) <= 0.673) {
            Card legendary = legendaryCards.get(getRandomInt(0, legendaryCards.size() - 1));
            cardRewards.add(new CardNumberPair(legendary, 1));
        }
    }

    public void getEpic() {
        if (getRandomDouble(0,100) <= 19) {
            Card epic = epicCards.get(getRandomInt(0, epicCards.size() - 1));
            cardRewards.add(new CardNumberPair(epic, 1));
        }
    }

    public void getRares() {
        boolean extraRare = getRandomDouble(0,100) <= 50;
        ArrayList<Card> copy = new ArrayList<>(rareCards);
        Card rare = copy.get(getRandomInt(0, copy.size() - 1));
        copy.remove(rare);
        Card rare2 = copy.get(getRandomInt(0, copy.size() - 1));
        int rareNumber = getRandomInt(1,8);
        int rareNumber2 = 9 - rareNumber;
        if (extraRare) {
            if (getRandomInt(1,2) == 1) {
                if (rare == rare2) {
                    cardRewards.add(new CardNumberPair(rare,10));
                } else {
                    rareNumber += 1;
                    cardRewards.add(new CardNumberPair(rare,rareNumber));
                    cardRewards.add(new CardNumberPair(rare2,rareNumber2));
                }
            } else {
                if (rare == rare2) {
                    cardRewards.add(new CardNumberPair(rare,9));
                } else {
                    rareNumber2 += 1;
                    cardRewards.add(new CardNumberPair(rare,rareNumber));
                    cardRewards.add(new CardNumberPair(rare2,rareNumber2));
                }
            }
        }
    }

    public void getCommons() {
        int numCommon = 38;
        ArrayList<Card> copy = new ArrayList<>(commonCards);
        for (CardNumberPair c: cardRewards) {
            numCommon -= c.getNumber();
        }
        Card common = copy.get(getRandomInt(0,copy.size() - 1));
        copy.remove(common);
        Card common2 = copy.get(getRandomInt(0,copy.size() - 1));
        if (common == common2) {
            cardRewards.add(new CardNumberPair(common,numCommon));
        } else {
            int commonNumber = getRandomInt(1, numCommon - 1);
            int commonNumber2 = numCommon - commonNumber;
            cardRewards.add(new CardNumberPair(common, commonNumber));
            cardRewards.add(new CardNumberPair(common2, commonNumber2));
        }
    }

    private void printRewards() {
        String print = "You have opened a golden chest and won:\n";
        print = print + gold + " gold\n";
        for (CardNumberPair c : cardRewards) {
            print = print + c.getCard().getName() + " x" + c.getNumber() + "\n";
        }
        System.out.println(print);
    }
}

package model.chests;

import model.Card;
import model.CardNumberPair;
import model.Chest;

import java.util.ArrayList;

public class GiantChest extends Chest {
    public GiantChest() {
        gold = 2961;
        getLegendary();
        getEpic();
        getRares();
        getCommons();
        printRewards();
    }
    @Override
    public void getLegendary() {
        if (getRandomDouble100() <= 2.33) {
            Card legendary = legendaryCards.get(getRandomInt(0, legendaryCards.size() - 1));
            cardRewards.add(new CardNumberPair(legendary, 1));
        }
    }

    @Override
    public void getEpic() {
        if (extraEpic()) {
            Card epic = epicCards.get(getRandomInt(0, epicCards.size() - 1));
            cardRewards.add(new CardNumberPair(epic, 1));
        }
    }

    public boolean extraEpic() {
        return getRandomDouble100() <= 65.8;
    }

    private boolean twoCommons() {
        return getRandomInt(1,2) == 1;
    }

    @Override
    public void getRares() {
        boolean extraRare = getRandomDouble100() <= 80;
        ArrayList<Card> copy = new ArrayList<>(rareCards);
        if (extraEpic() || twoCommons()) {
            Card rare = copy.get(getRandomInt(0,rareCards.size() - 1));
            if (extraRare) {
                cardRewards.add(new CardNumberPair(rare,66));
            } else {
                cardRewards.add(new CardNumberPair(rare,65));
            }
        } else {
            Card rare = copy.get(getRandomInt(0,rareCards.size() - 1));
            Card rare2 = copy.get(getRandomInt(0,rareCards.size() - 1));
            int rareNumber = getRandomInt(1,64);
            int rareNumber2 = 64 - rareNumber;
            if (rare == rare2) {
                if (extraRare) {
                    cardRewards.add(new CardNumberPair(rare,66));
                } else {
                    cardRewards.add(new CardNumberPair(rare,65));
                }
            } else {
                if (getRandomInt(1, 2) == 1) {
                    rareNumber += 1;
                } else {
                    rareNumber2 += 1;
                }
                cardRewards.add(new CardNumberPair(rare,rareNumber));
                cardRewards.add(new CardNumberPair(rare2,rareNumber2));
            }
        }
    }

    @Override
    public void getCommons() {
        int numCommon = 329;
        for (CardNumberPair c : cardRewards) {
            numCommon -= c.getNumber();
        }
        ArrayList<Card> copy = new ArrayList<>(commonCards);
        if (twoCommons()) {
            Card common = copy.get(getRandomInt(0,copy.size() - 1));
            copy.remove(common);
            Card common2 = copy.get(getRandomInt(0,copy.size() - 1));
            int commonNumber = getRandomInt(1,numCommon - 1);
            int commonNumber2 = numCommon - commonNumber;
            if (common == common2) {
                cardRewards.add(new CardNumberPair(common,numCommon));
            } else {
                cardRewards.add(new CardNumberPair(common, commonNumber));
                cardRewards.add(new CardNumberPair(common2, commonNumber2));
            }
        } else {
            Card common = commonCards.get(getRandomInt(0,commonCards.size() - 1));
            cardRewards.add(new CardNumberPair(common,numCommon));
        }
    }

    private void printRewards() {
        String print = "You have opened a giant chest and won:\n";
        print = print + gold + " gold\n";
        for (CardNumberPair c : cardRewards) {
            print = print + c.getCard().getName() + " x" + c.getNumber() + "\n";
        }
        System.out.println(print);
    }
}

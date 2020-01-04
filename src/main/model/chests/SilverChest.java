package model.chests;

import model.Card;
import model.CardNumberPair;
import model.Chest;

public class SilverChest extends Chest {

    public SilverChest() {
        gold = getRandomInt(133,152);
        getLegendary();
        getEpic();
        getRares();
        getCommons();
        printRewards();
    }

    public boolean hasLegendary() {
        return getRandomDouble(0,100) <= 0.135;
    }

    public boolean hasEpic() {
        return getRandomDouble(0,100) <= 3.8;
    }

    public void getLegendary() {
        if (hasLegendary()) {
            Card legendary = legendaryCards.get(getRandomInt(0, legendaryCards.size() - 1));
            cardRewards.add(new CardNumberPair(legendary, 1));
        }
    }

    public void getEpic() {
        if (hasEpic()) {
            Card epic = epicCards.get(getRandomInt(0, epicCards.size() - 1));
            cardRewards.add(new CardNumberPair(epic, 1));
        }
    }

    public void getRares() {
        boolean extraRare = getRandomDouble(0,100) <= 11.111;
        Card rare = rareCards.get(getRandomInt(0, rareCards.size() - 1));
        if (extraRare) {
            Card rare2 = rareCards.get(getRandomInt(0, rareCards.size() - 1));
            if (rare2 == rare) {
                cardRewards.add(new CardNumberPair(rare,3));
            } else {
                cardRewards.add(new CardNumberPair(rare,2));
                cardRewards.add(new CardNumberPair(rare2,1));
            }
        } else {
            cardRewards.add(new CardNumberPair(rare,2));
        }
    }

    public void getCommons() {
        int num = 19;
        for (CardNumberPair c: cardRewards) {
            num -= c.getNumber();
        }
        Card common = commonCards.get(getRandomInt(0,commonCards.size() - 1));
        cardRewards.add(new CardNumberPair(common,num));
    }

    private void printRewards() {
        String print = "You have opened a silver chest and won:\n";
        print = print + gold + " gold\n";
        for (CardNumberPair c : cardRewards) {
            print = print + c.getCard().getName() + " x" + c.getNumber() + "\n";
        }
        System.out.println(print);
    }
}

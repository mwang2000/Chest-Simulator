package model.chests;

import model.Card;
import model.CardNumberPair;
import model.Chest;

import java.util.ArrayList;

public class MagicalChest extends Chest {
    public MagicalChest() {
        gold = 1504;
        getLegendary();
        getEpic();
        getRares();
        getCommons();
        printRewards();
    }

    @Override
    public void getLegendary() {
        if (getRandomDouble100() <= 22.194) {
            Card legendary = legendaryCards.get(getRandomInt(0, legendaryCards.size() - 1));
            cardRewards.add(new CardNumberPair(legendary, 1));
        }
    }

    @Override
    public void getEpic() {
        if (getRandomDouble100() <= 40) {
            Card epic = epicCards.get(getRandomInt(0, epicCards.size() - 1));
            cardRewards.add(new CardNumberPair(epic, 1));
        }
    }

    @Override
    public void getRares() {
        boolean extraRare = false;
        if (getRandomDouble100() <= 80) {
            extraRare = true;
        }
        ArrayList<Card> copy = new ArrayList<>(rareCards);
        Card rare = copy.get(getRandomInt(0,copy.size()));
        copy.remove(rare);
        Card rare2 = copy.get(getRandomInt(0,copy.size()));
        copy.remove(rare2);
        Card rare3 = copy.get(getRandomInt(0,copy.size()));
        int rareNumber;
        int rareNumber2;
        int rareNumber3;
        if (extraRare) {
            rareNumber = getRandomInt(1,17);
            rareNumber2 = getRandomInt(1,19 - rareNumber);
            rareNumber3 = 19 - rareNumber - rareNumber2;
        } else {
            rareNumber = getRandomInt(1,16);
            rareNumber2 = getRandomInt(1,18 - rareNumber);
            rareNumber3 = 18 - rareNumber - rareNumber2;
        }
        if ((rare == rare2) && (rare2 == rare3)) {
            cardRewards.add(new CardNumberPair(rare,19));
        } else if (rare == rare2) {
            addDuplicate(rare,rare2,rareNumber,rareNumber2);
            cardRewards.add(new CardNumberPair(rare3,rareNumber3));
        } else if (rare2 == rare3) {
            addDuplicate(rare2,rare3,rareNumber2,rareNumber3);
            cardRewards.add(new CardNumberPair(rare,rareNumber));
        } else if (rare == rare3) {
            addDuplicate(rare,rare3,rareNumber,rareNumber3);
            cardRewards.add(new CardNumberPair(rare2,rareNumber2));
        } else {
            cardRewards.add(new CardNumberPair(rare,rareNumber));
            cardRewards.add(new CardNumberPair(rare2,rareNumber2));
            cardRewards.add(new CardNumberPair(rare3,rareNumber3));
        }
    }

    private void addDuplicate(Card a, Card b, int aNumber, int bNumber) {
        if (a == b) {
            cardRewards.add(new CardNumberPair(a,aNumber + bNumber));
        }
    }

    @Override
    public void getCommons() {
        int numCommon = 94;
        for (CardNumberPair c : cardRewards) {
            numCommon -= c.getNumber();
        }
        ArrayList<Card> copy = new ArrayList<>(commonCards);
        Card common = copy.get(getRandomInt(0,copy.size()));
        copy.remove(common);
        Card common2 = copy.get(getRandomInt(0,copy.size()));
        copy.remove(common2);
        Card common3 = copy.get(getRandomInt(0,copy.size()));
        int commonNumber;
        int commonNumber2;
        int commonNumber3;
        commonNumber = getRandomInt(1,numCommon - 2);
        commonNumber2 = getRandomInt(1,numCommon - commonNumber);
        commonNumber3 = numCommon - commonNumber - commonNumber2;
        if ((common == common2) && (common2 == common3)) {
            cardRewards.add(new CardNumberPair(common,numCommon));
        } else if (common == common2) {
            addDuplicate(common,common2,commonNumber,commonNumber2);
            cardRewards.add(new CardNumberPair(common3,commonNumber3));
        } else if (common2 == common3) {
            addDuplicate(common2,common3,commonNumber2,commonNumber3);
            cardRewards.add(new CardNumberPair(common,commonNumber));
        } else if (common == common3) {
            addDuplicate(common,common3,commonNumber,commonNumber3);
            cardRewards.add(new CardNumberPair(common2,commonNumber2));
        } else {
            cardRewards.add(new CardNumberPair(common,commonNumber));
            cardRewards.add(new CardNumberPair(common2,commonNumber2));
            cardRewards.add(new CardNumberPair(common3,commonNumber3));
        }
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

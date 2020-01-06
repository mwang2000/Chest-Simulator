package model;

import model.commonCards.*;
import model.epicCards.*;
import model.legendaryCards.*;
import model.rareCards.*;

import java.util.ArrayList;

public abstract class Chest {
    protected int gold;
    protected ArrayList<CardNumberPair> cardRewards;
    protected ArrayList<Card> commonCards;
    protected ArrayList<Card> rareCards;
    protected ArrayList<Card> epicCards;
    protected ArrayList<Card> legendaryCards;

    public Chest() {
        gold = 0;
        cardRewards = new ArrayList<>();
        commonCards = new ArrayList<>();
        rareCards = new ArrayList<>();
        epicCards = new ArrayList<>();
        legendaryCards = new ArrayList<>();
        commonCards.add(new Archers());
        commonCards.add(new Arrows());
        commonCards.add(new Barbarians());
        commonCards.add(new Bats());
        commonCards.add(new Bomber());
        commonCards.add(new Cannon());
        commonCards.add(new EliteBarbarians());
        commonCards.add(new FireSpirits());
        commonCards.add(new GoblinGang());
        commonCards.add(new Goblins());
        commonCards.add(new IceSpirit());
        commonCards.add(new Knight());
        commonCards.add(new MinionHorde());
        commonCards.add(new Minions());
        commonCards.add(new Mortar());
        commonCards.add(new Rascals());
        commonCards.add(new RoyalGiant());
        commonCards.add(new RoyalRecruits());
        commonCards.add(new SkeletonBarrel());
        commonCards.add(new Skeletons());
        commonCards.add(new Snowball());
        commonCards.add(new SpearGoblins());
        commonCards.add(new Tesla());
        commonCards.add(new Zap());
        rareCards.add(new BarbarianHut());
        rareCards.add(new BattleHealer());
        rareCards.add(new BattleRam());
        rareCards.add(new BombTower());
        rareCards.add(new DartGoblin());
        rareCards.add(new Earthquake());
        rareCards.add(new ElixirCollector());
        rareCards.add(new ElixirGolem());
        rareCards.add(new Fireball());
        rareCards.add(new FlyingMachine());
        rareCards.add(new Furnace());
        rareCards.add(new Giant());
        rareCards.add(new GoblinGang());
        rareCards.add(new GoblinHut());
        rareCards.add(new Heal());
        rareCards.add(new HogRider());
        rareCards.add(new IceGolem());
        rareCards.add(new InfernoTower());
        rareCards.add(new MegaMinion());
        rareCards.add(new MiniPekka());
        rareCards.add(new Musketeer());
        rareCards.add(new Rocket());
        rareCards.add(new RoyalHogs());
        rareCards.add(new ThreeMusketeers());
        rareCards.add(new Tombstone());
        rareCards.add(new Valkyrie());
        rareCards.add(new Wizard());
        rareCards.add(new Zappies());
        epicCards.add(new BabyDragon());
        epicCards.add(new Balloon());
        epicCards.add(new BarbarianBarrel());
        epicCards.add(new Bowler());
        epicCards.add(new CannonCart());
        epicCards.add(new Clone());
        epicCards.add(new DarkPrince());
        epicCards.add(new ElectroDragon());
        epicCards.add(new Executioner());
        epicCards.add(new Freeze());
        epicCards.add(new GiantSkeleton());
        epicCards.add(new GoblinBarrel());
        epicCards.add(new GoblinGiant());
        epicCards.add(new Golem());
        epicCards.add(new Guards());
        epicCards.add(new Hunter());
        epicCards.add(new Lightning());
        epicCards.add(new Mirror());
        epicCards.add(new Pekka());
        epicCards.add(new Poison());
        epicCards.add(new Prince());
        epicCards.add(new Rage());
        epicCards.add(new SkeletonArmy());
        epicCards.add(new Tornado());
        epicCards.add(new Wallbreakers());
        epicCards.add(new Witch());
        epicCards.add(new Xbow());
        legendaryCards.add(new Bandit());
        legendaryCards.add(new ElectroWizard());
        legendaryCards.add(new Fisherman());
        legendaryCards.add(new Graveyard());
        legendaryCards.add(new IceWizard());
        legendaryCards.add(new InfernoDragon());
        legendaryCards.add(new LavaHound());
        legendaryCards.add(new Log());
        legendaryCards.add(new Lumberjack());
        legendaryCards.add(new MagicArcher());
        legendaryCards.add(new MegaKnight());
        legendaryCards.add(new Miner());
        legendaryCards.add(new NightWitch());
        legendaryCards.add(new Princess());
        legendaryCards.add(new RamRider());
        legendaryCards.add(new RoyalGhost());
        legendaryCards.add(new Sparky());
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getGold() {
        return gold;
    }

    public ArrayList<CardNumberPair> getCardRewards() {
        return cardRewards;
    }

    protected int getRandomInt(int min, int max) {
        return (int)(Math.random()*((max - min) + 1)) + min;
    }

    protected double getRandomDouble100() {
        return (int)(Math.random()*(((double) 100 - (double) 0) + 1)) + (double) 0;
    }

    public abstract void getLegendary();

    public abstract void getEpic();

    public abstract void getRares();

    public abstract void getCommons();
}

package model;

import exceptions.InvalidChoiceException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        User user = new User();
        File file = new File("UserSavedData");
        if (file.length() > 0) {
            user = user.load();
        }
        while (true) {
            System.out.println("What would you like to do? " +
                    "1. Check your deck " +
                    "2. Change your deck " +
                    "3. Upgrade a card" +
                    "4. Open your next chest" +
                    "5. Save and exit");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            if (choice == 1) {
                user.showDeck();
                user.printCollection();
            } else if (choice == 2) {
                user.changeDeck();
            } else if (choice == 3) {
                user.upgradeCard();
            } else if (choice == 4) {
                user.openNextChest();
            } else if (choice == 5) {
                user.save();
            } else {
                System.out.println("That is not one of the choices. Please try again.");
            }
        }
    }

}

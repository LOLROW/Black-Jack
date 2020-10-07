import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String [] Args) {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Start game?" + "\n(1): Yes" + "\n(2): No");
        String oto = myObj.nextLine();
        if (oto.equals("1")) {
            random();
        }
        else {
            System.out.println("OK");
        }
    }
    public static void random() {
        Cards cards = new Cards();
        Random rnd = new Random();
        int cnio = rnd.nextInt(12);
        int ctio = rnd.nextInt(4);
        int cnit = rnd.nextInt(12);
        int ctit = rnd.nextInt(4);
        if (cnio < 0 || ctio < 0) {
            random();
        }
        else {
            if (cards.cN[cnio].equals("Jack") || cards.cN[cnio].equals("Queen") || cards.cN[cnio].equals("King")) {
                System.out.println("Your Cards: ");
                System.out.println("(1)" + cards.cN[cnio] + " of " + cards.cT[ctio]);
                cnio = 10;

                if (cards.cN[cnit].equals("Jack") || cards.cN[cnit].equals("Queen") || cards.cN[cnit].equals("King")) {
                    System.out.println("(1)" + cards.cN[cnit] + " of " + cards.cT[ctit]);
                    cnit = 10;
                    cnio = cnio + cnit;

                    bot(cnio, ctio, cnit);
                }
				bot(cnio, ctio, cnit);
            }
            else {
                System.out.println("Your Cards: ");
                System.out.println("(1)" + cards.cN[cnio] + " of " + cards.cT[ctio]);
                cnio = cnio + 1;

                if (cards.cN[cnit].equals("Jack") || cards.cN[cnit].equals("Queen") || cards.cN[cnit].equals("King")) {
                    System.out.println("(1)" + cards.cN[cnit] + " of " + cards.cT[ctit]);
                    cnit = cnit + 1;
                    cnio = cnio + cnit;

                    bot(cnio, ctio, cnit);
                }
                bot(cnio, ctio, cnit);
            }
        }
    }
    public static void bot(int cnio, int ctio, int cnit) {
        Cards cards = new Cards();
        Random rnd = new Random();
        int cnib = rnd.nextInt(12);
        int ctib = rnd.nextInt(4);
        int cnibt = rnd.nextInt(12);
        int ctibt = rnd.nextInt(4);
        if (cnib < 0 || ctib < 0) {
            bot(cnio, ctio, cnit);
        }
        else {
            if (cards.cN[cnib].equals("Jack") || cards.cN[cnib].equals("Queen") || cards.cN[cnib].equals("King")) {
                System.out.println("Your Opponent's Cards: ");
                System.out.println("(1)" + cards.cN[cnib] + " of " + cards.cT[ctib]);
                cnib = 10;
                calculate(cnio, cnib);
            }
            else {
                System.out.println("Your Opponent's Cards: ");
                System.out.println("(1)" + cards.cN[cnib] + " of " + cards.cT[ctib]);
                cnib = cnib + 1;
                calculate(cnio, cnib);
            }
        }
    }
    public static void calculate(int cardsPlayer, int cardsBot) {
        Random rnd = new Random();
        Scanner myObj = new Scanner(System.in);
        while (true) {
            System.out.println("Hit or Stay?: 1 / 2");
            String hitQ = myObj.nextLine();

            if (hitQ.equals("1")) {
                hitPlayer(cardsPlayer, cardsBot);
            }
            else {
                int cni2 = 0;
                hitBot(cardsPlayer, cardsBot, cni2);
            }
        }
    }
    public static void hitPlayer(int cardsPlayer, int cardsBot) {
        Scanner myObj = new Scanner(System.in);
        Random rnd = new Random();
        Cards cards = new Cards();
        int cni2 = rnd.nextInt(12);
        int cti2 = rnd.nextInt(4);

        if (cni2 < 0) {
            hitPlayer(cardsPlayer, cardsBot);
        }
        else {
            if (cards.cN[cni2].equals("Jack") || cards.cN[cni2].equals("Queen") || cards.cN[cni2].equals("King")) {
                System.out.println("You got a " + cards.cN[cni2] + " of " + cards.cT[cti2]);
                cni2 = 10;
                hitBot(cardsPlayer, cardsBot, cni2);
            }
            else if (cards.cN[cni2].equals("Ace")) {
                System.out.println("You got a " + cards.cN[cni2] + " of " + cards.cT[cti2]);
                System.out.println("1 or 11?: ");
                int e = myObj.nextInt();

                if (e == 1) {
                    cni2 = 1;
                    hitBot(cardsPlayer, cardsBot, cni2);
                }
                else {
                    cni2 = 11;
                    hitBot(cardsPlayer, cardsBot, cni2);
                }
            }
            else {
                System.out.println("You got a " + cards.cN[cni2] + " of " + cards.cT[cti2]);
                cni2 = cni2 + 1;
                hitBot(cardsPlayer, cardsBot, cni2);
            }
        }
    }
    public static void hitBot(int cardsPlayer, int cardsBot, int cni2) {
        Random rnd = new Random();
        Cards cards = new Cards();
        int cnib2 = rnd.nextInt(12);
        int ctib2 = rnd.nextInt(4);

        if (cnib2 < 0) {
            hitBot(cardsPlayer, cardsBot, cni2);
        }
        else {
            if (cards.cN[cnib2].equals("Jack") || cards.cN[cnib2].equals("Queen") || cards.cN[cnib2].equals("King")) {
                System.out.println("Bot got a " + cards.cN[cnib2] + " of " + cards.cT[ctib2]);
                cnib2 = 10;
                finishGame(cardsPlayer, cardsBot, cni2, cnib2);
            }
            else {
                System.out.println("Bot got a " + cards.cN[cni2] + " of " + cards.cT[ctib2]);
                cnib2 = cni2 + 1;
                finishGame(cardsPlayer, cardsBot, cni2, cnib2);
            }
        }
    }
    public static void finishGame(int cardsPlayer, int cardsBot, int cni2, int cnib2) {
        cardsPlayer = cardsPlayer + cni2;
        cardsBot = cardsBot + cnib2;

        if (cardsPlayer > 21 || cardsBot > 21) {
            if (cardsPlayer > 21 && cardsBot > 21) {
                System.out.println("Tie!");
                System.out.println("Player total: " + cardsPlayer + "\nBot total: " + cardsBot); System.exit(0);
            }
            else if (cardsPlayer > 21 && cardsBot < 21) {
                System.out.println("Bot wins!");
                System.out.println("Player total: " + cardsPlayer + "\nBot total: " + cardsBot); System.exit(0);
            }
            else if (cardsPlayer < 21 && cardsBot > 21) {
                System.out.println("Player wins!");
                System.out.println("Player total: " + cardsPlayer + "\nBot total: " + cardsBot); System.exit(0);
            }
        }
        else {
            if (cardsPlayer > cardsBot) {
                System.out.println("Player wins!");
                System.out.println("Player total: " + cardsPlayer + "\nBot total: " + cardsBot); System.exit(0);
            }
            else if (cardsPlayer < cardsBot) {
                System.out.println("Bot wins!");
                System.out.println("Player total: " + cardsPlayer + "\nBot total: " + cardsBot); System.exit(0);
            }
        }
    }
}
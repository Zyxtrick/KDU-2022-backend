package com.rishav.crypto.Menu;

import java.util.Scanner;

public class Menu extends Thread{

    /*
    *    a. Given the name or code of a coin, retrieve all its details.
    *    b. Display top 50 coins in the market based on price.
    *    c. For a given trader, show his portfolio.
    *    d. For a given trader, display the total profit or loss they have made trading in the crypto market.
    *    e. Show top 5 and bottom 5 traders based on their profit/loss.
    *
    * */

    @Override
    public void run() {
        displayMenu();
    }

    public void displayMenu() {
        Scanner sc = new Scanner(System.in);
        boolean shallExit = false;
        do {
            System.out.println("============ M E N U ===========");
            System.out.println("1. Retrieve the details of a coin. ");
            System.out.println("2. Display top 50 coins in the market based on price.");
            System.out.println("3. For a given trader, show his portfolio.");
            System.out.println("4. For a given trader, display the total profit or loss they have made trading in the crypto market.");
            System.out.println("5. Show top 5 and bottom 5 traders based on their profit/loss.\n");
            System.out.println("Press any other Key to exit\n");
            int userChoice = sc.nextInt();
            MenuUtil menuUtil = new MenuUtil();
            switch (userChoice) {
                case 1:
                    menuUtil.getDetailsByNameOrCodeOfCoin();
                    break;
                case 2:
                    menuUtil.get50CoinsOnPrice();
                    break;
                case 3:
                    menuUtil.getTraderPortfolio();
                    break;
                case 4:
                    menuUtil.displayProfitAndLossOfEachTrader();
                    break;
                case 5:
                    menuUtil.getTopAndBottomTraders();
                    break;
                default:
                    shallExit = true;
                    break;
            }
        }while(!shallExit);
    }

}

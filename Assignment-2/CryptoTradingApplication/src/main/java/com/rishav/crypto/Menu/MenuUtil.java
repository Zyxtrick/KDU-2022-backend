package com.rishav.crypto.Menu;

import com.rishav.crypto.models.Coin;
import com.rishav.crypto.models.Trader;

import java.util.Comparator;
import java.util.Locale;
import java.util.Scanner;

import static com.rishav.crypto.TransactionFactory.TransactionLogs.listOfCoins;
import static com.rishav.crypto.TransactionFactory.TransactionLogs.listOfTraders;

public class MenuUtil {
    Scanner sc = null;

    public MenuUtil(){
        sc = new Scanner(System.in);
    }

    public void getDetailsByNameOrCodeOfCoin() {
        System.out.println("Enter Coin Name : ");
        String coinName = sc.next();
        coinName = coinName.toUpperCase(Locale.ROOT);
        String finalCoinName = coinName;
        listOfCoins.stream().filter(coin -> coin.getName().toUpperCase(Locale.ROOT).equals(finalCoinName))
                .forEach(System.out::println);


        System.out.println("Enter Coin Symbol : ");
        String coinSymbol = sc.next();
        coinSymbol = coinSymbol.toUpperCase(Locale.ROOT);
        String finalCoinSymbol = coinSymbol;
        listOfCoins.stream().filter(coin -> coin.getSymbol().toUpperCase(Locale.ROOT).equals(finalCoinSymbol))
                .forEach(System.out::println);

    }

    public void get50CoinsOnPrice() {
        System.out.println("============== GET TOP 50 COINS BASED ON PRICE ==============");
        listOfCoins.stream()
                .sorted(Comparator.comparingDouble(Coin::getPrice).reversed())
                .limit(50)
                .forEach(System.out::println);
    }

    public void getTraderPortfolio() {
        System.out.println("============== GET TRADER PORTFOLIO =========================");
        System.out.println("Enter the walletAddress of the Trader");
        String traderWalletAddress = sc.next();
        listOfTraders.stream().filter(trader -> trader.getWalletAddress().toUpperCase(Locale.ROOT).equals(traderWalletAddress.toUpperCase(Locale.ROOT)))
                .forEach(Trader::printTraderPortfolio);
    }

    public void displayProfitAndLossOfEachTrader() {
        System.out.println("============== DISPLAY PROFIT AND LOSS OF EACH TRADER ================");
        System.out.println("Enter the walletAddress of the Trader");
        String traderWalletAddress = sc.next();
        listOfTraders.stream().filter(trader -> trader.getWalletAddress().toUpperCase(Locale.ROOT).equals(traderWalletAddress.toUpperCase(Locale.ROOT)))
                .forEach(trader -> {
                    System.out.println(trader.getFirstName() + " " + trader.getLastName() + " : "+ trader.getProfit());
                });
    }

    public void getTopAndBottomTraders() {
        System.out.println("=============== TOP 5 TRADERS =========================");
        listOfTraders.stream().sorted(Comparator.comparingDouble(Trader::getProfit).reversed())
                .limit(5)
                .forEach(System.out::println);

        System.out.println("=============== BOTTOM 5 TRADERS =========================");
        listOfTraders.stream().sorted(Comparator.comparingDouble(Trader::getProfit))
                .limit(5)
                .forEach(System.out::println);
    }
}

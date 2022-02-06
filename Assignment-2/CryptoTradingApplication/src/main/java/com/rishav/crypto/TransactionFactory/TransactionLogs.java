package com.rishav.crypto.TransactionFactory;

import com.rishav.crypto.CSVParser.CSVCoinParser;
import com.rishav.crypto.CSVParser.CSVTraderParser;
import com.rishav.crypto.models.Coin;
import com.rishav.crypto.models.Trader;
import com.rishav.crypto.models.Transaction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TransactionLogs {
    public static ArrayList<Coin> listOfCoins = null;
    public static ArrayList<Trader> listOfTraders = null;
    public static ArrayList<Transaction> listOfTransactions = null;
    public static ConcurrentHashMap<String, Coin> coinCollectionByType = null;
    public static ConcurrentHashMap<String, Trader> traderWalletAddresses = null;

    public TransactionLogs(){
        listOfCoins = new ArrayList<>();
        listOfTraders = new ArrayList<>();
        listOfTransactions = new ArrayList<>();
        coinCollectionByType = new ConcurrentHashMap<>();
        traderWalletAddresses = new ConcurrentHashMap<>();
    }

    public void initiateLogs(){
        parseCoins();
        parseTraders();
        parseTransactions();
    }

    private void parseTransactions() {
        TransactionParser transactionParser = new TransactionParser("src/main/resources/small_transaction.json");
        transactionParser.parseTransactionFile();
        listOfTransactions = transactionParser.getListOfTransactions();
    }

    private void parseTraders() {
        CSVTraderParser csvTraderParser = new CSVTraderParser("src/main/resources/traders.csv");
        csvTraderParser.parseCSV();
        listOfTraders = csvTraderParser.getListOfTraders();
        traderWalletAddresses = csvTraderParser.getTraderWalletAddresses();
    }

    private void parseCoins() {
        CSVCoinParser csvCoinParser = new CSVCoinParser("src/main/resources/coins.csv");
        csvCoinParser.parseCSV();
        listOfCoins = csvCoinParser.getListOfCoins();
        coinCollectionByType = csvCoinParser.getCoinCollectionByType();
    }


    public void displayLogs() {
        listOfCoins.stream().forEach(System.out::println);
        listOfTraders.stream().forEach(System.out::println);

        System.out.println("CoinCollectionsByType : ");
        for (Map.Entry<String, Coin> entry : coinCollectionByType.entrySet()) {
            String key = entry.getKey().toString();
            Coin coin = entry.getValue();
            System.out.println("key: " + key + " value: " + coin);
        }

        System.out.println("Trader -> Wallet Address : ");
        for (Map.Entry<String, Trader> entry : traderWalletAddresses.entrySet()) {
            String key = entry.getKey().toString();
            Trader trader = entry.getValue();
            System.out.println("key: " + key + " value: " + trader);
        }



    }
}

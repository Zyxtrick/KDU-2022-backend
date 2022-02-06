package com.rishav.crypto.CSVParser;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.rishav.crypto.models.Trader;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class CSVTraderParser {
    private String fileName;
    ArrayList<Trader> listOfTraders = null;
    ConcurrentHashMap<String, Trader> traderWalletAddresses = null;

    public void setListOfTraders(ArrayList<Trader> listOfTraders) {
        this.listOfTraders = listOfTraders;
    }

    public ConcurrentHashMap<String, Trader> getTraderWalletAddresses() {
        return traderWalletAddresses;
    }

    public void setTraderWalletAddresses(ConcurrentHashMap<String, Trader> traderWalletAddresses) {
        this.traderWalletAddresses = traderWalletAddresses;
    }

    public ArrayList<Trader> getListOfTraders() {
        return listOfTraders;
    }

    public void setLisOfCoins(ArrayList<Trader> lisOfTraders) {
        this.listOfTraders = lisOfTraders;
    }

    public CSVTraderParser(String fileName) {
        this.fileName = fileName;
        listOfTraders = new ArrayList<>();
        traderWalletAddresses = new ConcurrentHashMap<>();
    }

    public void parseCSV() {
        try {
            FileReader filereader = new FileReader(fileName);

            CSVReader csvReader = new CSVReaderBuilder(filereader)
                    .withSkipLines(1)
                    .build();
            List<String[]> allData = csvReader.readAll();

            for (String[] row : allData) {
                Trader trader = createTrader(row);
                addTradersToList(trader);
                mapToWalletAddress(row[4], trader);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void mapToWalletAddress(String s, Trader trader) {
        traderWalletAddresses.put(s, trader);
    }

    private void addTradersToList(Trader trader) {
        listOfTraders.add(trader);
    }

    public Trader createTrader(String[] row) {
        Trader trader = new Trader(row[1], row[2], row[3], row[4]);
        return trader;

    }

}


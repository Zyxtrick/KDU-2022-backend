package com.rishav.crypto.CSVParser;


import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.rishav.crypto.models.Coin;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class CSVCoinParser {
    private String fileName;
    ArrayList<Coin> lisOfCoins = null;
    ConcurrentHashMap<String, Coin> coinCollectionByType = null;

    public ArrayList<Coin> getLisOfCoins() {
        return lisOfCoins;
    }

    public ConcurrentHashMap<String, Coin> getCoinCollectionByType() {
        return coinCollectionByType;
    }

    public void setCoinCollectionByType(ConcurrentHashMap<String, Coin> coinCollectionByType) {
        this.coinCollectionByType = coinCollectionByType;
    }

    public ArrayList<Coin> getListOfCoins() {
        return lisOfCoins;
    }

    public void setLisOfCoins(ArrayList<Coin> lisOfCoins) {
        this.lisOfCoins = lisOfCoins;
    }

    public CSVCoinParser(String fileName) {
        this.fileName = fileName;
        lisOfCoins = new ArrayList<Coin>();
        coinCollectionByType = new ConcurrentHashMap<>();
    }

    public void parseCSV() {
        try {
            FileReader filereader = new FileReader(fileName);

            CSVReader csvReader = new CSVReaderBuilder(filereader)
                    .withSkipLines(1)
                    .build();
            List<String[]> allData = csvReader.readAll();

            for (String[] row : allData) {
                Coin coin = getNewCoin(row);
                addCoinsToList(coin);
                addCoinsToCollections(row[3], coin);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void addCoinsToCollections(String s, Coin coin) {
        coinCollectionByType.put(s, coin);
    }

    private void addCoinsToList(Coin coin) {
        lisOfCoins.add(coin);
    }

    private Coin getNewCoin(String[] row) {
        Coin coin  = new Coin(Integer.parseInt(row[1]), row[2],
                                row[3], Double.parseDouble(row[4]), Long.parseLong(row[5]) );
        return coin;
    }

}


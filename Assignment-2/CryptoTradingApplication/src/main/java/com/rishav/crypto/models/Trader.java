package com.rishav.crypto.models;

import java.util.HashMap;
import java.util.Map;

public class Trader {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String walletAddress;
    private HashMap<String, Coin> traderPortfolio = null;
    private Double spent;
    private Double profit;
    private Double releasedRevenue;

    public Double getSpent() {
        return spent;
    }

    public void setSpent(Double spent) {
        this.spent = spent;
    }

    public Double getProfit() {
        double revenue = 0.0;
        if(traderPortfolio.isEmpty()){
            profit = 0.0;
        }else{
            for(Map.Entry<String, Coin> coinSymbol : traderPortfolio.entrySet()) {
                revenue += coinSymbol.getValue().getPrice() * coinSymbol.getValue().getCirculatingSupply();
            }
            profit = revenue - spent;
        }
        return profit;
    }


    public void setProfit(Double profit) {
        this.profit = profit;
    }

    public Double getReleasedRevenue() {
        return releasedRevenue;
    }

    public void setReleasedRevenue(Double releasedRevenue) {
        this.releasedRevenue = releasedRevenue;
    }

    public Trader(String firstName, String lastName, String phoneNumber, String walletAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.walletAddress = walletAddress;
        traderPortfolio = new HashMap<>();
    }

    public HashMap<String, Coin> getTraderPortfolio() {
        return traderPortfolio;
    }

    public void setTraderPortfolio(HashMap<String, Coin> traderPortfolio) {
        this.traderPortfolio = traderPortfolio;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getWalletAddress() {
        return walletAddress;
    }

    public void setWalletAddress(String walletAddress) {
        this.walletAddress = walletAddress;
    }

    @Override
    public String toString() {
        return "Trader{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", walletAddress='" + walletAddress + '\'' +
                '}';
    }

    public void printTraderPortfolio(){
        System.out.println("Portfolio of "+firstName + " " + lastName+ " : ");
        for (Map.Entry mapElement : traderPortfolio.entrySet()) {
            String key = (String)mapElement.getKey();
            Coin coin = (Coin) mapElement.getValue();
            System.out.println(key + " : " + coin);
        }
    }
}

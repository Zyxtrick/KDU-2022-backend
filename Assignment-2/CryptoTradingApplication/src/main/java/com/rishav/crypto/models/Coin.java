package com.rishav.crypto.models;

public class Coin {
    private int rank;
    private String name;
    private String symbol;
    private double price;
    private long circulatingSupply;
    private String coinStatus;
    private boolean isTransactionCompleted;

    public Coin(int rank, String name, String symbol, double price, long circulatingSupply) {
        this.rank = rank;
        this.name = name;
        this.symbol = symbol;
        this.price = price;
        this.circulatingSupply = circulatingSupply;
        this.coinStatus = "AVAILABLE";
        this.isTransactionCompleted = false;

    }

    public String getCoinStatus() {
        return coinStatus;
    }

    public void setCoinStatus(String coinStatus) {
        this.coinStatus = coinStatus;
    }

    public boolean isTransactionCompleted() {
        return isTransactionCompleted;
    }

    public void setTransactionCompleted(boolean transactionCompleted) {
        isTransactionCompleted = transactionCompleted;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getCirculatingSupply() {
        return circulatingSupply;
    }

    public void setCirculatingSupply(long circulatingSupply) {
        this.circulatingSupply = circulatingSupply;
    }

    @Override
    public String toString() {
        return "Coin{" +
                "rank=" + rank +
                ", name='" + name + '\'' +
                ", symbol='" + symbol + '\'' +
                ", price=" + price +
                ", circulatingSupply=" + circulatingSupply +
                ", coinStatus='" + coinStatus + '\'' +
                ", isTransactionCompleted=" + isTransactionCompleted +
                '}';
    }
}

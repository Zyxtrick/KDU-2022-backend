package com.rishav.crypto.models;

import org.json.simple.JSONObject;

public class Transaction {
    String typeOfTransaction;
    JSONObject transactionData;

    public Transaction(String typeOfTransaction, JSONObject transactionData) {
        this.typeOfTransaction = typeOfTransaction;
        this.transactionData = transactionData;
    }

    public String getTypeOfTransaction() {
        return typeOfTransaction;
    }

    public void setTypeOfTransaction(String typeOfTransaction) {
        this.typeOfTransaction = typeOfTransaction;
    }

    public JSONObject getTransactionData() {
        return transactionData;
    }

    public void setTransactionData(JSONObject transactionData) {
        this.transactionData = transactionData;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "typeOfTransaction='" + typeOfTransaction + '\'' +
                ", transactionData=" + transactionData +
                '}';
    }
}

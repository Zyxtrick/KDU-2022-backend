package com.rishav.crypto.Transactions;

import com.rishav.crypto.models.Coin;
import com.rishav.crypto.models.Transaction;
import org.json.simple.JSONObject;

import static com.rishav.crypto.TransactionFactory.TransactionHash.getBlockHash;
import static com.rishav.crypto.TransactionFactory.TransactionLogs.coinCollectionByType;

public class UpdatePrice extends Thread{
    private Double coinPrice;
    private Coin coin;
    private String coinSymbol;
    private String transactionID;
    private String transactionStatus;

    public UpdatePrice(Transaction transaction) {
        JSONObject transactionData = transaction.getTransactionData();
        coinSymbol = (String) transactionData.get("coin");
        coin = coinCollectionByType.get(coinSymbol);
        coinPrice = (Double) transactionData.get("price");
        transactionStatus = "TRANSACTION_INITIATED";
    }

    public void run() {
        try {

            synchronized (coin) {

                while (coin.getCoinStatus().equals("NOT_AVAILABLE")) {
                    try {
                        coin.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                coin.setCoinStatus("NOT_AVAILABLE");
                transactionID = getBlockHash();

                coin.setPrice(coin.getPrice() + coinPrice);

                coin.notifyAll();
                coin.setCoinStatus("AVAILABLE");
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}

package com.rishav.crypto.Transactions;

import com.rishav.crypto.models.Coin;
import com.rishav.crypto.models.Transaction;
import org.json.simple.JSONObject;

import static com.rishav.crypto.TransactionFactory.TransactionHash.getBlockHash;
import static com.rishav.crypto.TransactionFactory.TransactionLogs.coinCollectionByType;

public class AddVolume extends Thread{
    private Long coinVolume;
    private Coin coin;
    private String coinSymbol;
    private String transactionID;
    private String transactionStatus;

    public AddVolume(Transaction transaction) {
        JSONObject transactionData = transaction.getTransactionData();
        coinSymbol = (String) transactionData.get("coin");
        coin = coinCollectionByType.get(coinSymbol);
        coinVolume = (Long) transactionData.get("volume");
        transactionStatus = "TRANSACTION_INITIATED";
    }

    @Override
    public void run() {
        try{
//            System.out.println("Add Volume :" + coin);
            synchronized (coin) {
                while (coin.getCoinStatus().equals("NOT_AVAILABLE")) {
                    try {
                        coin.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                coin.setCoinStatus("NOT_AVAILABLE");
                this.transactionID = getBlockHash();

                coin.setPrice((double) (coin.getCirculatingSupply() + coinVolume));
                coin.notifyAll();
                coin.setCoinStatus("AVAILABLE");
                transactionStatus = "COMPLETED";
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}

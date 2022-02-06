package com.rishav.crypto.Transactions;

import com.rishav.crypto.models.Coin;
import com.rishav.crypto.models.Trader;
import com.rishav.crypto.models.Transaction;
import org.json.simple.JSONObject;

import static com.rishav.crypto.TransactionFactory.TransactionHash.getBlockHash;
import static com.rishav.crypto.TransactionFactory.TransactionLogs.coinCollectionByType;
import static com.rishav.crypto.TransactionFactory.TransactionLogs.traderWalletAddresses;

public class Buy extends Thread{
    private Transaction transaction;
    private Coin coin;
    private String coinName;
    private Long coinQuantity;
    private String traderWalletAddress;
    private String transactionID;

    public Buy(Transaction transaction) {
        this.transaction = transaction;
        JSONObject transactionData = transaction.getTransactionData();
        coinName = (String) transactionData.get("coin");
        coin = coinCollectionByType.get(coinName);
        coinQuantity = (Long) transactionData.get("quantity");
        traderWalletAddress = (String) transactionData.get("wallet_address");
    }

    @Override
    public void run() {
        try {
//            System.out.println("Buy : " + coin);
            synchronized (coin) {
                while ((coin.getCoinStatus().equals("NOT_AVAILABLE")) || (coin.getCirculatingSupply() < coinQuantity)) {
                    try {
                        coin.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                coin.setCoinStatus("NOT_AVAILABLE");
                transactionID = getBlockHash();

                Trader trader = traderWalletAddresses.get(traderWalletAddress);
                if (trader.getTraderPortfolio().containsKey(coinName)) {
                    Coin coin = trader.getTraderPortfolio().get(coinName);
                    long vol = coin.getCirculatingSupply() + coinQuantity;
                    coin.setCirculatingSupply(vol);

                    Double totalSpendings = trader.getSpent() + coinQuantity * coin.getPrice();
                    trader.setSpent(totalSpendings);
                } else {
                    trader.getTraderPortfolio().put(coinName, coin);
                    Double totalSpendings = coinQuantity * coin.getPrice();
                    trader.setSpent(totalSpendings);
                }

                coin.setCirculatingSupply(coin.getCirculatingSupply() - coinQuantity);
                coin.notifyAll();
                coin.setCoinStatus("AVAILABLE");
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}

package com.rishav.crypto.Transactions;

import com.rishav.crypto.models.Coin;
import com.rishav.crypto.models.Trader;
import com.rishav.crypto.models.Transaction;
import org.json.simple.JSONObject;

import static com.rishav.crypto.TransactionFactory.TransactionHash.getBlockHash;
import static com.rishav.crypto.TransactionFactory.TransactionLogs.coinCollectionByType;
import static com.rishav.crypto.TransactionFactory.TransactionLogs.traderWalletAddresses;

public class Sell extends Thread {
    private Coin coin;
    private String transactionID;
    private String coinSymbol;
    private String walletAddress;
    private Long coinQuantity;
    private String transactionStatus;

    public Sell(Transaction transaction) {
        JSONObject transactionData = transaction.getTransactionData();
        coinSymbol = (String) transactionData.get("coin");
        coin = coinCollectionByType.get(coinSymbol);
        coinQuantity = (Long) transactionData.get("quantity");
        walletAddress = (String) transactionData.get("wallet_address");
        transactionStatus = "TRANSACTION_ALLOWED";
    }

    @Override
    public void run() {
        Trader trader = traderWalletAddresses.get(walletAddress);
        if((!trader.getTraderPortfolio().containsKey(coinSymbol) ||
                ((trader.getTraderPortfolio().get(coinSymbol).getCirculatingSupply()) < coinQuantity))) {
            transactionStatus = "TRANSACTION_NOT_ALLOWED";
            return;
        }
        try{
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

                Double releasedRevenue = coin.getPrice() * coinQuantity + trader.getReleasedRevenue();
                trader.setReleasedRevenue(releasedRevenue);

                Long changeQuantity = trader.getTraderPortfolio().get(coinSymbol).getCirculatingSupply();
                trader.getTraderPortfolio().get(coinSymbol).setCirculatingSupply(changeQuantity - coinQuantity);

                coin.setCirculatingSupply(coin.getCirculatingSupply() + coinQuantity);
                coin.notifyAll();
                coin.setCoinStatus("AVAILABLE");
                transactionStatus = "TRANSACTION_COMPLETED";
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}


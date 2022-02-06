package com.rishav.crypto.TransactionFactory;

import com.rishav.crypto.Transactions.AddVolume;
import com.rishav.crypto.Transactions.Buy;
import com.rishav.crypto.Transactions.Sell;
import com.rishav.crypto.Transactions.UpdatePrice;

import static com.rishav.crypto.TransactionFactory.TransactionLogs.listOfTransactions;

public class TransactionInitiator {

    public void startTransactions(){
        try {
            listOfTransactions.stream().limit(3000).forEach(transaction -> {
//            System.out.println(transaction);
                if(transaction.getTypeOfTransaction().equals("BUY")){
                    Thread buy = new Buy(transaction);
                    buy.start();
                }
                else if(transaction.getTypeOfTransaction().equals("SELL")){
                    Thread sell = new Sell(transaction);
                    sell.start();
                }
                else if(transaction.getTypeOfTransaction().equals("ADD_VOLUME")){
                    Thread addVolume = new AddVolume(transaction);
                    addVolume.start();
                }
                else if(transaction.getTypeOfTransaction().equals("UPDATE_PRICE")){
                    Thread updatePrice = new UpdatePrice(transaction);
                    updatePrice.start();
                }
                else{
                    System.out.println("NO SUITABLE TRANSACTION FOUND");
                }
            });
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}

package com.rishav.crypto;

import com.rishav.crypto.Menu.Menu;
import com.rishav.crypto.TransactionFactory.TransactionInitiator;
import com.rishav.crypto.TransactionFactory.TransactionLogs;
import com.rishav.crypto.TransactionFactory.TransactionParser;

public class CryptoTradingApplication {

	public static void main(String[] args) {

		TransactionLogs transactionLogs = new TransactionLogs();
		transactionLogs.initiateLogs();
//		transactionLogs.displayLogs();

		Menu menu = new Menu();
		menu.start();

		TransactionInitiator transactionInitiator = new TransactionInitiator();
		transactionInitiator.startTransactions();
	}

}

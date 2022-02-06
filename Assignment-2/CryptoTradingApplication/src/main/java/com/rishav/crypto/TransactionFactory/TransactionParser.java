package com.rishav.crypto.TransactionFactory;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.rishav.crypto.models.Transaction;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class TransactionParser {
    private String fileName;
    private ArrayList<Transaction> listOfTransactions = null;

    public TransactionParser(String fileName) {
        this.fileName = fileName;
        listOfTransactions = new ArrayList<>();
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public ArrayList<Transaction> getListOfTransactions() {
        return listOfTransactions;
    }

    public void setListOfTransactions(ArrayList<Transaction> listOfTransactions) {
        this.listOfTransactions = listOfTransactions;
    }

    @SuppressWarnings("unchecked")
    public void parseTransactionFile()
    {

        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader(fileName))
        {
            Object obj = jsonParser.parse(reader);
            JSONArray transactionsList = (JSONArray) obj;
            System.out.println(transactionsList);

            //Iterate over employee array
            transactionsList.forEach( emp -> loadTransaction( (JSONObject) emp ) );

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void loadTransaction(JSONObject transactionObject)
    {
        String type = (String) transactionObject.get("type");
        JSONObject transactionData = (JSONObject) transactionObject.get("data");

        Transaction transaction = new Transaction(type, transactionData);
        listOfTransactions.add(transaction);
    }

}
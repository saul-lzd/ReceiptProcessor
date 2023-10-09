package com.fetch.receiptProcessor.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.fetch.receiptProcessor.entities.Receipt;

/**
 * @author saul-lzd
 */
public class ReceiptDAO {

    // Memory to save elements
    private static final Map<String, Receipt> myDB = new HashMap<>();

    public static Receipt save(Receipt receipt) {
        String id = generateId();
        receipt.setId(id);
        myDB.put(id, receipt);

        return receipt;
    }

    public static Receipt selectById(String Id) {
        if (myDB.containsKey(Id)) {
            return myDB.get(Id);
        }

        return null;
    }

    public static List<Receipt> selectAll() {
        return new ArrayList<>(myDB.values());
    }

    /**
     * 
     * Every time this method is called, returns a different ID
     * in the format "7fb1377b-b223-49d9-a31a-5a02701dd310".
     * 
     * @return
     */
    private static String generateId() {
        return UUID.randomUUID().toString();
    }

}

package com.fetch.receiptProcessor.logic;

import java.util.List;
import com.fetch.receiptProcessor.entities.Item;

/**
 * @author saul-lzd
 */
public interface AwardedPointsInterface {

    /**
     * One point for every alphanumeric character in the retailer name.
     * 
     * @param retailerName
     * @return awarded points
     */
    public int retailerName(String retailerName);

    /**
     * 50 points if the total is a round dollar amount with no cents.
     * 
     * @param total
     * @return awarded points
     */
    public int roundAmount(String total);

    /**
     * 25 points if the total is a multiple of 0.25
     * 
     * @param total
     * @return awarded points
     */
    public int multiple25(String total);

    /**
     * 5 points for every two items on the receipt
     * 
     * @param items
     * @return awarded points
     */
    public int twoItems(List<Item> items);

    /**
     * If the trimmed length of the item description is a multiple of 3,
     * multiply the price by 0.2 and round up to the nearest integer.
     * 
     * @param items
     * @return awarded points
     */
    public int trimItemDescription(List<Item> items);

    /**
     * 6 points if the day in the purchase date is odd.
     * 
     * @param purchaseDate
     * @return awarded points
     */
    public int oddDay(String purchaseDate);

    /**
     * 10 points if the time of purchase is after 2:00pm and before 4:00pm.
     * 
     * @param purchaseTime
     * @return awarded points
     */
    public int time(String purchaseTime);
}
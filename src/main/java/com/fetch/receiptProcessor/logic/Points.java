package com.fetch.receiptProcessor.logic;

import com.fetch.receiptProcessor.entities.Receipt;

/**
 * @author saul-lzd
 */
public class Points {

    public static int calculateRewards(Receipt receipt) {
        int points = 0;
 
        AwardedPoints awardedPoints = new AwardedPoints();

        points += awardedPoints.retailerName(receipt.getRetailer());

        points += awardedPoints.roundAmount(receipt.getTotal());

        points += awardedPoints.multiple25(receipt.getTotal());

        points += awardedPoints.twoItems(receipt.getItems());

        points += awardedPoints.trimItemDescription(receipt.getItems());

        points += awardedPoints.oddDay(receipt.getPurchaseDate());

        points += awardedPoints.time(receipt.getPurchaseTime());

        System.out.println("Total points awarded: " + points);

        return points;

    }

}

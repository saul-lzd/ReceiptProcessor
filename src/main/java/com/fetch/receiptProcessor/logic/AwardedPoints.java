package com.fetch.receiptProcessor.logic;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.fetch.receiptProcessor.entities.Item;

/**
 * This class includes all the business logic f
 * @author saul-lzd
 */
class AwardedPoints implements AwardedPointsInterface {

    int points = 0;

    @Override
    public int multiple25(String total) {
        System.out.print("Calculating points for total multiple of 0.25 ... ");

        points = 0;
        float t = parseNumber(total);
        if (t % .25 == 0) {
            points = 25;
        }
        System.out.println(points + " points awarded");
        return points;
    }

    @Override
    public int oddDay(String purchaseDate) {
        System.out.print("Calculating points for oddDay ... ");

        points = 0;
        LocalDate pDate = LocalDate.parse(purchaseDate);
        int day = pDate.getDayOfMonth();

        if (day % 2 == 1) {
            points = 6;
        }
        System.out.println(points + " points awarded");
        return points;
    }

    @Override
    public int retailerName(String retailer) {
        System.out.print("Calculating points for retailer name ... ");
        points = 0;

        // remove non-alphanumerics characters
        retailer = retailer.replaceAll("[^a-zA-Z0-9]", "");

        // NOTE:
        // If retailer name includes white spaces " ",
        // they are removed and not count towards awarded points.

        // remove white spaces
        retailer = retailer.trim();

        points = retailer.length();
        System.out.println(points + " points awarded");

        return points;
    }

    @Override
    public int roundAmount(String total) {
        System.out.print("Calculating points for total is a round amount ... ");

        points = 0;
        float t = parseNumber(total);

        if (t % 1 == 0) {
            points = 50;
        }
        System.out.println(points + " points awarded");
        return points;
    }

    @Override
    public int time(String purchaseTime) {
        System.out.print("Calculating points for purchase Time ... ");

        points = 0;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime time = LocalTime.parse(purchaseTime, formatter);
        if (time.getHour() >= 14 && time.getHour() <= 16) {
            points = 10;
        }

        System.out.println(points + " points awarded");
        return points;
    }

    @Override
    public int trimItemDescription(List<Item> items) {
        System.out.print("Calculating points for items, trimmed description ... ");
        int points = 0;
        for (Item item : items) {
            int lenghtDescription = item.getShortDescription().trim().length();

            if (lenghtDescription % 3 == 0) {
                float price = parseNumber(item.getPrice());
                points += (int) Math.ceil(price * 0.2);
            }
        }

        System.out.println(points + " points awarded");
        return points;
    }

    @Override
    public int twoItems(List<Item> items) {
        System.out.print("Calculating points for every tow items in the receipt ... ");

        points = 0;
        points = (items.size() / 2) * 5;
        System.out.println(points + " points awarded");
        return points;
    }

    /**
     * Private method to convert number from string to float
     * 
     * @param number
     * @return float number;
     */
    private float parseNumber(String number) {
        return Float.parseFloat(number);
    }

}

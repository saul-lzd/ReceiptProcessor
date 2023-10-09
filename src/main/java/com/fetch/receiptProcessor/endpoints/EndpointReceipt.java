package com.fetch.receiptProcessor.endpoints;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fetch.receiptProcessor.dao.ReceiptDAO;
import com.fetch.receiptProcessor.entities.Receipt;
import com.fetch.receiptProcessor.logic.Points;

/*
 * This is the endpoint that manages all request to "/receipt"
 * 
 * -/receipts/process : create a new resource
 * -/receipts/{id}/points : compute the points awarded for the given receipt id
 * -/receipts : return a list of all receipts created in the service
 */

 /**
 * @author saul-lzd
 */
@RestController
@RequestMapping("/receipts")
public class EndpointReceipt {

    /*
     * Create a new "Receipt" resource in the server
     */
    @PostMapping(value = "/process", produces = MediaType.APPLICATION_JSON_VALUE)
    public String processReceipt(@RequestBody Receipt receipt) {
        Receipt newReceipt = ReceiptDAO.save(receipt);
        if (newReceipt.getId() == null) {
            return "Receipt not found";
        }
        return "{id : " + newReceipt.getId() + "}";
    }

    /*
     * Returns the points awarded for the given {id}
     */
    @GetMapping("/{id}/points")
    public String getPointsAwarded(@PathVariable String id) {
        System.out.println("Get points for " + id);
        Receipt receipt = ReceiptDAO.selectById(id);
        if (receipt == null) {
            return "Receipt not found";
        } else {
            int awardedPoints = Points.calculateRewards(receipt);
            return "{points : " + awardedPoints + "}";
        }
    }

    /*
     * Return a list of all receipts created
     */
    @GetMapping
    @ResponseBody
    public List<Receipt> getReceipts() {
        return ReceiptDAO.selectAll();
    }

}

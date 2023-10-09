package com.fetch.receiptProcessor.endpoints;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author saul-lzd
 */
@RestController
@RequestMapping("/")
public class EndpointDefault {

	// This endpoint only shows a message to notify application is running
	@RequestMapping(method = RequestMethod.GET)
	public String welcomeMessage() {
		return "<h1>Receipt Processor Application running... </h1>";
	}

}

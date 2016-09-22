package com.redhat.training;

import org.apache.camel.Body;
import org.apache.camel.Exchange;
import org.apache.camel.Header;

public class TaxCalculator {

	public String processTax(String data) throws Exception{
		String[] columns = data.split(",");
		double value = Double.parseDouble(columns[3]);
		double result = (value*7.5)/100;
		return String.valueOf(result);
	}
	
	public String processTotalValue(@Body String data,
			@Header("CamelFilenameOnly") String filename, Exchange exchange)
			throws Exception {
		System.out.printf("Body content: %s %n Filename: %s %n", data, filename);
		String[] columns = data.split(",");
		double value = Double.parseDouble(columns[3]);
		double result = ((value * 7.5) / 100) + value;

		return String.valueOf(result);
	}
}

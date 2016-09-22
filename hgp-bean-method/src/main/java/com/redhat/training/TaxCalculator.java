package com.redhat.training;

public class TaxCalculator {

	public String processTax(String data) throws Exception{
		String[] columns = data.split(",");
		double value = Double.parseDouble(columns[3]);
		double result = (value*7.5)/100;
		return String.valueOf(result);
	}
	
}

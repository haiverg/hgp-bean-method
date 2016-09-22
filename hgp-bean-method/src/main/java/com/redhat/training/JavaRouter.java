package com.redhat.training;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.impl.SimpleRegistry;

public class JavaRouter {

	public static void main(String[] args) throws Exception {
		SimpleRegistry registry = new SimpleRegistry();
		registry.put("taxCalculator", new TaxCalculator());
		CamelContext context = new DefaultCamelContext(registry);
		context.addRoutes(new JavaRouteBuilder());
		context.start();
		Thread.sleep(5000);
		context.stop();
	}

}

package com.gaby.tutorial.javaee.ejb;

import java.math.BigDecimal;

import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ConverterClient {

	public ConverterClient(String[] args) {
	}

	public static void main(String[] args) throws NamingException {

		String classpath = System.getProperty("java.class.path");
		System.out.println("Classpath: " + classpath);
		InitialContext ic = new InitialContext();

		Converter service = (Converter) ic.lookup("converter");

		try {
			BigDecimal param = new BigDecimal("100.00");
			BigDecimal yenAmount = service.dollarToYen(param);

			System.out.println("$" + param + " is " + yenAmount + " Yen.");
			BigDecimal euroAmount = service.yenToEuro(yenAmount);
			System.out.println(yenAmount + " Yen is " + euroAmount + " Euro.");

			System.exit(0);
		} catch (Exception ex) {
			System.err.println("Caught an unexpected exception!");
			ex.printStackTrace();
		}
	}
}

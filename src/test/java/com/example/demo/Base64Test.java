package com.example.demo;

import java.util.Base64;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Base64Test {

	private static final Logger log = LoggerFactory.getLogger(Base64Test.class);

	String originalInput = "clientid:client_secret";
	String encodedString = Base64.getEncoder().encodeToString(originalInput.getBytes());
	byte[] decoded = Base64.getDecoder().decode(encodedString);
	String decodedString = new String(decoded);

	@Test
	public void encording() throws Exception {
		log.debug(encodedString);
		log.debug(decodedString);
	}
}

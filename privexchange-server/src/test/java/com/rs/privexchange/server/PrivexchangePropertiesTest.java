/*
 * Copyright (C) 2024
 *
 * @author Rojar Smith
 */
package com.rs.privexchange.server;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.rs.privexchange.server.properties.PrivexchangeProperties;

import jakarta.xml.bind.DatatypeConverter;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
public class PrivexchangePropertiesTest {
	@Autowired
	private PrivexchangeProperties privexchangeProperties;

	@Test
	public void testValues() throws NoSuchAlgorithmException {
		String name = privexchangeProperties.getUser().getName();
		assertEquals("tester", name);

		String apiKey = privexchangeProperties.getApiKey();
		System.out.println(apiKey);
		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		byte[] encodedhash = digest.digest(apiKey.getBytes(StandardCharsets.UTF_8));
		String hashMessage = DatatypeConverter.printHexBinary(encodedhash).toLowerCase();
		assertEquals("9bba5c53a0545e0c", hashMessage.substring(0, 16));
	}
}

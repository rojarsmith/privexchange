/*
 * Copyright (C) 2024
 *
 * @author Rojar Smith
 */
package com.rs.privexchange.server.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@ConfigurationProperties(prefix = "privexchange.server")
@Data
public class PrivexchangeProperties {
	private final User user = new User();

	private String apiKey;

	@Data
	public static class User {
		private String name;
	}
}

package org.springframework.social.fitbit.util;

/**
 * @author Kushalkant
 * 
 */

public enum Granularity {
	ONE_MINUTE("1min"),
	FIFTEEN_MINUTES("15min");
	
	private String level;

	private Granularity(String level) {
		this.level = level;
	}
	
	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}
}

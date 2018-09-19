package com.sentinel.utils;

//Generates a random @yopmail.com email and returns it in String format

public class RandomEmailGenerator {
	public static String generateRandomEmail() {
		String email;
		email = "j2_" + (System.currentTimeMillis() % 1000000000) + "@yopmail.com";
		System.out.println(email);
		return email;
	}
}

package com.sentinel.utils;

public class Test {

	public static void main(String[] args) {
		String[] input = { "abc", "9", "b", "1", "w", "543" };
		for (int i = 0; i < input.length; i++) {
			System.out.println(input[i]);
			isInteger(input[i]);
		}

	}

	public static boolean isInteger(String input) {
		boolean inputType = false;

		try {
			Integer.parseInt(input);
			inputType = true;
			System.out.println("Integer");
		} catch (Exception e) {
			System.out.println("Not Integer");
		}
		return inputType;
	}

}

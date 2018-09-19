package com.sentinel.utils;

import org.testng.asserts.SoftAssert;



public class SoftAssertUtil {
private static MySoftAssert softassert;
	
	public SoftAssertUtil() {
		softassert = new MySoftAssert();
	}
	
	public static SoftAssert myAssert() {
		if(softassert == null) {
			softassert = new MySoftAssert();
			return softassert;
		}
		else
			return softassert;
	}
	
	public static SoftAssert getAssert() {
		/*if(softassert != null) {
			return softassert;
		}
		else {
			return null;
		}*/
		return softassert;
	}
}

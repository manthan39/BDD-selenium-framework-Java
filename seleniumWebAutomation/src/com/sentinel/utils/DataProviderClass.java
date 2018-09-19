package com.sentinel.utils;

import org.testng.annotations.DataProvider;

public class DataProviderClass {
	static GenericFunctions genericFunctions = new GenericFunctions();

	@DataProvider(name = "Authentication")
	public static Object[][] loginCredientials() {
		return new Object[][] { { genericFunctions.generaterandomString(5), "dsas" }, { "nis123", "Admin1112233" },
				{ genericFunctions.generaterandomString(7), "Admin@123" },
				{ genericFunctions.generaterandomString(6), "Admin@4321" }, { "nis123", "Admin1112233" } };
	}

	@DataProvider(name = "RadioButton Labels")
	public static Object[][] radioButtonLabels() {
		return new Object[][] { { "Resend Username"}, {"Reset Password" } };
	}

}

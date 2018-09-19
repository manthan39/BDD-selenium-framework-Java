package com.sentinel.utils;

import java.io.IOException;
import java.util.ArrayList;

import com.sentinel.driver.WebDriverTestBase;

public class ExcelUtility extends WebDriverTestBase {
	/*
	 * //static String fileNameAndExtension =
	 * config.getProperty("signInFileNameAndExtension"); static String
	 * fileNameAndExtension ="SignInExcelSheet.xls";
	 */
	static String excelPath = System.getProperty("user.dir") + "\\projectDataFiles\\ExcelData\\";

	public ArrayList<String> readData(String sheetName, String fileNameAndExtension) throws IOException {
		ReadExcel readExcel = new ReadExcel();
		ArrayList<String> excelValues = new ArrayList<String>();
		// excelValues = readExcel.readExcel(excelPath, "SignInExcelSheet.xlsx",
		// sheetName);
		excelValues = readExcel.readExcel(excelPath, fileNameAndExtension, sheetName);

		return excelValues;
	}

	public static void main(String[] args) throws IOException {
		ExcelUtility data = new ExcelUtility();

		String sheetName = "blankErrorMessages";
	
		String fileNameAndExtension = "addressPageExcelSheet.xls";

		System.out.println(data.readData(sheetName, fileNameAndExtension).size());
		for (int i = 0; i < data.readData("normalTextBoxLabelsAndPlaceholders", fileNameAndExtension).size(); i++) {
			System.out.println(data.readData("normalTextBoxLabelsAndPlaceholders", fileNameAndExtension).get(i));
		}

		// normalTextBoxLabelsAndPlaceholders
	}

}

package com.sentinel.utils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

public class StringUtility {

	static Logger log = Logger.getLogger(StringUtility.class.getName());
	
	public static enum Mode {
	    ALPHA, ALPHANUMERIC, NUMERIC 
	}

	/**
	 * This String util method removes single or double quotes from a string if
	 * its quoted. for input string = "mystr1" output will be = mystr1 for input
	 * string = 'mystr2' output will be = mystr2
	 * 
	 * @param String
	 *            value to be unquoted.
	 * @return value unquoted, null if input is null.
	 * 
	 */
	public static String unquote(String s) {

		if (s != null
				&& ((s.startsWith("\"") && s.endsWith("\"")) || (s
						.startsWith("'") && s.endsWith("'")))) {

			s = s.substring(1, s.length() - 1);
		}
		return s;
	}

	/**
	 * Check a String ends with another string ignoring the case.
	 * 
	 * @param str
	 * @param suffix
	 * @return
	 */

	public static boolean endsWithIgnoreCase(String str, String suffix) {

		if (str == null || suffix == null) {
			return false;
		}
		if (str.endsWith(suffix)) {
			return true;
		}
		if (str.length() < suffix.length()) {
			return false;
		} else {
			return str.toLowerCase().endsWith(suffix.toLowerCase());
		}
	}

	/**
	 * Check a String starts with another string ignoring the case.
	 * 
	 * @param str
	 * @param prefix
	 * @return
	 */

	public static boolean startsWithIgnoreCase(String str, String prefix) {

		if (str == null || prefix == null) {
			return false;
		}
		if (str.startsWith(prefix)) {
			return true;
		}
		if (str.length() < prefix.length()) {
			return false;
		} else {
			return str.toLowerCase().startsWith(prefix.toLowerCase());
		}
	}

	/**
	 * Extracts Numbers from String.
	 * 
	 * @param inputString
	 * @return string containing Numbers only
	 */

	public static String extractsDigits(String input) {
		final StringBuilder sb = new StringBuilder(input.length());
		for (int i = 0; i < input.length(); i++) {
			final char c = input.charAt(i);
			if (c > 47 && c < 58) {
				sb.append(c);
			}
		}
		return sb.toString();
	}

	/**
	 * Checks whether the argument <tt>string</tt> is <code>null</code> or
	 * empty. Please note that the <tt>string</tt> is <strong>trimmed</strong>,
	 * so that a check on a string containing white spaces only will always
	 * return <code>true</code>.
	 * 
	 * @param string
	 *            the string to be checked
	 * @return <code>true</code> in case the argument <tt>string</tt> is
	 *         <code>null</code>, empty ({@link String#length()} returns 0) or
	 *         contains only white spaces (
	 *         <tt>{@link String#trim()}.length()</tt> returns 0)
	 */
	public static boolean isNullOrEmpty(String string) {
		return string == null || string.trim().length() == 0;
	}

	/**
	 * This String util method generates a random string exactly of the same
	 * size passed.
	 * 
	 * @param integer
	 *            the length of the string to be generated in number.
	 * 
	 * @return Gives back randomly generated alphabetical string.
	 * 
	 */

	public static String GenerateRandomString(int length,Mode mode) {
		if (length > 0){
			StringBuffer buffer = new StringBuffer();
		String characters = "";

		switch(mode){
		
		case ALPHA:
			characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
			break;
		
		case ALPHANUMERIC:
			characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
			break;
	
		case NUMERIC:
			characters = "1234567890";
		    break;
		}
		
		int charactersLength = characters.length();

		for (int i = 0; i < length; i++) {
			double index = Math.random() * charactersLength;
			buffer.append(characters.charAt((int) index));
		}
			return buffer.toString();
		}
		else
			return null;
	}

	public static boolean isDigit(String data) {
		String regex = "[0-9]+";
		return data.matches(regex);
	}

	public static boolean isAlphaNumeric(String data) {
		String regex = "[A-Za-z0-9]+";
		return data.matches(regex);
	}

	String regex = "[0-9]+";

	public static String capitalizeFirstLetter(String data) {
		String firstLetter = data.substring(0, 1).toUpperCase();
		String restLetters = data.substring(1);
		return firstLetter + restLetters;
	}

	@SuppressWarnings("unchecked")
	public static String[] split(String line, String delim) {
		@SuppressWarnings("rawtypes")
		List list = new ArrayList();
		StringTokenizer t = new StringTokenizer(line, delim);
		while (t.hasMoreTokens()) {
			list.add(t.nextToken());
		}
		return (String[]) list.toArray(new String[list.size()]);
	}

	public static String fileContentsToString(String file) {
		String contents = "";

		File f = new File(file);
		if (f.exists()) {
			try {
				@SuppressWarnings("resource")
				FileReader fr = new FileReader(f);
				char[] template = new char[(int) f.length()];
				fr.read(template);
				contents = new String(template);
			} catch (Exception e) {
				log.error(e.getMessage());
				e.printStackTrace();
			}
		}
		return contents;
	}

	public static String collapseNewlines(String argStr) {
		char last = argStr.charAt(0);
		StringBuffer argBuf = new StringBuffer();
		for (int cIdx = 0; cIdx < argStr.length(); cIdx++) {
			char ch = argStr.charAt(cIdx);
			if ((ch != '\n') || (last != '\n')) {
				argBuf.append(ch);
				last = ch;
			}
		}
		return argBuf.toString();
	}

	public static String collapseSpaces(String argStr) {
		char last = argStr.charAt(0);
		StringBuffer argBuf = new StringBuffer();
		for (int cIdx = 0; cIdx < argStr.length(); cIdx++) {
			char ch = argStr.charAt(cIdx);
			if ((ch != ' ') || (last != ' ')) {
				argBuf.append(ch);
				last = ch;
			}
		}
		return argBuf.toString();
	}

	public static String stackTrace(Throwable e) {
		String foo = null;
		try {
			ByteArrayOutputStream ostr = new ByteArrayOutputStream();
			e.printStackTrace(new PrintWriter(ostr, true));
			foo = ostr.toString();
		} catch (Exception f) {
		}
		return foo;
	}

	public static boolean allEmpty(@SuppressWarnings("rawtypes") List list) {
		int size = list.size();
		for (int i = 0; i < size; i++) {
			if ((list.get(i) != null) && (list.get(i).toString().length() > 0)) {
				return false;
			}
		}
		return true;
	}

	public static String getMethodSignture(Method m) {
		StringBuilder signBuilder = new StringBuilder();
		signBuilder.append(m.getName());
		signBuilder.append("(");
		Iterator<Class<?>> iterator = Arrays.asList(m.getParameterTypes())
				.iterator();
		while (iterator.hasNext()) {
			@SuppressWarnings("rawtypes")
			Class<?> parameterType = (Class) iterator.next();
			signBuilder.append(parameterType.getCanonicalName());
			if (iterator.hasNext()) {
				signBuilder.append(", ");
			}
		}
		signBuilder.append(")");
		return signBuilder.toString();
	}

	public static String generateCurrentDateAndTime() {
		SimpleDateFormat sdfDate = new SimpleDateFormat("dd_MMM_yyyy_hh_mm_aa");// dd/MM/yyyy
		Date now = new Date();
		String strDate = sdfDate.format(now);
		return strDate;
	}

	public static List<String> getAllSubstrings(String data, String regex) {
		List<String> answer = new ArrayList<String>();
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(data);
		try {
			while (matcher.find()) {
				answer.add(matcher.group(0));
			}
		} catch (Exception e) {

		}
		return answer;
	}

	public static void main(String[] args) {
		List<String> data = getAllSubstrings("D2LN6S AVANISH K2LN6S\n",
				"[A-Za-z0-9]+[0-9]+[A-Za-z0-9]+");
		System.out.println("Data is : " + data.size());
		for (String string : data) {
			System.out.println(string);
		}
	}
}

package com.sentinel.utils;

import java.text.SimpleDateFormat;
import java.util.Date; 

//Returns the current time in "MMM dd,yyyy HH:mm:ss" format
public class TimeStampTool {
	
	public static String getCurrentTime(){
        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd,yyyy HH:mm:ss");
        return sdf.format(new Date().getTime()); 
	}
}


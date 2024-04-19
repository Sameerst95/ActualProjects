package com.genericUtility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtility 
{
	public int getRandomNo(int limit) 
	{
		Random r = new Random();
		return r.nextInt(limit);
	}
	public String getSystemDate() 
	{
		Date d = new Date();
		return d.toString();
	}
	public String getSystemDateInFormate() 
	{
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
		Date dt = new Date();
		String sysDateInFormat = format.format(dt);
		return sysDateInFormat;
	}
	public String getNumberFromPopup(String str) {
		String num = "";
		for (int i = 0; i < str.length(); i++) {
			if (Character.isDigit(str.charAt(i))) {
				num += str.charAt(i);
			}
		}

		return num;
	}

}

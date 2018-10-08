package me.etc.util;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;

public class TimeTest extends wonTest {

	public static void main(String[] args) {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
		DateTimeFormatter dateTimeFormatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		String nowString = now.format(dateTimeFormatter);   // ��� : 2018�� 5�� 28�� ���� 11�� 0��

		//System.out.println(now);
		//System.out.println(nowString);
		
		//String sTemp = "2016-09-15 01:00:04.002 2.0s";
		String sTemp = "2016-09-15 01:00:04.005 2.010s";
		//String sTemp = "2016-09-15 01:00:07.000 2s";
		//String sTemp = "2016-09-15 23:59:59.999 0.001s";
		
		String sTemp1 = sTemp.substring(0, 23);
		String sTemp2 = sTemp.substring(24, sTemp.length()-1);
		
		//System.out.println(sTemp1);
		//System.out.println(sTemp2);
		
		LocalDateTime dTempE = LocalDateTime.parse(sTemp.substring(0, 23), dateTimeFormatter);
		
		//dTemp.minusNanos(nanos)
		LocalDateTime dTempS;
		if(sTemp2.indexOf(".") == -1) {
			dTempS = dTempE.minusSeconds(Integer.parseInt(sTemp2));
		}else {
			dTempS = dTempE.minusSeconds(Integer.parseInt(sTemp2.split("\\.")[0]));
			
		}
		dTempS = dTempS.plusNanos(1000000);
		//LocalDateTime dTest = LocalDateTime.parse("2016-09-15 23:59:59.999", dateTimeFormatter);
		LocalDateTime dTest = LocalDateTime.parse("2016-09-15 01:00:04.002", dateTimeFormatter);
		
		DecimalFormat format = new DecimalFormat("00.000");
		
		String str = format.format(Double.parseDouble(sTemp2));
		LocalDateTime dTemp = LocalDateTime.parse(dTempE.format(dateTimeFormatter2) + ":" + str, dateTimeFormatter);
		System.out.println(dTemp);
		
		System.out.println(dTempS);
		System.out.println(dTempE);
		System.out.println(dTest.format(dateTimeFormatter));
		System.out.println(ChronoUnit.NANOS.between(dTempS, dTest));
		System.out.println(ChronoUnit.NANOS.between(dTempE, dTest));
		
		/*if(ChronoUnit.NANOS.between(dTempS, dTest) >= 0 && ChronoUnit.NANOS.between(dTempE, dTest) <= 0) {
			System.out.println("TRUE");
		}else {
			System.out.println("FALSE");
		}*/
	}

}

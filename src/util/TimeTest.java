package util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeTest extends wonTest {

	public static void main(String[] args) {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-M-d H:m:s");
		String nowString = now.format(dateTimeFormatter);   // ��� : 2018�� 5�� 28�� ���� 11�� 0��

		System.out.println(now);
		System.out.println(nowString);
	}

}

package util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class home {

	public static void main(String[] args) {
		URL url = null;
		BufferedReader input = null;
		String address = "http://localhost:8080/../../etc/passwd";
		//String address = "http://localhost:8080/test";
		//String address = "http://www.naver.com/../../etc/passwd";
		//String address = "http://www.naver.com/etc/passwd";
		String line = "";
		
		try {
			url = new URL(address);
			input = new BufferedReader(new InputStreamReader(url.openStream()));
			
			while((line = input.readLine()) != null) {
				System.out.println(line);
			}
			input.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

package util;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class wonTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String[] tokens = {"GET", "/test.exe.ppt.exe"};
		//String[] tokens = {"GET", "/test.exe"};
		String[] tokens = {"GET", "/index.html?name=test&test=1"};
		Map<String, String> mapRet = extParamToMap(tokens[1]);
		System.out.println(mapRet.size());
		//String[] tokens = {"GET", "/index.exe?name=test&test=1"};
				
		//System.out.println(tokens[1]);
//		System.out.println(tokens[1].indexOf("."));
		//System.out.println(tokens[1].lastIndexOf("."));
		//System.out.println(tokens[1].indexOf(":"));
		
		//System.out.println(tokens[1].split(".").length);
		/*System.out.println(tokens[1].split("/").length);
		System.out.println(tokens[1].split("/")[0]);
		System.out.println(tokens[1].split("/")[1]);
		System.out.println(tokens[1].split(":").length);*/
		
		/*System.out.println(isExtensionExe(tokens[1]));
		
		String sTest = tokens[1];
		Map<String, String> parameters = new HashMap<>();
		
		parameters = extParamToMap(tokens[1]);
		System.out.println(parameters.get("name"));*/
		/*System.out.println(extFileName(tokens[1]));
		System.out.println(extFileName("/hello"));
		System.out.println(extFileName("/hello?name=parm"));*/
		
		/*java.io.Writer writer = new OutputStreamWriter(new ByteArrayOutputStream());
		try {
			writer.write("Hello, ");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(writer);
		*/
		
		/*LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-M-d H:m:s");
		String nowString = now.format(dateTimeFormatter);   // 결과 : 2018년 5월 28일 오후 11시 0분

		System.out.println(now);
		System.out.println(nowString);*/
	}
	
	//filename 추출
	public static String extFileName(String sInput) {
		String sRet = "";
		if(sInput.indexOf("?") > -1) {
			sRet = sInput.split("\\?")[0];
		}else {
			sRet = sInput;
		}
		return sRet;
	}
		
	//확장자 추출
	public static Boolean isExtensionExe(String sInput) {
		Boolean bRet = false;
		if(sInput.indexOf(".") > -1) {
			if(sInput.indexOf("?") > -1) {
				String sTemp = sInput.split("\\?")[0];
				if(sTemp.substring(sInput.lastIndexOf("."), sTemp.length()).equals(".exe")) {
					bRet = true;
				}
			}else {
				if(sInput.substring(sInput.lastIndexOf("."), sInput.length()).equals(".exe")) {
					bRet = true;
				}
			}
		}
		return bRet;
	}

	//paramter 추출
	public static Map<String, String> extParamToMap(String sParam) {
		Map<String, String> mapRet = new HashMap<>();
		if(sParam.indexOf("?") > -1) {
			String[] alTemp = sParam.split("\\?")[1].split("&");
			for (int i = 0; i < alTemp.length; i++) {
				mapRet.put(alTemp[i].substring(0, alTemp[i].indexOf("=")), alTemp[i].substring(alTemp[i].indexOf("=")+1, alTemp[i].length()));
			}
		}
		return mapRet;
	}
	
	/*
	 * https://hsunryou.blog.me/221276940207
	 */
}

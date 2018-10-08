package me.etc.util;

import java.io.IOException;
import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;

public class WriterTest {

	public static void main(String[] args) {
		java.io.Writer writer = new OutputStreamWriter(new ByteArrayOutputStream());
		try {
			writer.write("Hello, ");
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(writer);
	}

}

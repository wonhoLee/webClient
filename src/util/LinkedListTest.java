package util;

import java.util.LinkedList;
import java.util.List;

public class LinkedListTest {

	public static void main(String[] args) {
		List<Integer> lTemp = new LinkedList<>();
		lTemp.add(1);
		lTemp.add(2);
		lTemp.add(1);
		lTemp.add(2);
		
		System.out.println(lTemp.indexOf(1));
		System.out.println(lTemp.indexOf(2));
		
		System.out.println(lTemp.get(0));
		System.out.println(lTemp.get(1));
		
		lTemp.remove(1);
		
		System.out.println(lTemp.toString());
	}

}

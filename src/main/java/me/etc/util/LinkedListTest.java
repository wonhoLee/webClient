package me.etc.util;

import java.util.LinkedList;
import java.util.List;

public class LinkedListTest {

	public static void main(String[] args) {
		List<Integer> lTemp = new LinkedList<>();
		
		System.out.println(lTemp.size());
		
		lTemp.add(1);
		lTemp.add(2);
		lTemp.add(1);
		lTemp.add(2);
		
		/*System.out.println(lTemp.indexOf(1));
		System.out.println(lTemp.indexOf(2));
		
		System.out.println(lTemp.get(0));
		System.out.println(lTemp.get(1));
		
		lTemp.remove(1);*/
		
		/*System.out.println(lTemp.toString());
		
		lTemp.sort(null);*/
		
		System.out.println(lTemp.toString());
		lTemp.add(0, 9);
		
		System.out.println(lTemp.toString());
		
		/*int nBeforeValue = lTemp.get(0);
		int nCnt = 1;
		int nValue = 2;
		boolean bTrue = false;
		for (int i = 1; i < lTemp.size(); i++) {
			if(nBeforeValue == lTemp.get(i)) {
				nCnt++;
			}else {
				if(nCnt == nValue) {
					bTrue = true;
					break;
				}else {
					nCnt=1;
					nBeforeValue = lTemp.get(i);
				}
			}
		}
		
		System.out.println(bTrue);
		*/
	}

}

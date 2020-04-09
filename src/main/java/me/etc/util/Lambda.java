package me.etc.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lambda {

	public static void main(String[] args) {
		// Thread - traditional
		/*new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Hello World.");
			}
		}).start();
		
		// Thread - Lambda Expression
		new Thread(()->{
			System.out.println("Hello World.");
		}).start();
		
		Func add = (int a, int b) -> a + b;
		Func sub = (int a, int b) -> a - b;
		Func add2 = (int a, int b) -> { return a + b; };
		int result = add.calc(1,2) + add2.calc(3, 4); // 10
		
		System.out.println(result);*/
		
		/*Arrays.asList(1,2,3).stream(); // (1)
		Arrays.asList(1,2,3).parallelStream(); // (2)
*/		
		
		//Arrays.asList(1,2,3).stream().forEach(System.out::println); // 1,2,3
		
		/*Arrays.asList(1,2,3).stream()
		.map(i -> i*i)
		.forEach(System.out::println); // 1,4,9
		
		Arrays.asList(1,2,3).stream()
		.limit(1)
		.forEach(System.out::println); // 1
		
		Arrays.asList(1,2,3).stream()
		.skip(1)
		.forEach(System.out::println); // 2,3
		
		Arrays.asList(1,2,3).stream()
		.filter(i-> 2>=i)
		.forEach(System.out::println); // 1,2
		
		Arrays.asList(Arrays.asList(1,2),Arrays.asList(3,4,5),Arrays.asList(6,7,8,9)).stream()
		.flatMap(i -> i.stream())
		.forEach(System.out::println); // 1,2,3,4,5,6,7,8,9
		
		Arrays.asList(1,2,3).stream()
		.reduce((a,b)-> a-b)
		.get(); // -4

		Arrays.asList(1,2,3).stream()
		.collect(Collectors.toList());
		Arrays.asList(1,2,3).stream()
		.iterator();*/

		//testMap();
//		testFilter();
		testString();
	}
	
	@FunctionalInterface
	interface Func {
		public int calc(int a, int b);
	}
	
	public static void testMap() {
		final List<String> names = Arrays.asList("Sehoon", "Songwoo", "Chan", "Youngsuk", "Dajung");

		//java 7
		System.out.println("java 7");
		for(String name : names) {
			System.out.println(name.toUpperCase());
		}

		System.out.println("");

		//java 8 Lambda
		System.out.println("java 8");
		names.stream()
			.map(name -> name.toUpperCase())
			.forEach(name -> System.out.println(name));
	}

	public static void testFilter() {
		final List<String> names = Arrays.asList("Sehoon", "Songwoo", "Chan", "Youngsuk", "Dajung");

		//java 7
		System.out.println("java 7");
		final List<String> startsWithN1 = new ArrayList<String>();
		for (String name : names) {
			if (name.startsWith("S")) {
				startsWithN1.add(name);
			}
		}
		System.out.println(startsWithN1);
		System.out.println("");
		//java 8 Lambda
		System.out.println("java 8");
		final List<String> startsWithN2 =  
				names.stream().filter(name -> name.startsWith("S"))
								.collect(Collectors.toList());
		System.out.println(startsWithN2); 
	}
	
	
	public static void testReduce() {
		final List<String> names = Arrays.asList("Sehoon", "Songwoo", "Chan", "Youngsuk", "Dajung");

		//java 7
		String LongerEliment1  = "";
		for (String name : names) {
			if(("hoone".length() <= name.length()) && (LongerEliment1.length() <= name.length())) {
				LongerEliment1 = name;
			}
		}
		System.out.println("java 7 "+LongerEliment1);

		//java 8 Lambda
		String LongerEliment2 = 
				names.stream()
				.reduce("hoone", (name1, name2) -> 
					name1.length() >= name2.length() ? name1 : name2);
		System.out.println("java 8 "+LongerEliment2);
	}
	
	/*public static void testCollect() {
		final List<String> names = Arrays.asList("Sehoon", "Songwoo", "Chan", "Youngsuk", "Dajung");

		System.out.println("java 7");
		//java 7
		for(int i = 0; i < names.size() - 1; i++) {
			System.out.print(names.get(i).toUpperCase() + ", ");
		}
		if(names.size() > 0) { 
			System.out.println(names.get(names.size() - 1).toUpperCase());
		}

		System.out.println("java 8");
		//java 8 Lambda
		System.out.println(
				names.stream()
					.map(String::toUpperCase)
					.collect(joining(", ")));
	}*/

	public static void testListToArray() {
		List<Integer> source = Arrays.asList(1, 2, 3, 4, 5);
		int[] target = source.stream().mapToInt(Integer::intValue).toArray();
		System.out.println(Arrays.toString(target));
	}

	public static void testString() {
		String[] A = {"서울", "대전", "대구", "부산"};
		String[] B = {"강원", "전주", "서울", "부산", "제주"};

		List<String> listA = Arrays.asList(A);
		List<String> listB = Arrays.asList(B);

		List<String> union = new ArrayList<>(listA);
		listB.stream()
				.filter(e -> !union.contains(e))
				.distinct()
				.forEach(union::add);

		List<String> intersect = listA.stream()
				.filter(listB::contains)
				.distinct()
				.collect(Collectors.toList());

		List<String> difference = union.stream()
				.filter(e -> !intersect.contains(e))
				.distinct()
				.collect(Collectors.toList());

		System.out.println(union);
		System.out.println(intersect);
		System.out.println(difference);
	}
}

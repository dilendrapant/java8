package j8;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Java8StreamAPI {
	public static void main(String[] args) {

		System.out.println("Start :: ");

		// Stream.of(val1, val2, val3….)

		Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 0);
		stream.forEach((x) -> System.out.println(x)); // stream.forEach(System.out::println);

		// Stream.of(arrayOfElement
		System.out.println("Array of integers ");

		Stream<Integer> st1 = Stream.of(new Integer[] { 12, 13, 14, 15, 16, 17, 18, 19 });
		st1.forEach(System.out::println);

		// List.stream()
		System.out.println("List.stream() :: ");

		List<Integer> al = new ArrayList<Integer>();

		for (int i = 0; i < 25; i++) {
			al.add(i * i);
		}

		Stream st2 = al.stream();
		st2.forEach(System.out::println);

		// Stream.generate() or Stream.iterate()
		System.out.println(" Stream.generate() or Stream.iterate()");

		// Stream<Date> std = Stream.generate(()->{return new Date();}); // Infinite
		// stream
		// std.forEach(System.out::println);

		// String chars or String tokens

		System.out.println(" String chars or String tokens");

		IntStream ist = "879729379_27ahgjfgagj".chars();

		ist.forEach(System.out::println);

		// OR

		Stream<String> stst = Stream.of("Dile_ndra_pras_ad_pant".split("\\_"));

		stst.forEach(System.out::println);

		// 3. Convert streams to collections
		System.out.println("3. Convert streams to collections ::");
		System.out.println("Convert Stream to List – Stream.collect( Collectors.toList() )");

		List<Integer> alist = new ArrayList<Integer>();
		for (int i = 0; i < 49; i++) {

			alist.add(i - 7);
		}

		System.out.println("Alist is :: " + alist);
		Stream<Integer> sll = alist.stream();

		List<Integer> even = sll.filter(i -> (i % 2 == 0 & i > 0)).collect(Collectors.toList());
		System.out.println(" Even numbers are :: " + even);

		// Convert Stream to array – Stream.toArray( EntryType[]::new )
		System.out.println("Convert Stream to array – Stream.toArray( EntryType[]::new )  ");

		Stream<Integer> sll2 = alist.stream();

		Integer[] arrL = sll2.filter(i -> (i % 2 == 0 & i > 1)).toArray(Integer[]::new);

		System.out.println("Arr of list ");
		for (int i = 0; i < arrL.length; i++) {
			System.out.println(arrL[i]);
		}

		System.out.println("//  Core stream operations\n" + "");
		List<String> memberNames = new ArrayList<>();
		memberNames.add("Amitabh");
		memberNames.add("Shekhar");
		memberNames.add("Aman");
		memberNames.add("Rahul");
		memberNames.add("Shahrukh");
		memberNames.add("Salman");
		memberNames.add("Yana");
		memberNames.add("Lokesh");

		memberNames.stream().filter((s) -> s.startsWith("A")).forEach(System.out::println);

		// Stream.map()

		System.out.println("// Stream.map()  ");
		memberNames.stream().filter((s) -> s.startsWith("A")).map(String::toUpperCase).forEach(System.out::println);
		System.out.println("memberNames.stream().sorted()\n" + "                    .map(String::toUpperCase)\n"
				+ "                    .forEach(System.out::println);   ");
		memberNames.stream().sorted().map(String::toUpperCase).forEach(System.out::println);

		// Stream.collect()

		System.out.println(" Stream.collect(    )   ");

		List<String> memNamesInUppercase = memberNames.stream().sorted().map(String::toUpperCase)
				.collect(Collectors.toList());

		System.out.print(memNamesInUppercase);

//. Stream.match()
		System.out.println(" \nStream.match()    ");
		boolean matchedResult = memberNames.stream().anyMatch((s) -> s.startsWith("A"));

		System.out.println(matchedResult);

		matchedResult = memberNames.stream().allMatch((s) -> s.startsWith("A"));

		System.out.println(matchedResult);

		matchedResult = memberNames.stream().noneMatch((s) -> s.startsWith("A"));

		System.out.println(matchedResult);
		
		// Stream.count()
		
		System.out.println("Stream.count()");
		
		long totalMatched = memberNames.stream()
                .filter((s) -> s.startsWith("A"))
                .count();

System.out.println(totalMatched);

//Stream.reduce()
System.out.println("Stream.reduce()   ");

Optional<String> reduced = memberNames.stream()
.reduce((s1,s2) -> s1 + "_" + s2);

reduced.ifPresent(System.out::println);


// Stream.anyMatch()

System.out.println(" Stream.anyMatch()    ");

boolean matched = memberNames.stream()
.anyMatch((s) -> s.startsWith("A"));

System.out.println(matched);

//  Stream.findFirst()

System.out.println(" Stream.findFirst()   ");

String firstMatchedName = memberNames.stream()
.filter((s) -> s.startsWith("L"))
.findFirst().get();

System.out.println(firstMatchedName);


// Parallelism in Java Steam

System.out.println(" Parallelism in Java Steam   ");

List<Integer> lists = new ArrayList<Integer>();
for(int i = 1; i< 10; i++){
	lists.add(i);
}
//Here creating a parallel stream
Stream<Integer> st = lists.parallelStream(); 
Integer[] evenNumbersArr = st.filter(i -> i%2 == 0).toArray(Integer[]::new);
System.out.print(evenNumbersArr.length);


	}

}

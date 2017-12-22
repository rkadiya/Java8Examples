package java8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ForEachExample {
	public static void main(String[] args) {
		Map<String, Integer> items = new HashMap<>();
		items.put("A", 10);
		items.put("B", 20);
		items.put("C", 30);
		items.put("D", 40);
		items.put("E", 50);
		items.put("F", 60);

		items.forEach((k,v)->System.out.println("Item : " + k + " Count : " + v));

		items.forEach((k,v)->{
			System.out.println("Item : " + k + " Count : " + v);
			if("E".equals(k)){
				System.out.println("Hello E");
			}
		});
		
		
		List<String> items2 = new ArrayList<>();
		items2.add("A");
		items2.add("B");
		items2.add("C");
		items2.add("D");
		items2.add("E");

		//lambda
		//Output : A,B,C,D,E
		items2.forEach(item->System.out.println(item));
		items2.forEach(item->System.out.println(item));

		//Output : C
		items2.forEach(item->{
			if("C".equals(item)){
				System.out.println(item);
			}
		});

		//method reference
		//Output : A,B,C,D,E
		items2.forEach(System.out::println);

		//Stream and filter
		//Output : B
		items2.stream()
			.filter(s->s.contains("B"))
			.forEach(System.out::println);
	}
}

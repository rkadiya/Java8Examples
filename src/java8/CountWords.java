package java8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class CountWords {
	static Map<String, Integer> count = new HashMap<>();
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		try (Stream<String> stream = Files.lines(Paths.get("/Users/ravitejakadiyam/eclipse-workspace/java8/src/test"))) {
			stream.forEach(line -> {
				String[] words = line.split("\\s");
				Arrays.asList(words).stream().forEach(word -> {
					Integer value = 0;
					if(count.containsKey(word)) {
						value = count.get(word);
					}
					value = value+1;
					count.put(word, value);
				});
			});
			System.out.println(count);
			long endTime   = System.currentTimeMillis();
			long totalTime = endTime - startTime;
			System.out.println(totalTime);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

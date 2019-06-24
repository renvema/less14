package task.fourteenth;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Main {
    public static void main(String[] args) {
        System.out.println("Please enter text:");
        Stream<String> stream = Arrays.stream(new Scanner(System.in, "UTF-8")
                .nextLine()
                .toLowerCase()
                .split("[^0-9a-zA-Zа-яА-Я]+"));
        Map<String, Long> map = stream.collect(Collectors.groupingBy(s -> s, Collectors.counting()));

        map.entrySet().stream().sorted(
                Comparator
                        .comparing((Function<Map.Entry<String, Long>, Long>) Map.Entry::getValue)
                        .reversed()
                        .thenComparing((Map.Entry<String, Long> stringLongEntry) -> stringLongEntry.getKey())
        ).limit(10).forEach(k -> System.out.println(k.getKey()));
    }
}

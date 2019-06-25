package task.fourteenth;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Main {
    public static void main(String[] args) {
        System.out.println("Please enter text:");
        Stream<String> stream = Arrays.stream(new Scanner(System.in, "UTF-8")
                .nextLine()
                .toLowerCase()
                .split("[^0-9a-zA-Zа-яА-Я]+"))
                .stream()
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByKey())
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(10)
                .map(Map.Entry::getKey)
                .forEach(System.out::println);
    }
}

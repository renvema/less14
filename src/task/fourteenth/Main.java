package task.fourteenth;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {
        System.out.println("Please enter text:");
        new ArrayList<String>(Arrays.asList(new Scanner(System.in)
                .nextLine().toLowerCase().split("[^а-яa-z0-9]+")))
                .stream()
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByKey())
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(10)
                .map(Map.Entry::getKey)
                .forEach(System.out::println);
    }
}

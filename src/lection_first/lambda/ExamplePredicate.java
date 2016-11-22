package lection_first.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by Oleg on 14.11.2016.
 */

public class ExamplePredicate {

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

        integers.stream().filter(integer1 -> {
            System.out.println("filter " + integer1);
            return integer1 % 2 == 0;
        })
                .map(integer2 -> {
                    System.out.println("map " + integer2);
                    return integer2.byteValue();
                }).forEach(System.out::println);
        System.out.println(totalValues(integers, integer -> true));
        System.out.println(totalValues(integers, integer -> integer % 2 == 0));
        System.out.println(totalValues(integers, integer -> integer % 2 != 0));
        System.out.println(totalValues(integers, integer -> integer > 3));
        Number number = 2;
    }

    static int totalValues(List<Integer> numbers, Predicate<Integer> selector) {
        return numbers.stream()
                .filter(selector)
                .reduce(0, (integer1, integer2) -> integer1 + integer2);
    }
}

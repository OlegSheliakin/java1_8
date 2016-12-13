package lection_second;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by Oleg on 10.12.2016.
 */
public class MergedIntermediate {
    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        integerList.stream()
                .filter(integer -> {
                    System.out.println("Filter: " + integer);
                    return integer % 2 == 0;
                })
                .map(integer2 -> {
                    System.out.println("Map: " + integer2);
                    return integer2;
                })
                .forEach(System.out::println);
    }

}

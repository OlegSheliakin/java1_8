package lection_first.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.ToLongFunction;

/**
 * Created by Oleg on 04.12.2016.
 */
public class ForEachExample {
    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1,2,3,4,5);

        for (Integer integer : integers) {
            System.out.println(integer);
        }

        integers.forEach(System.out::println);
    }
}

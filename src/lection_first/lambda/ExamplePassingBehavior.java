package lection_first.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by Oleg on 14.11.2016.
 */

public class ExamplePassingBehavior {

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);

        System.out.println(totalValues(integers, integer -> true));
        System.out.println(totalValues(integers, integer -> integer % 2 == 0));
        System.out.println(totalValues(integers, integer -> integer % 2 != 0));
        System.out.println(totalValues(integers, integer -> integer > 3));


    }

    static int totalValues(List<Integer> numbers, Predicate<Integer> selector) {
        Integer result = 0;
        for (Integer number : numbers) {
            if (selector.test(number)){
                result = result + number;
            }
        }
        return result;
    }



}

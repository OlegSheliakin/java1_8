package lection_first.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by Oleg on 04.12.2016.
 */
public class PassingNoBehavior {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        System.out.println(sumAll(numbers));
        System.out.println(sumAllEven(numbers));
        System.out.println(sumAllOdd(numbers));

    }

    public static int sumAll(List<Integer> numbers) {
        int total = 0;
        for (int number : numbers) {
            total += number;
        }
        return total;
    }

    public static int sumAllEven(List<Integer> numbers) {
        int total = 0;
        for (int number : numbers) {
            if (number % 2 == 0) {
                total += number;
            }
        }
        return total;
    }

    public static int sumAllOdd(List<Integer> numbers) {
        int total = 0;
        for (int number : numbers) {
            if (number % 2 != 0) {
                total += number;
            }
        }
        return total;
    }
}

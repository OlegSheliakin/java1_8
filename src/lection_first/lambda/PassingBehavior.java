package lection_first.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by Oleg on 14.11.2016.
 */

public class PassingBehavior {

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);

        System.out.println(sumAll(integers));
        System.out.println(sumEvens(integers));
        System.out.println(sumOdds(integers));

    }

    private static int sumAll (List<Integer> integers){
        int totalValue = 0;
        for (Integer integer : integers) {
            totalValue += integer;
        }
        return totalValue;
    }

    private static int sumEvens (List<Integer> integers){
        int totalValue = 0;
        for (Integer integer : integers) {
            if (integer % 2 == 0) {
                totalValue += integer;
            }
        }
        return totalValue;
    }

    private static int sumOdds (List<Integer> integers){
        int totalValue = 0;
        for (Integer integer : integers) {
            if(integer % 2 != 0) {
                totalValue += integer;
            }
        }
        return totalValue;
    }

}

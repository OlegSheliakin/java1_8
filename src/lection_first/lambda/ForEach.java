package lection_first.lambda;

import java.util.Arrays;
import java.util.List;

/**
 * Created by olegsheliakin on 07/12/16.
 */
public class ForEach {

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1,2,3,4,5);

        for (Integer integer : integers) {
            System.out.println(integer);
        }
    }

}

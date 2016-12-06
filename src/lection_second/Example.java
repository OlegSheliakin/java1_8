package lection_second;

import java.lang.invoke.LambdaMetafactory;
import java.util.Arrays;
import java.util.List;

/**
 * Created by olegsheliakin on 24/11/16.
 */
public class Example {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer integer1p = 54;
        list.stream().filter(integer -> integer % 2 == 0)
                .filter(integer -> {
                    System.out.println(integer);
                    return integer != null;})
                .peek(integer -> System.out.println("peek"))
                .max(Integer::compareTo);
    }
}

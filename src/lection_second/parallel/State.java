package lection_second.parallel;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by Oleg on 12.12.2016.
 */
public class State {
    public static void main(String[] args) {
        Stream<Integer> integers = IntStream.rangeClosed(0, 20).boxed();
        Stream<Integer> parallelIntegers = IntStream.rangeClosed(0, 20).parallel().boxed();

        //parallelIntegers.forEachOrdered(integer -> System.out.print(integer + " "));
        integers.forEach(integer -> System.out.print(integer + " "));
        //System.out.println(sum(integers));
       // System.out.println(sum(parallelIntegers));
    }

    private static int sum(Stream<Integer> stream) {
        int[] i = new int[1];
        stream.forEach(integer -> {
                i[0] += integer;
        });
        return i[0];
    }
}

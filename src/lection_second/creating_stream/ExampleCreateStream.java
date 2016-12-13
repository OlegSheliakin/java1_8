package lection_second.creating_stream;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by Oleg on 10.12.2016.
 */
public class ExampleCreateStream {

    public static void main(String[] args) throws IOException {
        IntStream intStream = IntStream.of(1, 2, 3, 4, 5, 6, 7, 8);
        generateRandom(5);
    }

    private static void iterateStreamEven (int limit){
        Stream.iterate(0, integer -> integer + 2)
                .limit(limit)
                .forEach(System.out::println);
    }

    private static void iterateFibonacci (int limit){
        Stream.iterate(new int[]{0,1}, ints -> new int[]{ints[1], ints[0] + ints[1]})
                .limit(limit)
                .map(ints1 -> ints1[1])
                .forEach(System.out::println);
    }

    private static void generateRandom (int limit){

        Stream.generate(Math::random)
                .limit(limit)
                .forEach(System.out::println);

    }

}

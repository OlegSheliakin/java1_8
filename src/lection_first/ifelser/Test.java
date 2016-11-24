package lection_first.ifelser;

import com.sun.org.apache.xerces.internal.xs.LSInputList;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by olegsheliakin on 23/11/16.
 */
public class Test {
    public static void main(String[] args) throws Exception {
        String srt = "ha";

        List<Integer> list = new ArrayList<>();

        Conditional.of(srt)
                .isNotNull()
                .then(System.out::println)
                .map(String::hashCode)
                .orElseThen(integer -> integer > 5, System.out::println);
    }
}


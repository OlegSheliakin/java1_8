package lection_first.ifelser;

import java.util.function.Consumer;

/**
 * Created by olegsheliakin on 23/11/16.
 */
public class Test {
    public static void main(String[] args) throws Exception {
        String srt = "ha";
        
        Conditional.of(srt)
                .isNotNull().and(String::isEmpty).or(String::isEmpty).orNot(String::isEmpty).andNot(String::isEmpty)
                .map(String::hashCode)
                .then(System.out::println)
                .orElse(integer -> System.out.println("wrong" + integer));

    }
}

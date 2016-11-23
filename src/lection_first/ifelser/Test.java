package lection_first.ifelser;

import java.util.ConcurrentModificationException;

/**
 * Created by olegsheliakin on 23/11/16.
 */
public class Test {
    public static void main(String[] args) throws Exception {
        String srt = "ha";

        Conditional.of(srt)
                .thenIf(s -> s.contains("ss"), s -> System.out.println("1"))
                .thenIf(s -> s.length() > 3, s -> System.out.println("s > 3"))
                .thenIf(s -> s.startsWith("he"), s -> System.out.println("s starts with he"))
                .orElseThrow(() -> new Exception("bad bad"));

        if (srt.contains("123")) {
            System.out.println("success");
        } else {
            System.out.println("error");
        }

    }
}
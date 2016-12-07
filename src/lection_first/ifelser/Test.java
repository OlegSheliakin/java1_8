package lection_first.ifelser;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Function;

/**
 * Created by olegsheliakin on 23/11/16.
 */
public class Test {
    public static void main(String[] args) throws Exception {
        String srt = "Hello SML!!!";

        Conditional.of(srt)
                .isNotNull()
                .then(System.out::println)
                .orElse(s -> System.out.println(String.join(" ", "It is not empty", s)));
    }
}


package lection_first.ifelser;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by olegsheliakin on 23/11/16.
 */
public class Test {
    public static void main(String[] args) throws Exception {
        String srt = "ha";

        List<Integer> list = new ArrayList<>();

        Conditional.of(srt)
                .isNotNull()
                .thenIf(s -> false, s -> System.out.println("thenIf1"))
                .thenIf(s -> true, s -> System.out.println("thenIf2"))
                .thenIf(s -> false, s -> System.out.println("thenIf3"))
                .orElse(s -> System.out.println("orElse"))
                .toContinue()
                .then(s -> System.out.println("then"))
                .thenIf(s -> false, s -> System.out.println("thenIf4"))
                .map(String::hashCode)
                .orElse(System.out::println)
                .orElseThen(integer -> integer > 5, System.out::println);

        SimpleDateFormat formatter = new SimpleDateFormat("mm/dd/yyyy");
        Date date = formatter.parse("05/20/1999");
        Timestamp timestamp = new Timestamp(date.getTime());
        System.out.println(timestamp.toLocalDateTime());

    }
}


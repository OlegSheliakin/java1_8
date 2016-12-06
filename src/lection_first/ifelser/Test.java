package lection_first.ifelser;

/**
 * Created by olegsheliakin on 23/11/16.
 */
public class Test {
    public static void main(String[] args) throws Exception {

        String srt = "Hello SML!!!";

        Conditional.of(srt)
                .isNotNull().andNot(String::isEmpty)
                .then(System.out::println)
                .orElse(s -> System.out.println("error"));

    }

    void printClassName() {
        Runnable runnable = () -> System.out.println(this.toString());
        runnable.run();
    }
}

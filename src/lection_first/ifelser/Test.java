package lection_first.ifelser;

/**
 * Created by olegsheliakin on 23/11/16.
 */
public class Test {
    public static void main(String[] args) throws Exception {
        String srt = "ha";

        /*Conditional.of(srt)
                .thenIf(s -> s.contains("ss"), s -> System.out.println("1"))
                .thenIf(s -> s.length() > 3, s -> System.out.println("s > 3"))
                .thenIf(s -> s.startsWith("he"), s -> System.out.println("s starts with he"))
                .orElseThrow(() -> new Exception("bad bad"));*/


        Conditional.of(srt)
                .isIf(String::isEmpty)
                .orIf(String::isEmpty)
                .orIfNot(String::isEmpty)
                .then(() -> System.out.println("success"))
                .orElse(() -> System.out.println("error"));

      /*  if (srt.contains("123")) {
            System.out.println("success");
        } else {
            System.out.println("error");
        }*/

    }
}

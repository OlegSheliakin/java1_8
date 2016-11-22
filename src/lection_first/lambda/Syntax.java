package lection_first.lambda;

/**
 * Created by Oleg on 20.11.2016.
 */
public class Syntax {
    public static void main(String[] args) {
        Runnable runnable = () -> System.out.println("run");
        Calculator func1 = (integer1, integer2) -> integer1 + integer2;

        Calculator func2 =  (integer1, integer2) -> {
            return integer1 * integer2;
        };


    }


}

@FunctionalInterface
interface Calculator {
    Integer calculate (Integer integer1, Integer integer2);
}


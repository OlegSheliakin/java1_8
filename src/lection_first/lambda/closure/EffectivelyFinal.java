package lection_first.lambda.closure;


import java.util.List;
import java.util.Observable;
import java.util.stream.Stream;

public class EffectivelyFinal {


    public static void main(String[] args) {
        String greeting = "Hello";
        int i = 0;
        //greeting = "Hi"; // should be final or effectively final

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(i);
                System.out.println(String.join(" ", greeting, "SML!"));

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }
}

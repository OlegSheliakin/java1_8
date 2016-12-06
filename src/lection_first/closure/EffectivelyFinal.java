package lection_first.closure;


import java.util.List;
import java.util.Observable;

public class EffectivelyFinal {

    public static void main(String[] args) {
        String greeting = "Hello";
        //greeting = "Hi"; // should be final or effectively final

        Thread thread = new Thread(() -> {
            System.out.println(String.join(" ", greeting, "SML!"));

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();
    }
}

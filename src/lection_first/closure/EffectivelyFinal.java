package lection_first.closure;


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

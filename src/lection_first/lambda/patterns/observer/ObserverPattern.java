package lection_first.lambda.patterns.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * Created by Oleg on 21.11.2016.
 */
//subject
class Moon {
    private final List<LandingObserver> observers = new ArrayList<>();

    void land(String name){
        String message = String.join(" ", name, "опустился на Луну");
        System.out.println(message);
        observers.forEach(landingObserver -> landingObserver.observeLanding(name));
    }

    void startSpying (LandingObserver observer){
        observers.add(observer);
    }
}

//strategy
interface LandingObserver{
    void observeLanding (String name);
}

//concrete strategy
class Aliens implements LandingObserver{
    @Override
    public void observeLanding(String name) {
        if(name.contains("Apollo")){
            System.out.println("Aliens -> Они отвлеклись, вторгаемся на Землю!");
        }
    }
}

//concrete strategy
class Nasa implements LandingObserver{
    @Override
    public void observeLanding(String name) {
        if(name.contains("Apollo")){
            System.out.println("Nasa -> Мы сделали это");
        }
    }
}

//client
public class ObserverPattern{
    public static void main(String[] args) {
        Moon moon = new Moon();
        Aliens aliens = new Aliens();
        Nasa nasa = new Nasa();

        moon.startSpying(aliens);
        moon.startSpying(nasa);

        moon.land("Астероид");

        for (int i = 0; i < 5; i++) {
            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.print(".");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println();
        moon.land("Apollo");

    }
}

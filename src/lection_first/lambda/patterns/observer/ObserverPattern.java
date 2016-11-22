package lection_first.lambda.patterns.observer;

import java.util.List;

/**
 * Created by Oleg on 21.11.2016.
 */

class Moon {

    private final List<LandingObserver> observers;

    Moon(List<LandingObserver> observers) {
        this.observers = observers;
    }

    public void land (String name){
        observers.forEach(landingObserver -> landingObserver.observeLanding(name));
    }

    public void addObserver (LandingObserver observer){
        observers.add(observer);
    }
}

interface LandingObserver{
    void observeLanding (String name);
}

class Aliens implements LandingObserver{

    @Override
    public void observeLanding(String name) {
        if(name.contains("Apollo")){

        }
    }
}

public class ObserverPattern{
    public static void main(String[] args) {



    }
}

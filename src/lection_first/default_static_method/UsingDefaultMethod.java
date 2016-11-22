package lection_first.default_static_method;

/**
 * Created by Oleg on 13.11.2016.
 */

interface Sportsmen {
    default void walk (){
        System.out.println("Sportsmen::walk");
    }
    default void run (){
        System.out.println("Sportsmen::run");
    }
    default void jump (){
        System.out.println("Sportsmen::jump");
    }
}

interface Runner extends Sportsmen{
    default void run (){
        System.out.println("Runner::run");
    }
}

interface Walker {
    default void walk (){
        System.out.println("Walker::walk");
    }
}

class SuperWalker{
    public void run (){
        System.out.println("SuperWalker::run");
    }
}

class Footballer implements Runner{

}

public class UsingDefaultMethod {
    public static void main(String[] args) {
        Footballer footballer = new Footballer();
        footballer.walk();
        footballer.run();
        footballer.jump();
    }
}

package lection_first.lambda;

/**
 * Created by Oleg on 13.11.2016.
 */
public class Actor {

    private String name;

    public Actor (){}

    public Actor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void printYourself() {
        System.out.println(name);
    }

    public void printYourself(Actor s) {
        System.out.println(s.getName());
    }
}

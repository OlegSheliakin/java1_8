package lection_second.data.entity;

/**
 * Created by olegsheliakin on 24/11/16.
 */
public class Skill {

    private final String name;

    public Skill(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Skill{" +
                "name='" + name + '\'' +
                '}';
    }
}

package lection_second.collectors.data;

import java.util.List;

/**
 * Created by olegsheliakin on 24/11/16.
 */
public class Value {

    private final String name;
    private final List<Skillbox> skillboxes;

    public Value(String name, List<Skillbox> skillboxes) {
        this.name = name;
        this.skillboxes = skillboxes;
    }

    public String getName() {
        return name;
    }

    public List<Skillbox> getSkillboxes() {
        return skillboxes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Value)) return false;

        Value value = (Value) o;

        return name != null ? name.equals(value.name) : value.name == null;

    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Value{" +
                "name='" + name + '\'' +
                ", skillboxes=" + skillboxes +
                '}';
    }
}

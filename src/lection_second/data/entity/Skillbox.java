package lection_second.data.entity;

import java.util.List;

/**
 * Created by olegsheliakin on 24/11/16.
 */
public class Skillbox {

    private final String name;
    private final List<Skill> skills;

    public Skillbox(String name, List<Skill> skills) {
        this.name = name;
        this.skills = skills;
    }

    public String getName() {
        return name;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Skillbox)) return false;

        Skillbox skillbox = (Skillbox) o;

        return name != null ? name.equals(skillbox.name) : skillbox.name == null;

    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}

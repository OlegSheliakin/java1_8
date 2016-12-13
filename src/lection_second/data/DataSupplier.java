package lection_second.data;

import lection_second.data.entity.Skill;
import lection_second.data.entity.Skillbox;
import lection_second.data.entity.User;
import lection_second.data.entity.Value;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Oleg on 10.12.2016.
 */
public class DataSupplier {
    public static List<User> getUsers() {
        List<User> users = new ArrayList<>();
        users.add(new User("Robert", "male", 17, User.TYPE.TEENAGER));
        users.add(new User("Tom", "male", 33, User.TYPE.OTHER));
        users.add(new User("Eva", "female", 18, User.TYPE.TEENAGER));
        users.add(new User("Jack", "male", 30, User.TYPE.OTHER));
        users.add(new User("Ralph", "male", 27, User.TYPE.OTHER));
        users.add(new User("Kate", "female", 28, User.TYPE.OTHER));
        users.add(new User("Charlize", "female", 20, User.TYPE.ADULT));
        users.add(new User("Daniel", "male", 18, User.TYPE.TEENAGER));
        users.add(new User("Olivia", "female", 24, User.TYPE.ADULT));
        users.add(new User("Natalie", "female", 29, User.TYPE.OTHER));
        return users;
    }

    public static List<Value> getValues() {
        List<Skillbox> skillAuthBox = new ArrayList<>();
        skillAuthBox.add(new Skillbox("auth_left", generate("auth_left", 5)));
        skillAuthBox.add(new Skillbox("auth_right", generate("auth_right", 5)));

        List<Skillbox> skillIntelBox = new ArrayList<>();
        skillIntelBox.add(new Skillbox("intelligence_left", generate("intelligence_left", 5)));
        skillIntelBox.add(new Skillbox("intelligence_right", generate("intelligence_right", 5)));

        List<Skillbox> skillCompBox = new ArrayList<>();
        skillCompBox.add(new Skillbox("compassion_left", generate("compassion_left", 5)));
        skillCompBox.add(new Skillbox("compassion_right", generate("compassion_right", 5)));

        Value authority = new Value("Authority", skillAuthBox);
        Value intelligence = new Value("Intelligence", skillIntelBox);
        Value compassion = new Value("Compassion", skillCompBox);

        List<Value> values = new ArrayList<>();
        values.add(authority);
        values.add(intelligence);
        values.add(compassion);
        return values;
    }

    private static List<Skill> generate(String name, Integer amount) {
        List<Skill> skills = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            skills.add(new Skill(name + "_" + i));
        }
        return skills;
    }
}

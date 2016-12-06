package lection_second.collectors.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by olegsheliakin on 24/11/16.
 */
public class DataSupplier {

    public static List<Value> getValues (){
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

    private static List<Skill> generate (String name, Integer amount){
        List<Skill> skills = new ArrayList<>();
        for (int i = 0; i < amount; i++){
            skills.add(new Skill(name + "_"+i));
        }
        return skills;
    }

}

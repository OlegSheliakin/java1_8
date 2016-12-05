package lection_second.collectors;

import lection_first.ifelser.Conditional;
import lection_second.collectors.data.DataSupplier;
import lection_second.collectors.data.Skill;
import lection_second.collectors.data.Value;

import javax.xml.crypto.Data;
import java.util.*;
import java.util.concurrent.SynchronousQueue;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * Created by olegsheliakin on 24/11/16.
 */
public class CollectorExample {

    public static void main(String[] args) {
        System.out.println(DataSupplier.getValues());
        generateAuthority(DataSupplier.getValues(), DataSupplier.getValues().get(2), DataSupplier.getValues().get(2), 10);
    }

    private static List<Skill> reduceSkills(Value value) {
        return value.getSkillboxes().stream()
                .flatMap(skillbox -> skillbox.getSkills()
                        .stream()).collect(Collectors.toList());
    }

    private static List<Skill> generateAuthority(List<Value> values, Value current, Value chosen, Integer amount) {
        Integer amountHeroValue;
        Integer amountChosen;
        Integer amountOther;

        if (current.getName().equals(chosen.getName())){
            amountHeroValue = Float.valueOf(amount / 2F * 4).intValue();
            amountChosen = Float.valueOf(amount / 2F * 4).intValue();
            amountOther = Float.valueOf(amount /4F * 4).intValue();
        } else {
            amountHeroValue = Float.valueOf((amount * 35) / 100F * 4).intValue();
            amountChosen = Float.valueOf((amount * 4) / 10F * 4).intValue();
            amountOther = Float.valueOf((amount * 25)/100F * 4).intValue();
        }

        System.out.println("amount of hero value - " + amountHeroValue);
        System.out.println("amountChosen - " + amountChosen);
        System.out.println("amountOther - " + amountOther);

        List<Skill> result = new ArrayList<>();
        Map<String, List<Skill>> map = new HashMap<>();
        values.forEach(value -> map.put(value.getName(), reduceSkills(value)));
        map.forEach((s, skills) -> {
            Collections.shuffle(skills);
            Conditional.of(s).is(s1 -> s1.equals(chosen.getName()))
                    .then(s1 -> result.addAll(skills.stream().limit(amountChosen).collect(Collectors.toList())))
                    .orElseThen(
                            s1 -> s1.equals(current.getName()) && !chosen.getName().equals(current.getName()),
                            s1 -> result.addAll(skills.stream().limit(amountHeroValue).collect(Collectors.toList())))
                    .orElse(s1 -> result.addAll(skills.stream().limit(amountOther).collect(Collectors.toList())));
        });

        System.out.println(result.size());
        System.out.println(result);
        Collections.shuffle(result);
        System.out.println(result.stream().limit(amount).collect(Collectors.toList()));

        return result.stream().limit(amount).collect(Collectors.toList());
    }


}

package lection_second.collectors;

import lection_first.ifelser.Conditional;
import lection_second.data.DataSupplier;
import lection_second.data.entity.Skill;
import lection_second.data.entity.Value;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;


/**
 * Created by olegsheliakin on 24/11/16.
 */
public class CollectorExample {

    public static void main(String[] args) {
        System.out.println(DataSupplier.getValues());

    }

    private static List<Skill> reduceSkills(Value value) {
        return value.getSkillboxes().stream()
                .flatMap(skillbox -> skillbox.getSkills()
                        .stream()).collect(Collectors.toList());
    }

}

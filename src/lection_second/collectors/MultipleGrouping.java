package lection_second.collectors;

import lection_second.Utils;
import lection_second.data.DataSupplier;
import lection_second.data.entity.User;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lection_second.data.entity.User.TYPE.*;

/**
 * Created by Oleg on 10.12.2016.
 */
public class MultipleGrouping {

    public static void main(String[] args) {
        List<User> users = DataSupplier.getUsers();

        Map<User.TYPE, List<User>> usersByType = users.stream().collect(Collectors.groupingBy(User::getType, Collectors.toList()));
        Utils.printMap(usersByType);

        Map<String, Map<User.TYPE, Set<User>>> map = users.stream().collect(
                Collectors.groupingBy(
                        User::getGender, Collectors.groupingBy(User::getType, Collectors.toSet())));

        map.forEach((s, typeSetMap) -> {
            System.out.println("Gender: " + s);
            Utils.printMap(typeSetMap);
        });

        Map<User.TYPE, User> maxBy = users.stream()
                .collect(Collectors.groupingBy(User::getType,
                        Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingInt(User::getAge)), Optional::get)));
        Utils.printMap(maxBy);
    }

}

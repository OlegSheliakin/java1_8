package lection_second.collectors;

import lection_second.Utils;
import lection_second.data.DataSupplier;
import lection_second.data.entity.User;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Oleg on 10.12.2016.
 */
public class Partitioning {
    public static void main(String[] args) {
        List<User> users = DataSupplier.getUsers();

        Map<Boolean, Map<User.TYPE, List<User>>> usersByGender = users.stream()
                .collect(
                        Collectors.partitioningBy(
                                user -> user.getGender().equals("male"),
                                Collectors.groupingBy(User::getType))
                );
        System.out.println("female");
        Utils.printMap(usersByGender.get(false));
        System.out.println("male");
        Utils.printMap(usersByGender.get(true));

        Collections.shuffle(users);
        Map map = users.stream().limit(4).collect(Collectors.partitioningBy(user -> user.getGender().equals("male")));
        Utils.printMap(map);
    }
}

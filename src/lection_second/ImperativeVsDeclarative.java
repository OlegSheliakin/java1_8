package lection_second;

import lection_second.data.DataSupplier;
import lection_second.data.entity.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;

/**
 * Created by Oleg on 10.12.2016.
 */

//Task: group by age, sort in natural order and fill new list with names;
public class ImperativeVsDeclarative {
    public static void main(String[] args) {
        List<User> users = DataSupplier.getUsers();
        System.out.println(users);
        imperativeStyle(users, 25);
        declarativeStyle(users, 25);
    }

    private static void declarativeStyle(List<User> users, int age) {
        List<String> onlyNames = users.stream()
                .filter(user -> user.getAge() > age)
                .sorted(comparing(User::getAge))
                .map(User::getName)
                .collect(Collectors.toList());
        System.out.println(onlyNames); // -> [Ralph, Kate, Natalie, Jack, Tom]
    }

    private static void imperativeStyle(List<User> users, int age) {
        List<User> usersOlderThan25 = new ArrayList<>();

        for (User user : users) {
            if (user.getAge() > age) {
                usersOlderThan25.add(user);
            }
        }

        Collections.sort(usersOlderThan25, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getAge() > o2.getAge() ? 1 : -1;
            }
        });

        List<String> onlyNames = new ArrayList<>();

        for (User user : usersOlderThan25) {
            onlyNames.add(user.getName());
        }
        System.out.println(onlyNames); // -> [Ralph, Kate, Natalie, Jack, Tom]
    }
}

package lection_second.methods;

import lection_second.data.DataSupplier;
import lection_second.data.entity.User;

/**
 * Created by Oleg on 10.12.2016.
 */
public class Operations {

    public static void main(String[] args) {
        String names = DataSupplier.getUsers()
                .stream()
                .map(User::getName)
                .reduce((s, s2) -> String.join(", ", s, s2))
                .orElse("empty");
        System.out.println("Str: " + names);

        boolean ageIsEven = DataSupplier.getUsers().stream()
                .map(User::getAge)
                .allMatch(integer -> {
                    System.out.println("Match: " + integer);
                    return integer % 2 == 0;
                });
        System.out.println("All people have an even age: " + ageIsEven);

        User firstFemale = DataSupplier.getUsers().stream()
                .filter(user -> user.getGender().equals("female"))
                .findFirst().orElse(new User());
        System.out.println(firstFemale);

        System.out.println();
        DataSupplier.getUsers().stream().limit(5).forEach(System.out::println);

        int maxAge = DataSupplier.getUsers().stream()
                .map(User::getAge)
                .reduce((integer, integer2) -> integer.compareTo(integer2) == 1 ? integer : integer2)
                .orElse(0);
        int minAge = DataSupplier.getUsers().stream()
                .map(User::getAge)
                .reduce((integer, integer2) -> integer.compareTo(integer2) == -1 ? integer : integer2)
                .orElse(0);
        System.out.println(maxAge);
        System.out.println(minAge);
    }

}

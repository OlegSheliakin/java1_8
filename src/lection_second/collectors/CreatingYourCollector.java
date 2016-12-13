package lection_second.collectors;

import lection_second.data.DataSupplier;
import lection_second.data.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Oleg on 10.12.2016.
 */
public class CreatingYourCollector {
    public static void main(String[] args) {
        List<User> users = DataSupplier.getUsers();
        List<User> male = users.stream().filter(user -> user.getGender().equals("male")).collect(new ToListCollector<>());
        System.out.println(male);

        List<User> female = users.stream().filter(user -> user.getName().equals("female"))
                .collect(ArrayList::new,
                        List::add,
                        ArrayList::addAll);
        System.out.println(female);

    }
}

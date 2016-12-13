package lection_second.collectors;

import lection_second.data.DataSupplier;
import lection_second.data.entity.User;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Comparator.*;
import static java.util.stream.Collectors.*;

/**
 * Created by Oleg on 10.12.2016.
 */
public class CollectorReducing {
    public static void main(String[] args) {
        List<User> users = DataSupplier.getUsers();
        int sumAges = DataSupplier.getUsers().stream()
                .map(User::getAge)
                .collect(Collectors.reducing(0, (t, t2) -> t + t2));
        System.out.println(sumAges);

        String str = DataSupplier.getUsers()
                .stream()
                .map(User::getName)
                .collect(Collectors.reducing((t, t2) -> t + t2))
                .orElse("empty");

        IntSummaryStatistics summaryStatistics = users.stream().collect(Collectors.summarizingInt(User::getAge));
        System.out.println(summaryStatistics);
    }
}

package lection_second.collectors;

import lection_second.Utils;
import lection_second.data.DataSupplier;
import lection_second.data.entity.User;

import javax.rmi.CORBA.Util;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Oleg on 10.12.2016.
 */
public class Mapping {

    public static void main(String[] args) {
        List<User> users = DataSupplier.getUsers();

        Map<User.TYPE, Set<String>> namesByType = users.stream()
                .collect(Collectors.groupingBy(User::getType, Collectors.mapping(User::getName, Collectors.toSet())));
        Utils.printMap(namesByType);
    }
}

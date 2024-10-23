package ru.javawebinar.topjava.util;

import ru.javawebinar.topjava.model.AbstractNamedEntity;
import ru.javawebinar.topjava.model.User;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class UsersUtil {
    public static List<User> orderByName(List<User> users) {
        return users.stream().sorted(Comparator.comparing(AbstractNamedEntity::getName)).collect(Collectors.toList());
    }

}

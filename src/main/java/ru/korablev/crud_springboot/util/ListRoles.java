package ru.korablev.crud_springboot.util;

import java.util.*;

public final class ListRoles {

    private static Set<String> listRole;

    public ListRoles() {
        listRole = new HashSet<>();
        listRole.add("user");
        listRole.add("admin");
    }

    public Collection<String> getListRole() {
        return listRole;
    }
}
package ru.korablev.crud_springboot.util;

import java.util.ArrayList;
import java.util.List;

public final class ListRoles {

    private static List<String> listRole;

    public ListRoles() {
        listRole = new ArrayList<>();
        listRole.add("user");
        listRole.add("admin");
    }

    public List<String> getListRole() {
        return listRole;
    }
}
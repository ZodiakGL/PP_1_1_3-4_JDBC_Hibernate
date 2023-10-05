package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        userService.createUsersTable();
        /*userService.saveUser("Michael", "Jackson", (byte) 50);
        userService.saveUser("Napoleon", "Bonaparte", (byte) 51);
        userService.saveUser("Nikola", "Tesla", (byte) 86);
        userService.saveUser("Iosif", "Stalin", (byte) 74);
        userService.getAllUsers();
        userService.dropUsersTable();
        userService.cleanUsersTable();*/
    }
}

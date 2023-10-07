package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;
import org.hibernate.SessionFactory;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        SessionFactory sessionFactory = Util.getSessionFactory();
        if (sessionFactory != null) {
            System.out.println("Сессия успешно создана.");
        } else {
            System.out.println("Сессия не создана.");
        }
        userService.createUsersTable();
        userService.saveUser("Vova", "Vova2", (byte) 14);
        userService.saveUser("Vova2", "Vova25", (byte) 30);
        userService.saveUser("Vova3", "Vova23", (byte) 20);
        userService.saveUser("Vova32", "Vova213", (byte) 4);
        userService.getAllUsers();
        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}

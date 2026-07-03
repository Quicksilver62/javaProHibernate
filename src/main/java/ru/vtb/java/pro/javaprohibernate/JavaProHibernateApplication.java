package ru.vtb.java.pro.javaprohibernate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.vtb.java.pro.javaprohibernate.config.AppConfig;
import ru.vtb.java.pro.javaprohibernate.domain.User;
import ru.vtb.java.pro.javaprohibernate.services.UserService;

public class JavaProHibernateApplication {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        User user = userService.createUser("John Doe");
        System.out.println("Создан пользователь: " + user);

        User foundUser = userService.findUserById(user.getId());
        System.out.println("Найден пользователь: " + foundUser);

        userService.createUser("Richard Roe");
        System.out.println("Все пользователи: " + userService.findAllUsers());

        userService.deleteUser(1L);
        System.out.println("Пользователи после удаления: " + userService.findAllUsers());
    }
}

package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

//      userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
//      userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
//      userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
//      userService.add(new User("User4", "Lastname4", "user4@mail.ru"));
        User a = new User();

        User anton = new User("Anton", "Grigorjevich", "anton@mail.ru");
        User sergey = new User("Sergey", "Evgenjevich", "sergey@mail.ru");
        User vasiliy = new User("Vasiliy", "Igorevich", "vaska@mail.ru");
        User dima = new User("Dmitry", "Ponteleevich", "dmitry@mail.ru");
        Car audi = new Car("Audi", 1123123);
        Car bmw = new Car("BMW", 1232345);
        Car mer = new Car("M5", 1213212);
        Car ref = new Car("Ref-Ref", 1131);
        anton.setCar(audi);
        sergey.setCar(bmw);
        vasiliy.setCar(mer);
        dima.setCar(ref);
        userService.add(anton);
        userService.add(sergey);
        userService.add(dima);
        userService.add(vasiliy);


        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println("Car = " + user.getCar().getInfoOfCar(user.getCar()));
            System.out.println();
        }


        context.close();
    }
}

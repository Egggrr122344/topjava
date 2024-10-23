package ru.javawebinar.topjava;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.Role;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.repository.MealRepository;
import ru.javawebinar.topjava.repository.inmemory.InMemoryMealRepository;
import ru.javawebinar.topjava.service.MealService;
import ru.javawebinar.topjava.util.MealsUtil;
import ru.javawebinar.topjava.util.UsersUtil;
import ru.javawebinar.topjava.web.meal.MealRestController;
import ru.javawebinar.topjava.web.user.AdminRestController;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SpringMain {
    public static void main(String[] args) {
        // java 7 automatic resource management (ARM)
//        try (ConfigurableApplicationContext appCtx = new ClassPathXmlApplicationContext("spring/spring-app.xml")) {
//            System.out.println("Bean definition names: " + Arrays.toString(appCtx.getBeanDefinitionNames()));
//
//        }

//        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-app.xml");
//
//        System.out.println("Bean definitions names: " + Arrays.toString(context.getBeanDefinitionNames()));
//
//        AdminRestController adminUserController = context.getBean(AdminRestController.class);
//        adminUserController.create(new User(null, "userName", "email@mail.ru", "password", Role.ADMIN));
//        MealRestController mealRestController = context.getBean(MealRestController.class);
//        mealRestController.create(new Meal(LocalDateTime.of(2020, Month.JANUARY, 1, 10, 0), "Завтрак", 500),
//                1);
//
//
//
//        List<Meal> meals = Arrays.asList(
//                new Meal(LocalDateTime.of(2020, Month.JANUARY, 1, 10, 0), "Завтрак", 500),
//                new Meal(LocalDateTime.of(2020, Month.JANUARY, 2, 13, 0), "Обед", 1000),
//                new Meal(LocalDateTime.of(2020, Month.JANUARY, 3, 20, 0), "Ужин", 500),
//                new Meal(LocalDateTime.of(2020, Month.JANUARY, 4, 0, 0), "Еда на граничное значение", 100),
//                new Meal(LocalDateTime.of(2020, Month.JANUARY, 5, 10, 0), "Завтрак", 1000),
//                new Meal(LocalDateTime.of(2020, Month.JANUARY, 6, 13, 0), "Обед", 500),
//                new Meal(LocalDateTime.of(2020, Month.JANUARY, 31, 20, 0), "Ужин", 410)
//        );
//
//        System.out.println(MealsUtil.orderedByDate(meals));

    }
}

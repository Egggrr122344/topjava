package ru.javawebinar.topjava;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.javawebinar.topjava.configuration.ApplicationConfig;
import ru.javawebinar.topjava.configuration.HsqldbConfig;
import ru.javawebinar.topjava.configuration.JdbcConfig;
import ru.javawebinar.topjava.configuration.JpaConfig;

import java.util.Arrays;

public class TestAppConfig {
    public static void main(String[] args) {
        try {
            System.setProperty("spring.profiles.active", "datajpa");
            AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JpaConfig.class);
            System.out.println("Spring context loaded!");
            System.out.println("Active profile: " + context.getEnvironment().getActiveProfiles()[0]);
            System.out.println(Arrays.toString(context.getBeanDefinitionNames()));
            context.close();
        } catch (Exception e) {
            System.out.println("Выпало исключение: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}

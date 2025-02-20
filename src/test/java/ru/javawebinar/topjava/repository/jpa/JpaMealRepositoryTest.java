package ru.javawebinar.topjava.repository.jpa;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import ru.javawebinar.topjava.configuration.ApplicationConfig;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.Role;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.repository.MealRepository;
import ru.javawebinar.topjava.repository.UserRepository;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.logging.Logger;

import static org.junit.Assert.*;



@ContextConfiguration(classes = ApplicationConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
@Ignore
@ActiveProfiles({"jdbc", "datajpa"})
public class JpaMealRepositoryTest {

    @Autowired
    @Qualifier("jpaMealRepository")
    private  MealRepository repository;

    @Autowired
    @Qualifier("jpaUserRepository")
    private  UserRepository userRepository;

    private static final Logger log = Logger.getLogger("result");


    @Test
    public void WhenJPACompileThenRepo_NotNull() {
        assertNotNull(repository);
        assertNotNull(userRepository);
    }

    @Test
    public void save() {
        Meal existing = new Meal(LocalDateTime.of(2025, Month.FEBRUARY, 16, 17, 49), "Dinner", 700);

        User user = new User(2, "Egor", "ackerman-cmd@mail.ru", "cmd-cmd", Role.ADMIN);

        User get = userRepository.save(user);

        assertEquals(user, get);

        existing.setUser(user);

        assertEquals(existing, repository.save(existing, get.id()));
    }

    @Test
    public void delete() {
    }

    @Test
    public void get() {
    }

    @Test
    public void getAll() {
    }

    @Test
    public void getBetweenHalfOpen() {
    }
}
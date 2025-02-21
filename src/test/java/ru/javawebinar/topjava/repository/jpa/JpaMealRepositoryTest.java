package ru.javawebinar.topjava.repository.jpa;

import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.javawebinar.topjava.configuration.ApplicationConfig;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.Role;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.repository.MealRepository;
import ru.javawebinar.topjava.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Logger;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationConfig.class)
@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
@ActiveProfiles({"jdbc", "datajpa"})
public class JpaMealRepositoryTest {

    @Autowired
    @Qualifier("jpaMealRepository")
    private MealRepository mealRepository;

    @Autowired
    @Qualifier("jpaUserRepository")
    private UserRepository userRepository;

    private static final Logger log = Logger.getLogger(JpaMealRepositoryTest.class.getName());

    private static User user;
    private static User admin;
    private static Meal mealUser;
    private static Meal mealAdmin;

    @BeforeClass
    public static void beforeAll() {
        log.info("Setting up test users and meals");
    }

    @Before
    public void setUp() {
        user = userRepository.save(new User(null, "TestUser", "user@test.com", "password", Role.USER));
        admin = userRepository.save(new User(null, "TestAdmin", "admin@test.com", "password", Role.ADMIN));

        mealUser = mealRepository.save(new Meal(LocalDateTime.now(), "UserMeal", 500), user.getId());
        mealAdmin = mealRepository.save(new Meal(LocalDateTime.now(), "AdminMeal", 700), admin.getId());
    }

    @After
    public void tearDown() {
        mealRepository.delete(mealUser.getId(), user.getId());
        mealRepository.delete(mealAdmin.getId(), admin.getId());
        userRepository.delete(user.getId());
        userRepository.delete(admin.getId());
    }

    @AfterClass
    public static void afterAll() {
        log.info("Tests finished, cleanup done");
    }

    @Test
    public void testRepositoryNotNull() {
        assertNotNull(mealRepository);
        assertNotNull(userRepository);
    }

    @Test
    public void testSaveMeal() {
        Meal meal = new Meal(LocalDateTime.now(), "Lunch", 600);
        Meal savedMeal = mealRepository.save(meal, user.getId());
        assertNotNull(savedMeal);
        assertEquals(meal, savedMeal);
    }

    @Test
    public void testDeleteMeal() {
        Meal meal = mealRepository.save(new Meal(LocalDateTime.now(), "TestDelete", 400), user.getId());
        assertTrue(mealRepository.delete(meal.getId(), user.getId()));
        assertNull(mealRepository.get(meal.getId(), user.getId()));
    }

    @Test
    public void testGetMeal() {
        Meal fetchedMeal = mealRepository.get(mealUser.getId(), user.getId());
        assertNotNull(fetchedMeal);
        assertEquals(mealUser, fetchedMeal);
    }

    @Test
    public void testGetAllMeals() {
        List<Meal> meals = mealRepository.getAll(user.getId());
        assertFalse(meals.isEmpty());
    }

    @Test
    public void testGetMealsBetweenDates() {
        List<Meal> meals = mealRepository.getBetweenHalfOpen(
                LocalDateTime.of(2024, 1, 1, 0, 0),
                LocalDateTime.of(2025, 12, 31, 23, 59),
                user.getId());
        assertNotNull(meals);
        assertFalse(meals.isEmpty());
    }
}

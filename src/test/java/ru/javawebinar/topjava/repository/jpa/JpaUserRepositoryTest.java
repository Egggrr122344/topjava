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
import ru.javawebinar.topjava.model.Role;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.repository.MealRepository;
import ru.javawebinar.topjava.repository.UserRepository;

import java.util.logging.Logger;

import static org.junit.Assert.*;

@ContextConfiguration(classes = ApplicationConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
@ActiveProfiles({"datajpa", "jdbc"})
public class JpaUserRepositoryTest {

    @Autowired
    @Qualifier("jpaUserRepository")
    private UserRepository userRepository;

    private User userAdmin;

    private User testUser;

    private static final Logger log = Logger.getLogger(JpaUserRepository.class.getName());

    @BeforeClass
    public static void beforeClass() throws Exception {
        log.info("Tests are starting");
    }

    @AfterClass
    public static void afterClass() throws Exception {
        log.info("Tests was completed");
    }

    @Before
    public void setUp() throws Exception {
        userAdmin = userRepository.save(new User(1, "Admin", "admin123@mail.ru", "123", Role.ADMIN));
        testUser = userRepository.save(new User(2, "User", "user123@mail.ru", "123", Role.USER));

    }

    @After
    public void tearDown() throws Exception {
        userRepository.delete(userAdmin.getId());
        userRepository.delete(testUser.getId());
    }

    @Test
    public void save() {
        User toAddUser = new User(3, "Egor", "123@mail.ru", "321", Role.USER);
        User added = userRepository.save(toAddUser);
        assertNotNull(added);
        assertEquals(toAddUser.getName(), added.getName());
        assertEquals(toAddUser.getEmail(), added.getEmail());
        assertEquals(toAddUser.getPassword(), added.getPassword());
        assertEquals(toAddUser.getRoles(), added.getRoles());
    }

    @Test
    public void get() {
        assertNotNull(userRepository.get(testUser.getId()));
    }

    @Test
    public void delete() {
        User user  = userRepository.save(new User(5, "vasya", "vasya@mail.ru", "123", Role.ADMIN));
        assertTrue(userRepository.delete(user.getId()));
        assertNull(userRepository.get(user.getId()));

    }

    @Test
    public void getByEmail() {
        assertNotNull(userRepository.getByEmail("admin123@mail.ru"));
        assertNotNull(userRepository.getByEmail("user123@mail.ru"));
    }

    @Test
    public void getAll() {
        assertNotNull(userRepository.getAll());
    }
}
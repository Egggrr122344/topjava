package ru.javawebinar.topjava.service;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.bridge.SLF4JBridgeHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringRunner;
import ru.javawebinar.topjava.MealTestData;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.util.exception.NotFoundException;

import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDateTime;

import static org.junit.Assert.assertThrows;
import static ru.javawebinar.topjava.MealTestData.*;


@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
@RunWith(SpringRunner.class)
@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
public class MealServiceTest extends TestCase {

    @Autowired
    private  MealService mealService;

    @Test
    public void testGet() {
        Meal actual = mealService.get(BREAKFAST_ID, ADMIN_ID);
             assertMatch(actual, meal_br_ADMIN);
    }

    @Test
    public void testDelete() {
        mealService.delete(BREAKFAST_ID, ADMIN_ID);
        assertThrows(NotFoundException.class, () -> mealService.get(BREAKFAST_ID,ADMIN_ID));
    }

    @Test
    public void testDeleteNotOwn() {
        assertThrows(NotFoundException.class, () -> mealService.delete(LUNCH_ID, USER_ID));
    }

    @Test
    public void testDeleteNotFound() {
        assertThrows(NotFoundException.class, () -> mealService.delete(NOT_FOUND, ADMIN_ID));
    }


    @Test
    public void testUpdate() {
        Meal updated = mealService.get(BREAKFAST_ID, ADMIN_ID);
        updated.setDescription("Some meal");
        updated.setDateTime(LocalDateTime.of(2000,10,10,10,0,0));

        mealService.update(updated, ADMIN_ID);

        assertMatch(mealService.get(meal_br_ADMIN.getId(), ADMIN_ID), updated);


    }

    @Test
    public void updateNotOwn() {
        assertThrows(NotFoundException.class, () -> mealService.update(meal_br_ADMIN, USER_ID));
    }

    @Test
    public void testCreate() {
        Meal created = mealService.create(MealTestData.getNewMeal(), MealTestData.ADMIN_ID);
        int createdId = created.getId();
        Meal expected = MealTestData.getNewMeal();
        expected.setId(createdId);
        MealTestData.assertMatch(created,expected);


    }

    @Test
    public void createMealDuplicateDate() {
        Meal duplicateDate = getNewMeal();
        duplicateDate.setDateTime(DATE_BREAKFAST);
        assertThrows(DuplicateKeyException.class, () -> mealService.create(duplicateDate, ADMIN_ID));
    }

    @Test
   public void getNotFound() {
               assertThrows(NotFoundException.class, () -> mealService.get(NOT_FOUND, USER_ID));
           }
}
package ru.javawebinar.topjava;

import ru.javawebinar.topjava.model.Meal;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static ru.javawebinar.topjava.model.AbstractBaseEntity.START_SEQ;

public class MealTestData {
    public static final int BREAKFAST_ID = START_SEQ;
    public static final int LUNCH_ID = BREAKFAST_ID + 1;
    public static final int DINNER_ID = LUNCH_ID + 1;
    public static final int NOT_FOUND = 10;
    public static final int ADMIN_ID = START_SEQ;
    public static final int USER_ID = ADMIN_ID + 1;
//    2022-10-10 11:30:30

//    ('2022-10-10 11:30:30', 'Breakfast', 200, 100000),
//            ('2022-10-10 14:30:00','Lunch', 500, 100000),
//            ('2022-10-10 19:30:00', 'Dinner', 1000, 100000),
//            ('2022-10-10 11:30:30', 'Breakfast', 200, 100001),
//            ('2022-10-10 14:30:00','Lunch', 500, 100001),
//            ('2022-10-10 19:30:00', 'Dinner', 1000, 100001);
    public static final LocalDateTime DATE_BREAKFAST = LocalDateTime.of(2022, 10, 10, 11, 30, 30);
    public static final LocalDateTime DATE_LUNCH = LocalDateTime.of(2022, 10, 10, 14, 30, 0);
    public static final LocalDateTime DATE_DINNER = LocalDateTime.of(2022, 10, 10, 19, 30, 0);

    public static final Meal meal_br_ADMIN = new Meal(BREAKFAST_ID,DATE_BREAKFAST, "Breakfast", 200);
    public static final Meal meal_lu_ADMIN = new Meal(LUNCH_ID, DATE_LUNCH, "Lunch", 500);
    public static final Meal meal_di_ADMIN = new Meal(DINNER_ID, DATE_DINNER, "Dinner", 1000);

    public static Meal getNewMeal() {
        return new Meal(null, LocalDateTime.of(2022,1,1,1,12,0), "Meal", 10);
    }

    public static Meal getUpdated() {
        Meal updated = new Meal(meal_br_ADMIN);
        updated.setCalories(10000);
        updated.setDescription("asdad");
        updated.setDateTime(LocalDateTime.MAX);
        return updated;
    }

    public static void assertMatch(Meal actual, Meal expected) {
        assertThat(actual).usingRecursiveComparison().isEqualTo(expected);
    }
}

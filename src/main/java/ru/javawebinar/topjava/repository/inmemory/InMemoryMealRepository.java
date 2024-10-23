package ru.javawebinar.topjava.repository.inmemory;

import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.repository.MealRepository;
import ru.javawebinar.topjava.util.MealsUtil;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

import static ru.javawebinar.topjava.repository.inmemory.InMemoryUserRepository.ADMIN_ID;
import static ru.javawebinar.topjava.repository.inmemory.InMemoryUserRepository.USER_ID;

@Repository
public class InMemoryMealRepository implements MealRepository {
    private final Map<Integer, Map<Integer, Meal>> usersMeaslMap = new ConcurrentHashMap<>();
    private final AtomicInteger counter = new AtomicInteger(0);
    {
        MealsUtil.meals.forEach(meal -> save(meal, USER_ID));
        save(new Meal(LocalDateTime.of(2015, Month.JUNE, 1, 14, 0), "Админ ланч", 510), ADMIN_ID);
        save(new Meal(LocalDateTime.of(2015, Month.JUNE, 1, 21, 0), "Админ ужин", 1500), ADMIN_ID);
    }

    @Override
    public Meal save(Meal meal, int userId) {
        // Получили список еды для пользователя (возможно пустой)
        Map<Integer, Meal> userMeals = usersMeaslMap.computeIfAbsent(userId, ConcurrentHashMap::new);

        if (meal.isNew()) {
            meal.setId(counter.incrementAndGet());
            userMeals.put(meal.getId(), meal);
            return meal;
            // Add meal for user
        }

        return userMeals.computeIfPresent(meal.getId(), (id, oldMeal) -> meal);
        // Update meal for user
    }

    @Override
    public boolean delete(int mealId, int userId) {
        Map<Integer, Meal> mealsForCurrentUser = usersMeaslMap.computeIfAbsent(userId, ConcurrentHashMap::new);

        if (mealsForCurrentUser.isEmpty() || mealsForCurrentUser.get(mealId).getUserId() != userId) {
            return false; // еда отсутствует или принадлежит чужому юзеру
        }

        mealsForCurrentUser.remove(mealId);
        return true;


    }

    @Override
    public Meal get(int id, int userId) {
       Map<Integer,Meal> meals = usersMeaslMap.get(userId);

       Meal forward = meals.get(id);

       return forward.getUserId() != userId ? null : forward;
    }

    @Override
    public List<Meal> getAll(int userId) {
        Map<Integer, Meal> meals = usersMeaslMap.get(userId);

        return CollectionUtils.isEmpty(meals) ? null :
                meals.values()
                        .stream()
                        .sorted(Comparator.comparing(Meal::getDateTime).reversed())
                        .collect(Collectors.toList());
    }

}


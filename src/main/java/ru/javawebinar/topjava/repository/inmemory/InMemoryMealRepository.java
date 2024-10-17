package ru.javawebinar.topjava.repository.inmemory;

import org.springframework.stereotype.Repository;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.repository.MealRepository;
import ru.javawebinar.topjava.util.MealsUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class InMemoryMealRepository implements MealRepository {
    private final Map<Integer, Meal> repository = new ConcurrentHashMap<>();
    private final AtomicInteger counter = new AtomicInteger(0);

    {
        MealsUtil.meals.forEach(this::save);
    }

    @Override
    public Meal save(Meal meal) {
        if (meal.isNew()) {
            meal.setId(counter.incrementAndGet());
            repository.put(meal.getId(), meal);
            return meal;
        }
        // handle case: update, but not present in storage
        return repository.computeIfPresent(meal.getId(), (id, oldMeal) -> meal);
    }


    @Override
    public Meal get(int id) {
        return repository.get(id);
    }

    @Override
    public Meal get(int id, int userId) {
        Meal currentMeal = repository.get(id);
        if (currentMeal == null || currentMeal.getUserId() != userId) {
            return null;
        }
        return currentMeal;

    }

    @Override
    public Collection<Meal> getAll() {
        return MealsUtil.orderedByDate(new ArrayList<>(repository.values()));
    }

    @Override
    public Meal save(Meal meal, int userId) {
        return null;

    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public boolean delete(int mealId, int userId) {
        return false;
    }
}


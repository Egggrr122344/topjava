package ru.javawebinar.topjava.dao;

import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.MealTo;
import ru.javawebinar.topjava.util.MealsUtil;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MealDAOImpl implements MealDAO {

    private List<Meal> meals;

    public MealDAOImpl() {
        meals = new ArrayList<>();
    }

    @Override
    public List<Meal> getAllMeal() {
        return meals;
    }

    @Override
    public Meal getMeal(int id) {
        return meals.stream()
                .filter(meal -> meal.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void addMeal(Meal meal) {
        meals.add(meal);
    }

    @Override
    public void deleteMeal(int id) {
        meals.removeIf(meal -> meal.getId() == id);
    }

    @Override
    public void updateMeal(Meal updatedMeal) {
        for (Meal meal: meals) {
            if (meal.getId() == updatedMeal.getId()) {
                meals.set(meals.indexOf(meal), updatedMeal);
                break;
            }
        }
    }
}

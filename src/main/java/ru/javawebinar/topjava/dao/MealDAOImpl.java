package ru.javawebinar.topjava.dao;

import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.MealTo;
import ru.javawebinar.topjava.util.MealsUtil;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class MealDAOImpl implements MealDAO {

    private final List<Meal> meals;

    public MealDAOImpl() {
        meals = new CopyOnWriteArrayList<>();
    }

    @Override
    public List<Meal> getAllMeal() {
        return new CopyOnWriteArrayList<>(meals);
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



    public void updateMeal(int id, LocalDateTime updatedDateTime, String updatedDescription, int updatedCal) {
        Meal currentMeal = getMeal(id);

        if (currentMeal == null) {
            throw new IllegalArgumentException("Meal with id " + id + " not found.");
        }

        // Обновляем свойства текущего блюда
        currentMeal.setDateTime(updatedDateTime);
        currentMeal.setDescription(updatedDescription);
        currentMeal.setCalories(updatedCal);

        // Здесь нет необходимости использовать meals.set()
        // так как мы напрямую изменили currentMeal
    }

}

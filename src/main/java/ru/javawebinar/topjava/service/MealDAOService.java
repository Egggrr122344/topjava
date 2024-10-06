package ru.javawebinar.topjava.service;

import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.MealTo;

import java.util.List;

public interface MealDAOService {
    List<Meal> getAllMeal();

    Meal getMeal(int id);

    void addMeal(Meal meal);

    void deleteMeal(int id);

    void updateMeal(Meal meal);

    List<MealTo> getAllMealTo(int calories);
}

package ru.javawebinar.topjava.dao;

import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.MealTo;

import java.time.LocalDateTime;
import java.util.List;

public interface MealDAO {

    List<Meal> getAllMeal();

    Meal getMeal(int id);

    void addMeal(Meal meal);

    void deleteMeal(int id);

    void updateMeal(int id, LocalDateTime updatedDateTime, String updatedDescription, int updatedCal);



}

package ru.javawebinar.topjava.service;

import ru.javawebinar.topjava.dao.MealDAO;
import ru.javawebinar.topjava.dao.MealDAOImpl;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.MealTo;
import ru.javawebinar.topjava.util.MealsUtil;

import java.util.List;

public class MealDAOServiceImpl implements MealDAOService{

    private  MealDAO mealDAO;

    public MealDAOServiceImpl() {
        mealDAO = new MealDAOImpl();
    }

    @Override
    public List<Meal> getAllMeal() {
        return mealDAO.getAllMeal();
    }

    @Override
    public Meal getMeal(int id) {
        return mealDAO.getMeal(id);
    }

    @Override
    public void addMeal(Meal meal) {
        mealDAO.addMeal(meal);
    }

    @Override
    public void deleteMeal(int id) {
        mealDAO.deleteMeal(id);
    }

    @Override
    public void updateMeal(Meal meal) {
        mealDAO.updateMeal(meal);
    }

    @Override
    public List<MealTo> getAllMealTo(int calories) {
        return MealsUtil.getMealToListFromMeal(mealDAO.getAllMeal(), calories);
    }
}

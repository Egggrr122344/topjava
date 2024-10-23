package ru.javawebinar.topjava.web.meal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.service.MealService;
import ru.javawebinar.topjava.to.MealTo;
import ru.javawebinar.topjava.util.MealsUtil;
import ru.javawebinar.topjava.util.ValidationUtil;
import ru.javawebinar.topjava.web.SecurityUtil;

import java.util.List;

@Controller
public class MealRestController {
    private final MealService service;

    public MealRestController(MealService service) {
        this.service = service;
    }


    public Meal create(Meal meal) {
        int id = SecurityUtil.authUserId();
        ValidationUtil.checkNew(meal);
        return service.create(meal, id);
    }

    public List<MealTo> getAll() {
        int id = SecurityUtil.authUserId();
        return MealsUtil.getTos(service.getAll(id), SecurityUtil.authUserCaloriesPerDay());
    }


    public Meal get(int id) {
        return service.get(id, SecurityUtil.authUserId());
    }

    public void delete(int id) {
        service.delete(id, SecurityUtil.authUserId());
    }

    public void update(Meal meal) {
        service.update(meal, SecurityUtil.authUserId());
    }


}
package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.MealTo;
import ru.javawebinar.topjava.util.MealsUtil;
import ru.javawebinar.topjava.util.TimeUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

public class MealServlet extends HttpServlet {

    private static final Logger log = getLogger(MealServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Meal> meals1 = Arrays.asList(
                new Meal(LocalDateTime.of(2024, 12, 13, 12 ,0), "Breakfast", 400),
                new Meal(LocalDateTime.of(2024, 12, 13, 13 ,0), "Lunch", 500),
                new Meal(LocalDateTime.of(2024, 12, 13, 14 ,0), "Dinner", 600)
        );


        final int sumCaloriesByDay = meals1.stream().mapToInt(Meal::getCalories).sum();
        final int  caloriesPerDay = 600;
        List<MealTo> mealTos = new ArrayList<>();

        for (Meal meal: meals1) {

            mealTos.add(new MealTo(meal.getDateTime(), meal.getDescription(), meal.getCalories(), sumCaloriesByDay > caloriesPerDay));
        }

        log.debug("redirect to meals");

        req.setAttribute("listMealTo", mealTos);

        req.getRequestDispatcher("/meal.jsp").forward(req,resp);




    }
}

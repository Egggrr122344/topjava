package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.service.MealDAOService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

import static org.slf4j.LoggerFactory.getLogger;

public class AddMealServlet extends HttpServlet {

    private static final Logger log = getLogger(AddMealServlet.class);
    private MealDAOService service;

    @Override
    public void init() throws ServletException {
        final Object ObjectService = getServletContext().getAttribute("service");

        service = (MealDAOService) ObjectService;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // Для получения параметров из таблицы

        final LocalDateTime dateTime = LocalDateTime.parse(req.getParameter("mealDateTime"));

        final String description = req.getParameter("mealDescription");

        final int calories = Integer.parseInt(req.getParameter("mealCalories")

        );

        Meal meal = new Meal(dateTime, description, calories);
        System.out.println("Добавлена еда с ид " + meal.getId());
        service.addMeal(meal);

        resp.sendRedirect(req.getContextPath() + "/meals");


    }
}

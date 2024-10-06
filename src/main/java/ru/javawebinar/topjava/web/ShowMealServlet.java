package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.service.MealDAOService;
import ru.javawebinar.topjava.service.MealDAOServiceImpl;
import ru.javawebinar.topjava.util.MealsUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

public class ShowMealServlet extends HttpServlet {

    private static final Logger log = getLogger(ShowMealServlet.class);
    private MealDAOService mealDAOService;
    final int caloriesLimit = 2000;

    @Override
    public void init() throws ServletException {
        log.debug("init ShowMeal Servlet");
        this.mealDAOService = new MealDAOServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        log.debug("redirect List<MealTo> to show on JSP page meal.jsp");

        req.setAttribute("listMealTo", mealDAOService.getAllMealTo(caloriesLimit));

        req.getRequestDispatcher("/meal.jsp").forward(req,resp);


    }
}

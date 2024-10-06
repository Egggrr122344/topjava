package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.service.MealDAOService;
import ru.javawebinar.topjava.service.MealDAOServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

import static org.slf4j.LoggerFactory.getLogger;

public class AddOrUpdateServlet extends HttpServlet {

    private MealDAOService mealDAOService;
    private static final Logger log = getLogger(ShowMealServlet.class);

    @Override
    public void init() throws ServletException {
        mealDAOService = new MealDAOServiceImpl();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if ("add".equals(action)) {
            log.debug("redirect to add Meals JSP");
            req.getRequestDispatcher("/editMeals.jsp").forward(req,resp);
        } else if ("delete".equals(action)) {
            log.debug("get id for delete and send redirect");
            int id = Integer.parseInt(req.getParameter("id"));

            mealDAOService.deleteMeal(id);

            resp.sendRedirect("meal");

        } else if ("update".equals(action)) {

            log.debug("redirect to edit Meals JSP");

            int id = Integer.parseInt(req.getParameter("id"));

            Meal meal = mealDAOService.getMeal(id);

            req.setAttribute("mealForEdit", meal);

            req.getRequestDispatcher("/editMeals.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        String description = req.getParameter("description");
        int calories = Integer.parseInt(req.getParameter("calories"));
        LocalDateTime localDateTime = LocalDateTime.parse(req.getParameter("dateTime"));

        if ("add".equals(action)) {
            // Добавляем новое блюдо
            Meal newMeal = new Meal(0, localDateTime, description, calories);
            mealDAOService.addMeal(newMeal);
        } else if ("update".equals(action)) {
            // Обновляем существующее блюдо
            int id = Integer.parseInt(req.getParameter("id"));
            Meal updatedMeal = new Meal(id, localDateTime, description, calories);
            mealDAOService.updateMeal(updatedMeal);
        }

        // Перенаправляем обратно на страницу со списком блюд
        resp.sendRedirect("meals");

    }


}

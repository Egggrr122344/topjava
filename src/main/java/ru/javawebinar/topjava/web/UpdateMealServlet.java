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

public class UpdateMealServlet extends HttpServlet {

    private static final Logger log = getLogger(UpdateMealServlet.class);
    private  MealDAOService service;

    @Override
    public void init() throws ServletException {
        service =(MealDAOService) getServletContext().getAttribute("service");
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Улетаем на страницу с формой (летит id)
        int id = Integer.parseInt(req.getParameter("id"));
        System.out.println("Прилетел id для изменения " + id);

        // Получаем нашу meal по id
        Meal forUpdateMeal = service.getMeal(id);
        req.setAttribute("forUpdateMeal", forUpdateMeal);

        req.getRequestDispatcher("/editMeals.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Получаем данные из формы заполнения

        int id = Integer.parseInt(req.getParameter("id"));
        System.out.println("ид для изменения " + id);
        LocalDateTime dateTime = LocalDateTime.parse(req.getParameter("dateTime"));
        String description = req.getParameter("description");
        int calories = Integer.parseInt(req.getParameter("calories"));

        service.updateMeal(id, dateTime, description, calories);

        resp.sendRedirect(req.getContextPath() + "/meals");
    }


}

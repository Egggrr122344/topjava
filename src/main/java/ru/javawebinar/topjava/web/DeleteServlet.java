package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import ru.javawebinar.topjava.service.MealDAOService;
import ru.javawebinar.topjava.service.MealDAOServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.slf4j.LoggerFactory.getLogger;

public class DeleteServlet extends HttpServlet {

    private MealDAOService mealDAOService;
    private static final Logger log = getLogger(DeleteServlet.class);

    @Override
    public void init() throws ServletException {
        log.debug("init delete servlet");
        mealDAOService = (MealDAOService) getServletContext().getAttribute("service");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int mealId = Integer.parseInt(req.getParameter("mealId"));
        System.out.println("Прилетел id для удаления " + mealId);
        mealDAOService.deleteMeal(mealId);
        log.debug("delete meal and redirect to meals.jsp");
        resp.sendRedirect(req.getContextPath() + "/meals");
    }



}

package ru.javawebinar.topjava.web.ServletListener;

import ru.javawebinar.topjava.service.MealDAOService;
import ru.javawebinar.topjava.service.MealDAOServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ServletConfigListener implements ServletContextListener {

    private MealDAOService mealDAOService;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();

        mealDAOService = new MealDAOServiceImpl();

        servletContext.setAttribute("service", mealDAOService);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        mealDAOService = null;
    }
}

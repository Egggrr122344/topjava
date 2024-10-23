package ru.javawebinar.topjava.web;

import static ru.javawebinar.topjava.util.MealsUtil.DEFAULT_CALORIES_PER_DAY;

public class SecurityUtil {

    private static int AUTH_USER_ID;

    public static int authUserId() {
        return AUTH_USER_ID;
    }

    public static void setAuthUserId(int authUserId) {
        AUTH_USER_ID = authUserId;
    }

    public static int authUserCaloriesPerDay() {
        return DEFAULT_CALORIES_PER_DAY;
    }
}
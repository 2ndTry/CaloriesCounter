package com.alexeymiroshnikov.caloriescounter.util;

import com.alexeymiroshnikov.caloriescounter.model.UserMeal;
import com.alexeymiroshnikov.caloriescounter.model.UserMealWithExcess;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.*;

public class UserMealsUtil {

    public static void main(String[] args) {
        List<UserMeal> meals = Arrays.asList(
            new UserMeal(LocalDateTime.of(2021, Month.JANUARY, 30, 7, 0), "Завтрак", 500),
            new UserMeal(LocalDateTime.of(2021, Month.JANUARY, 30, 13, 0), "Обед", 700),
            new UserMeal(LocalDateTime.of(2021, Month.JANUARY, 30, 19, 0), "Ужин", 800),
            new UserMeal(LocalDateTime.of(2021, Month.JANUARY, 31, 0, 0), "Еда на граничное значение", 100),
            new UserMeal(LocalDateTime.of(2021, Month.JANUARY, 31, 8, 0), "Завтрак", 500),
            new UserMeal(LocalDateTime.of(2021, Month.JANUARY, 31, 14,30), "Обед", 1010),
            new UserMeal(LocalDateTime.of(2021, Month.JANUARY, 31, 19,0), "Ужин", 500)
        );

        List<UserMealWithExcess> mealsTo = filteredByCycles(meals, LocalTime.of(7,0), LocalTime.of(23,0), 2000);
        mealsTo.forEach(System.out::println);
    }

    public static List<UserMealWithExcess> filteredByCycles(List<UserMeal> meals, LocalTime startTime, LocalTime endTime, int caloriesPerDay) {
        Map<LocalDate, Integer> caloriesByDay = new HashMap<>();
        for (UserMeal meal : meals) {
            LocalDate mealDate = meal.getDateTime().toLocalDate();
            caloriesByDay.put(mealDate, caloriesByDay.getOrDefault(mealDate, 0) + meal.getCalories());
        }
        List<UserMealWithExcess> mealWithExcesses = new ArrayList<>();
        for(UserMeal meal : meals) {
            LocalDateTime dateTime = meal.getDateTime();
            if(TimeUtil.isBetweenHalfOpen(dateTime.toLocalTime(), startTime, endTime)) {
                mealWithExcesses.add(new UserMealWithExcess(dateTime, meal.getDescription(), meal.getCalories(), caloriesByDay
                        .get(dateTime.toLocalDate()) > caloriesPerDay));
            }
        }
        return mealWithExcesses;
    }
}

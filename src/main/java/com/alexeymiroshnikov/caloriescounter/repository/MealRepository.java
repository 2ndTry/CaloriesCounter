package com.alexeymiroshnikov.caloriescounter.repository;

import com.alexeymiroshnikov.caloriescounter.model.Meal;

import java.util.Collection;

public interface MealRepository {

    Meal save(Meal meal);

    boolean delete(int id);

    Meal get(int id);

    Collection<Meal> getAll();
}

package com.example.abdelrahmansaleh.mealmvp.ui.detailsActivity;

import com.example.abdelrahmansaleh.mealmvp.data.model.meal.MealData;

public interface DetailView {
    void showLoadingMeal();

    void hideLoadingMeal();

    void setMeal(MealData mealData);

    void onErrorLoading(String tittle, String message);
}

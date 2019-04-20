package com.example.abdelrahmansaleh.mealmvp.ui.categoryActivity;

import com.example.abdelrahmansaleh.mealmvp.data.model.meal.MealData;


import java.util.List;

public interface CategoryView {
    void showLoading();

    void hideLoading();

    void setMeals(List<MealData> meals);

    void onErrorLoading(String tittle, String message);
}

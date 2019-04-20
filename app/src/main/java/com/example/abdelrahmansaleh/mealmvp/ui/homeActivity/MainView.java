package com.example.abdelrahmansaleh.mealmvp.ui.homeActivity;

import com.example.abdelrahmansaleh.mealmvp.data.model.category.CategoryData;
import com.example.abdelrahmansaleh.mealmvp.data.model.meal.MealData;

import java.util.List;

public interface MainView {
    void showLoadingMeal();

    void hideLoadingMeal();

    void showLoadingCategory();

    void hideLoadingCategory();

    void setMeal(List<MealData> mealData);

    void setCategory(List<CategoryData> categoryData);

    void onError(String title, String message);
}

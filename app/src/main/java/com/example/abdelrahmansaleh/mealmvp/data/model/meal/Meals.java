
package com.example.abdelrahmansaleh.mealmvp.data.model.meal;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Meals {

    @SerializedName("meals")
    @Expose
    private List<MealData> meals = null;

    public List<MealData> getMeals() {
        return meals;
    }

    public void setMeals(List<MealData> meals) {
        this.meals = meals;
    }

}

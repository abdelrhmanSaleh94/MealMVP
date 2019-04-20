package com.example.abdelrahmansaleh.mealmvp.data.rest;

import com.example.abdelrahmansaleh.mealmvp.data.model.category.Category;
import com.example.abdelrahmansaleh.mealmvp.data.model.meal.Meals;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("latest.php")
    Call<Meals> MEALS_CALL1();

    @GET("categories.php")
    Call<Category> CATEGORY_CALL();


    @GET("filter.php")
    Call<Meals> MEALS_BY_CATEGORY_CALL1(@Query("c") String category);

    @GET("search.php")
    Call<Meals> MEALS_BY_NAME_CALL(@Query("s") String mealName);
}

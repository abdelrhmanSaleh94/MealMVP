package com.example.abdelrahmansaleh.mealmvp.ui.categoryActivity;

import com.example.abdelrahmansaleh.mealmvp.data.model.meal.Meals;
import com.example.abdelrahmansaleh.mealmvp.data.rest.ApiService;
import com.example.abdelrahmansaleh.mealmvp.data.rest.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryPresenter {
    private CategoryView categoryView;
   private ApiService apiService;

    public CategoryPresenter(CategoryView categoryView) {
        this.categoryView = categoryView;
        apiService = RetrofitClient.getClient().create( ApiService.class );
    }

    void getCategoryMeal(String category) {
        categoryView.showLoading();
        apiService.MEALS_BY_CATEGORY_CALL1( category ).enqueue( new Callback<Meals>() {
            @Override
            public void onResponse(Call<Meals> call, Response<Meals> response) {
                if (response.body() != null && response.isSuccessful()) {
                    categoryView.setMeals( response.body().getMeals() );
                    categoryView.hideLoading();
                } else {
                    categoryView.onErrorLoading( "Food APP", "request Error " );
                    categoryView.hideLoading();
                }
            }

            @Override
            public void onFailure(Call<Meals> call, Throwable t) {
                categoryView.onErrorLoading( "Food APP ", t.getLocalizedMessage() );
                categoryView.hideLoading();
            }
        } );
    }
}

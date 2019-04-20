package com.example.abdelrahmansaleh.mealmvp.ui.homeActivity;

import android.widget.Toast;

import com.example.abdelrahmansaleh.mealmvp.data.model.category.Category;
import com.example.abdelrahmansaleh.mealmvp.data.model.category.CategoryData;
import com.example.abdelrahmansaleh.mealmvp.data.model.meal.Meals;
import com.example.abdelrahmansaleh.mealmvp.data.rest.ApiService;
import com.example.abdelrahmansaleh.mealmvp.data.rest.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter {
    private MainView view;
    ApiService apiService;

    public MainPresenter(MainView view) {
        this.view = view;
        apiService = RetrofitClient.getClient().create( ApiService.class );
    }

    void getMeal() {
        view.showLoadingMeal();
        apiService.MEALS_CALL1().enqueue( new Callback<Meals>() {
            @Override
            public void onResponse(Call<Meals> call, Response<Meals> response) {
                if (response.isSuccessful() && response.body() != null) {
                    view.setMeal( response.body().getMeals() );
                    view.hideLoadingMeal();
                } else {
                    view.onError( "Food APP", "request Error " );
                }
            }

            @Override
            public void onFailure(Call<Meals> call, Throwable t) {
                view.onError( "Food APP ", t.getLocalizedMessage() );
            }
        } );
    }

    void getCategories() {
        view.showLoadingCategory();
        apiService.CATEGORY_CALL().enqueue( new Callback<Category>() {
            @Override
            public void onResponse(Call<Category> call, Response<Category> response) {
                if (response.body() != null && response.isSuccessful()) {
                    List<CategoryData> categoryList = new ArrayList<>();
                    List<CategoryData> categories = response.body().getCategories();
                    for (int i = 0; i < categories.size(); i++) {
                        if (!categories.get( i ).getStrCategory().equals( "Pork" )) {
                            categoryList.add( categories.get( i ) );
                        }
                    }
                    view.setCategory( categoryList );
                    view.hideLoadingCategory();
                } else {
                    view.onError( "Food APP", "request Error " );
                }
            }

            @Override
            public void onFailure(Call<Category> call, Throwable t) {
                view.onError( "Food APP ", t.getLocalizedMessage() );
            }
        } );
    }
}

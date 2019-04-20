package com.example.abdelrahmansaleh.mealmvp.ui.detailsActivity;

import com.example.abdelrahmansaleh.mealmvp.data.model.meal.Meals;
import com.example.abdelrahmansaleh.mealmvp.data.rest.ApiService;
import com.example.abdelrahmansaleh.mealmvp.data.rest.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailPresenter {
    private ApiService apiService;
    private DetailView detailView;

    public DetailPresenter(DetailView detailView) {
        this.detailView = detailView;
        apiService = RetrofitClient.getClient().create( ApiService.class );
    }

    public void getMealByName(String mealName) {
        detailView.showLoadingMeal();
        apiService.MEALS_BY_NAME_CALL( mealName ).enqueue( new Callback<Meals>() {
            @Override
            public void onResponse(Call<Meals> call, Response<Meals> response) {
                if (response.isSuccessful() && response.body() != null) {
                    detailView.setMeal( response.body().getMeals().get( 0 ) );
                    detailView.hideLoadingMeal();
                } else {
                    detailView.onErrorLoading( "Food APP", "no Response" );
                    detailView.hideLoadingMeal();
                }
            }

            @Override
            public void onFailure(Call<Meals> call, Throwable t) {
                detailView.onErrorLoading( "Food APP", t.getLocalizedMessage() );
                detailView.hideLoadingMeal();
            }
        } );
    }

}

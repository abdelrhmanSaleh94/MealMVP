package com.example.abdelrahmansaleh.mealmvp.ui.detailsActivity;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.abdelrahmansaleh.mealmvp.data.model.meal.MealData;
import com.example.abdelrahmansaleh.mealmvp.R;
import com.example.abdelrahmansaleh.mealmvp.helper.Conestant;
import com.example.abdelrahmansaleh.mealmvp.helper.HelperMethods;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends AppCompatActivity implements DetailView {

    @BindView(R.id.mealThumb)
    ImageView mealThumb;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbar;
    @BindView(R.id.appbar)
    AppBarLayout appbar;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.textCategory)
    TextView textCategory;
    @BindView(R.id.category)
    TextView category;
    @BindView(R.id.Country)
    TextView Country;
    @BindView(R.id.country)
    TextView country;
    @BindView(R.id.instructions)
    TextView instructions;
    @BindView(R.id.ingredient)
    TextView ingredient;
    @BindView(R.id.measure)
    TextView measure;
    @BindView(R.id.youtube)
    TextView youtube;
    @BindView(R.id.source)
    TextView source;
    DetailPresenter detailPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_detail );
        ButterKnife.bind( this );
        setupActionBar();
        detailPresenter = new DetailPresenter( this );
        Intent intent = getIntent();
        String mealName = intent.getStringExtra( Conestant.EXTRA_DATA_DETAILS );
        detailPresenter.getMealByName( mealName );
    }

    private void setupActionBar() {
        setSupportActionBar( toolbar );
        collapsingToolbar.setContentScrimColor( getResources().getColor( R.color.colorWhite ) );
        collapsingToolbar.setCollapsedTitleTextColor( getResources().getColor( R.color.colorPrimary ) );
        collapsingToolbar.setExpandedTitleColor( getResources().getColor( R.color.colorWhite ) );
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled( true );
        }
    }

    @Override
    public void showLoadingMeal() {
        progressBar.setVisibility( View.VISIBLE );
    }

    @Override
    public void hideLoadingMeal() {
        progressBar.setVisibility( View.GONE );

    }

    @Override
    public void setMeal(MealData mealData) {
        HelperMethods.useGlide( getApplicationContext(), mealThumb, mealData.getStrMealThumb() );
        collapsingToolbar.setTitle( mealData.getStrMeal() );
        category.setText( mealData.getStrCategory() );
        country.setText( mealData.getStrArea() );
        instructions.setText( mealData.getStrInstructions() );
        setupActionBar();

        if (!mealData.getStrIngredient1().isEmpty()) {
            ingredient.append( "\n \u2022 " + mealData.getStrIngredient1() );
        }
        if (!mealData.getStrIngredient2().isEmpty()) {
            ingredient.append( "\n \u2022 " + mealData.getStrIngredient2() );
        }
        if (!mealData.getStrIngredient3().isEmpty()) {
            ingredient.append( "\n \u2022 " + mealData.getStrIngredient3() );
        }
        if (!mealData.getStrIngredient4().isEmpty()) {
            ingredient.append( "\n \u2022 " + mealData.getStrIngredient4() );
        }
        if (!mealData.getStrIngredient5().isEmpty()) {
            ingredient.append( "\n \u2022 " + mealData.getStrIngredient5() );
        }
        if (!mealData.getStrIngredient6().isEmpty()) {
            ingredient.append( "\n \u2022 " + mealData.getStrIngredient6() );
        }
        if (!mealData.getStrIngredient7().isEmpty()) {
            ingredient.append( "\n \u2022 " + mealData.getStrIngredient7() );
        }
        if (!mealData.getStrIngredient8().isEmpty()) {
            ingredient.append( "\n \u2022 " + mealData.getStrIngredient8() );
        }
        if (!mealData.getStrIngredient9().isEmpty()) {
            ingredient.append( "\n \u2022 " + mealData.getStrIngredient9() );
        }
        if (!mealData.getStrIngredient10().isEmpty()) {
            ingredient.append( "\n \u2022 " + mealData.getStrIngredient10() );
        }
        if (!mealData.getStrIngredient11().isEmpty()) {
            ingredient.append( "\n \u2022 " + mealData.getStrIngredient11() );
        }
        if (!mealData.getStrIngredient12().isEmpty()) {
            ingredient.append( "\n \u2022 " + mealData.getStrIngredient12() );
        }
        if (!mealData.getStrIngredient13().isEmpty()) {
            ingredient.append( "\n \u2022 " + mealData.getStrIngredient13() );
        }
        if (!mealData.getStrIngredient14().isEmpty()) {
            ingredient.append( "\n \u2022 " + mealData.getStrIngredient14() );
        }
        if (!mealData.getStrIngredient15().isEmpty()) {
            ingredient.append( "\n \u2022 " + mealData.getStrIngredient15() );
        }
        if (!mealData.getStrIngredient16().isEmpty()) {
            ingredient.append( "\n \u2022 " + mealData.getStrIngredient16() );
        }
        if (!mealData.getStrIngredient17().isEmpty()) {
            ingredient.append( "\n \u2022 " + mealData.getStrIngredient17() );
        }
        if (!mealData.getStrIngredient18().isEmpty()) {
            ingredient.append( "\n \u2022 " + mealData.getStrIngredient18() );
        }
        if (!mealData.getStrIngredient19().isEmpty()) {
            ingredient.append( "\n \u2022 " + mealData.getStrIngredient19() );
        }
        if (!mealData.getStrIngredient20().isEmpty()) {
            ingredient.append( "\n \u2022 " + mealData.getStrIngredient20() );
        }

        if (!mealData.getStrMeasure1().isEmpty() && !Character.isWhitespace( mealData.getStrMeasure1().charAt( 0 ) )) {
            measure.append( "\n : " + mealData.getStrMeasure1() );
        }
        if (!mealData.getStrMeasure2().isEmpty() && !Character.isWhitespace( mealData.getStrMeasure2().charAt( 0 ) )) {
            measure.append( "\n : " + mealData.getStrMeasure2() );
        }
        if (!mealData.getStrMeasure3().isEmpty() && !Character.isWhitespace( mealData.getStrMeasure3().charAt( 0 ) )) {
            measure.append( "\n : " + mealData.getStrMeasure3() );
        }
        if (!mealData.getStrMeasure4().isEmpty() && !Character.isWhitespace( mealData.getStrMeasure4().charAt( 0 ) )) {
            measure.append( "\n : " + mealData.getStrMeasure4() );
        }
        if (!mealData.getStrMeasure5().isEmpty() && !Character.isWhitespace( mealData.getStrMeasure5().charAt( 0 ) )) {
            measure.append( "\n : " + mealData.getStrMeasure5() );
        }
        if (!mealData.getStrMeasure6().isEmpty() && !Character.isWhitespace( mealData.getStrMeasure6().charAt( 0 ) )) {
            measure.append( "\n : " + mealData.getStrMeasure6() );
        }
        if (!mealData.getStrMeasure7().isEmpty() && !Character.isWhitespace( mealData.getStrMeasure7().charAt( 0 ) )) {
            measure.append( "\n : " + mealData.getStrMeasure7() );
        }
        if (!mealData.getStrMeasure8().isEmpty() && !Character.isWhitespace( mealData.getStrMeasure8().charAt( 0 ) )) {
            measure.append( "\n : " + mealData.getStrMeasure8() );
        }
        if (!mealData.getStrMeasure9().isEmpty() && !Character.isWhitespace( mealData.getStrMeasure9().charAt( 0 ) )) {
            measure.append( "\n : " + mealData.getStrMeasure9() );
        }
        if (!mealData.getStrMeasure10().isEmpty() && !Character.isWhitespace( mealData.getStrMeasure10().charAt( 0 ) )) {
            measure.append( "\n : " + mealData.getStrMeasure10() );
        }
        if (!mealData.getStrMeasure11().isEmpty() && !Character.isWhitespace( mealData.getStrMeasure11().charAt( 0 ) )) {
            measure.append( "\n : " + mealData.getStrMeasure11() );
        }
        if (!mealData.getStrMeasure12().isEmpty() && !Character.isWhitespace( mealData.getStrMeasure12().charAt( 0 ) )) {
            measure.append( "\n : " + mealData.getStrMeasure12() );
        }
        if (!mealData.getStrMeasure13().isEmpty() && !Character.isWhitespace( mealData.getStrMeasure13().charAt( 0 ) )) {
            measure.append( "\n : " + mealData.getStrMeasure13() );
        }
        if (!mealData.getStrMeasure14().isEmpty() && !Character.isWhitespace( mealData.getStrMeasure14().charAt( 0 ) )) {
            measure.append( "\n : " + mealData.getStrMeasure14() );
        }
        if (!mealData.getStrMeasure15().isEmpty() && !Character.isWhitespace( mealData.getStrMeasure15().charAt( 0 ) )) {
            measure.append( "\n : " + mealData.getStrMeasure15() );
        }
        if (!mealData.getStrMeasure16().isEmpty() && !Character.isWhitespace( mealData.getStrMeasure16().charAt( 0 ) )) {
            measure.append( "\n : " + mealData.getStrMeasure16() );
        }
        if (!mealData.getStrMeasure17().isEmpty() && !Character.isWhitespace( mealData.getStrMeasure17().charAt( 0 ) )) {
            measure.append( "\n : " + mealData.getStrMeasure17() );
        }
        if (!mealData.getStrMeasure18().isEmpty() && !Character.isWhitespace( mealData.getStrMeasure18().charAt( 0 ) )) {
            measure.append( "\n : " + mealData.getStrMeasure18() );
        }
        if (!mealData.getStrMeasure19().isEmpty() && !Character.isWhitespace( mealData.getStrMeasure19().charAt( 0 ) )) {
            measure.append( "\n : " + mealData.getStrMeasure19() );
        }
        if (!mealData.getStrMeasure20().isEmpty() && !Character.isWhitespace( mealData.getStrMeasure20().charAt( 0 ) )) {
            measure.append( "\n : " + mealData.getStrMeasure20() );
        }
        if (!mealData.getStrYoutube().isEmpty()) {
            youtube.setOnClickListener( v -> {
                Intent intentYoutube = new Intent( Intent.ACTION_VIEW );
                intentYoutube.setData( Uri.parse( mealData.getStrYoutube() ) );
                startActivity( intentYoutube );
            } );
        } else {
            youtube.setVisibility( View.GONE );
        }
        if (!mealData.getStrSource().isEmpty()) {
            source.setOnClickListener( v -> {
                Intent intentSource = new Intent( Intent.ACTION_VIEW );
                intentSource.setData( Uri.parse( mealData.getStrSource() ) );
                startActivity( intentSource );
            } );
        } else {
            source.setVisibility( View.GONE );
        }

    }



    @Override
    public void onErrorLoading(String tittle, String message) {

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected( item );
        }
    }

    void setupColorActionBarIcon(Drawable favoriteItemColor) {
        appbar.addOnOffsetChangedListener( (appBarLayout, verticalOffset) -> {
            if ((collapsingToolbar.getHeight() + verticalOffset) < (2 * ViewCompat.getMinimumHeight( collapsingToolbar ))) {
                if (toolbar.getNavigationIcon() != null)
                    toolbar.getNavigationIcon().setColorFilter( getResources().getColor( R.color.colorPrimary ), PorterDuff.Mode.SRC_ATOP );
                favoriteItemColor.mutate().setColorFilter( getResources().getColor( R.color.colorPrimary ),
                        PorterDuff.Mode.SRC_ATOP );

            } else {
                if (toolbar.getNavigationIcon() != null)
                    toolbar.getNavigationIcon().setColorFilter( getResources().getColor( R.color.colorWhite ), PorterDuff.Mode.SRC_ATOP );
                favoriteItemColor.mutate().setColorFilter( getResources().getColor( R.color.colorWhite ),
                        PorterDuff.Mode.SRC_ATOP );
            }
        } );
    }
}

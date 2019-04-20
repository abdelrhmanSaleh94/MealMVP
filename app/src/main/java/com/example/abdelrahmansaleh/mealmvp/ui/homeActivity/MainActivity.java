package com.example.abdelrahmansaleh.mealmvp.ui.homeActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.abdelrahmansaleh.mealmvp.R;
import com.example.abdelrahmansaleh.mealmvp.adpter.CategoryAdapter;
import com.example.abdelrahmansaleh.mealmvp.adpter.ViewPagerHeaderAdapter;
import com.example.abdelrahmansaleh.mealmvp.data.model.category.CategoryData;
import com.example.abdelrahmansaleh.mealmvp.data.model.meal.MealData;
import com.example.abdelrahmansaleh.mealmvp.helper.Conestant;
import com.example.abdelrahmansaleh.mealmvp.ui.categoryActivity.CategoryActivity;
import com.example.abdelrahmansaleh.mealmvp.ui.detailsActivity.DetailActivity;

import java.io.Serializable;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.abdelrahmansaleh.mealmvp.helper.Conestant.EXTRA_CATEGORY;
import static com.example.abdelrahmansaleh.mealmvp.helper.Conestant.EXTRA_POSITION;

public class MainActivity extends AppCompatActivity implements MainView {

    @BindView(R.id.viewPagerHeader)
    ViewPager viewPagerHeader;
    @BindView(R.id.recyclerCategory)
    RecyclerView recyclerCategory;
    MainPresenter presenter;
    int currentPage = 0;
    Timer timer;
    final long DELAY_MS = 500;//delay in milliseconds before task is to be executed
    final long PERIOD_MS = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        ButterKnife.bind( this );
        presenter = new MainPresenter( this );
        presenter.getMeal();
        presenter.getCategories();
    }

    @Override
    public void showLoadingMeal() {
        findViewById( R.id.shimmerMeal ).setVisibility( View.VISIBLE );
    }

    @Override
    public void hideLoadingMeal() {
        findViewById( R.id.shimmerMeal ).setVisibility( View.GONE );
    }

    @Override
    public void showLoadingCategory() {
        findViewById( R.id.shimmerCategory ).setVisibility( View.VISIBLE );
    }

    @Override
    public void hideLoadingCategory() {
        findViewById( R.id.shimmerCategory ).setVisibility( View.GONE );

    }

    @Override
    public void setMeal(List<MealData> mealData) {
        ViewPagerHeaderAdapter headerAdapter = new ViewPagerHeaderAdapter( mealData, this );
        viewPagerHeader.setAdapter( headerAdapter );
        //for small item
        viewPagerHeader.setPadding( 20, 0, 150, 0 );
        headerAdapter.setOnItemClickListener( new ViewPagerHeaderAdapter.ClickListener() {
            @Override
            public void onClick(View v, int position) {
                Intent intent = new Intent( getApplicationContext(), DetailActivity.class );
                intent.putExtra( Conestant.EXTRA_DATA_DETAILS, mealData.get( position ).getStrMeal() );
                startActivity( intent );
            }
        } );
        headerAdapter.notifyDataSetChanged();

        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == headerAdapter.getCount()) {
                    currentPage = 0;
                }
                viewPagerHeader.setCurrentItem( currentPage++, true );
            }
        };

        timer = new Timer(); // This will create a new Thread
        timer.schedule( new TimerTask() { // task to be scheduled
            @Override
            public void run() {
                handler.post( Update );
            }
        }, DELAY_MS, PERIOD_MS );

    }

    @Override
    public void setCategory(List<CategoryData> categoryData) {
        GridLayoutManager manager = new GridLayoutManager( this, 3, GridLayoutManager.VERTICAL, false );
        recyclerCategory.setLayoutManager( manager );
        CategoryAdapter categoryAdapter = new CategoryAdapter( this, categoryData );
        recyclerCategory.setAdapter( categoryAdapter );
        recyclerCategory.setNestedScrollingEnabled( true );
        categoryAdapter.setOnItemClickListener( new CategoryAdapter.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent intent = new Intent( MainActivity.this, CategoryActivity.class );
                intent.putExtra( EXTRA_CATEGORY, (Serializable) categoryData );
                intent.putExtra( EXTRA_POSITION, position );
                startActivity( intent );
            }
        } );
        categoryAdapter.notifyDataSetChanged();

    }

    @Override
    public void onError(String title, String message) {

    }
}

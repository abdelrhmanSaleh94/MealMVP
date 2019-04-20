package com.example.abdelrahmansaleh.mealmvp.ui.categoryActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.abdelrahmansaleh.mealmvp.R;
import com.example.abdelrahmansaleh.mealmvp.adpter.ViewPagerCategoryAdapter;
import com.example.abdelrahmansaleh.mealmvp.data.model.category.CategoryData;
import com.example.abdelrahmansaleh.mealmvp.helper.Conestant;

import java.io.Serializable;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CategoryActivity extends AppCompatActivity {

    @BindView(R.id.categoryActToolbar)
    Toolbar categoryActToolbar;
    @BindView(R.id.categoryActTabLayout)
    TabLayout categoryActTabLayout;
    @BindView(R.id.appbar)
    AppBarLayout appbar;
    @BindView(R.id.categoryActViewPager)
    ViewPager categoryActViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_category );
        ButterKnife.bind( this );
        initActionBar();
        iniIntent();
    }

    private void iniIntent() {
        Intent intent = getIntent();
        List<CategoryData> categoryList = (List<CategoryData>) intent.getSerializableExtra( Conestant.EXTRA_CATEGORY );
        int position = intent.getIntExtra( Conestant.EXTRA_POSITION, 0 );
        ViewPagerCategoryAdapter categoryAdapter = new ViewPagerCategoryAdapter( getSupportFragmentManager(), categoryList );
        categoryActViewPager.setOffscreenPageLimit( 1 );
        categoryActViewPager.setAdapter( categoryAdapter );
        categoryActTabLayout.setupWithViewPager( categoryActViewPager );
        categoryActViewPager.setCurrentItem( position, true );
        categoryAdapter.notifyDataSetChanged();
    }

    private void initActionBar() {
        setSupportActionBar( categoryActToolbar );
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled( true );
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return true;
    }
}

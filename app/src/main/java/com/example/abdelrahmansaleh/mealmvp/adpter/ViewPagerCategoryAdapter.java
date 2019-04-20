package com.example.abdelrahmansaleh.mealmvp.adpter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.abdelrahmansaleh.mealmvp.data.model.category.CategoryData;
import com.example.abdelrahmansaleh.mealmvp.ui.categoryActivity.CategoryFragment;

import java.util.List;

import static com.example.abdelrahmansaleh.mealmvp.helper.Conestant.EXTRA_DATA_DESC;
import static com.example.abdelrahmansaleh.mealmvp.helper.Conestant.EXTRA_DATA_IMAGE;
import static com.example.abdelrahmansaleh.mealmvp.helper.Conestant.EXTRA_DATA_NAME;

public class ViewPagerCategoryAdapter extends FragmentPagerAdapter {
    List<CategoryData> categoriesList;

    public ViewPagerCategoryAdapter(FragmentManager fm, List<CategoryData> categoriesList) {
        super( fm );
        this.categoriesList = categoriesList;
    }

    @Override
    public Fragment getItem(int position) {
        CategoryFragment fragment = new CategoryFragment();
        Bundle args = new Bundle();
        args.putString( EXTRA_DATA_NAME, categoriesList.get( position ).getStrCategory() );
        args.putString( EXTRA_DATA_DESC, categoriesList.get( position ).getStrCategoryDescription() );
        args.putString( EXTRA_DATA_IMAGE, categoriesList.get( position ).getStrCategoryThumb() );
        fragment.setArguments( args );
        return fragment;
    }

    @Override
    public int getCount() {
        return categoriesList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return categoriesList.get( position ).getStrCategory();
    }

}

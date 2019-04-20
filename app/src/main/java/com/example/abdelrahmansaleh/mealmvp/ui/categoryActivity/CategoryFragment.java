package com.example.abdelrahmansaleh.mealmvp.ui.categoryActivity;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.abdelrahmansaleh.mealmvp.R;
import com.example.abdelrahmansaleh.mealmvp.adpter.MealAdapter;
import com.example.abdelrahmansaleh.mealmvp.data.model.meal.MealData;
import com.example.abdelrahmansaleh.mealmvp.helper.Conestant;
import com.example.abdelrahmansaleh.mealmvp.helper.HelperMethods;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static android.support.constraint.Constraints.TAG;

/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryFragment extends Fragment implements CategoryView {


    @BindView(R.id.imageCategoryBg)
    ImageView imageCategoryBg;
    @BindView(R.id.imageCategory)
    ImageView imageCategory;
    @BindView(R.id.textCategory)
    TextView textCategory;
    @BindView(R.id.cardCategory)
    CardView cardCategory;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    Unbinder unbinder;

    public CategoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate( R.layout.fragment_category, container, false );
        unbinder = ButterKnife.bind( this, view );
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated( view, savedInstanceState );

        if (getArguments() != null) {
            textCategory.setText( getArguments().getString( Conestant.EXTRA_DATA_DESC ) );
            HelperMethods.useGlide( getContext(), imageCategory, getArguments().getString( Conestant.EXTRA_DATA_IMAGE ) );
            HelperMethods.useGlide( getContext(), imageCategoryBg, getArguments().getString( Conestant.EXTRA_DATA_IMAGE ) );
            CategoryPresenter categoryPresenter = new CategoryPresenter( this );
            categoryPresenter.getCategoryMeal( getArguments().getString( Conestant.EXTRA_DATA_NAME ) );
        }
    }

    @Override
    public void showLoading() {
        progressBar.setVisibility( View.VISIBLE );
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility( View.GONE );
    }

    @Override
    public void setMeals(List<MealData> meals) {
        GridLayoutManager layoutManager = new GridLayoutManager( getActivity(), 2 );
        recyclerView.setLayoutManager( layoutManager );
        MealAdapter mealAdapter = new MealAdapter( getContext(), meals );
        recyclerView.setClipToPadding( false );
        recyclerView.setAdapter( mealAdapter );
        recyclerView.setNestedScrollingEnabled( false );
        mealAdapter.notifyDataSetChanged();
//        mealAdapter.setOnItemClickListener( (view, position)
//                -> Toast.makeText( getActivity(), meals.get( position ).getStrMeal(), Toast.LENGTH_SHORT ).show() );
        for (int i = 0; i < meals.size(); i++) {
            Log.i( TAG, "setMeals: " + meals.get( i ).getStrMeal() );
        }
    }

    @Override
    public void onErrorLoading(String tittle, String message) {

    }
}

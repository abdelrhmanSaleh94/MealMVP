package com.example.abdelrahmansaleh.mealmvp.adpter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.abdelrahmansaleh.mealmvp.R;
import com.example.abdelrahmansaleh.mealmvp.data.model.meal.MealData;
import com.example.abdelrahmansaleh.mealmvp.helper.HelperMethods;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ViewPagerHeaderAdapter extends PagerAdapter {
    @BindView(R.id.mealThumb)
    ImageView mealThumb;
    @BindView(R.id.mealName)
    TextView mealName;
    private List<MealData> mealList;
    private Context context;
    private static ClickListener clickListener;

    public ViewPagerHeaderAdapter(List<MealData> mealList, Context context) {
        this.mealList = mealList;
        this.context = context;
    }

    public void setOnItemClickListener(ClickListener clickListener) {
        ViewPagerHeaderAdapter.clickListener = clickListener;
    }

    @Override
    public int getCount() {
        return mealList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals( object );
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        View view = LayoutInflater.from( context ).inflate(
                R.layout.item_view_pager_header,
                container,
                false
        );
        ButterKnife.bind(this, view );
        HelperMethods.useGlide( context, mealThumb, mealList.get( position ).getStrMealThumb() );
        mealName.setText( mealList.get( position ).getStrMeal() );
        view.setOnClickListener( v -> clickListener.onClick( v, position ) );
        container.addView( view, 0 );
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView( (View) object );
    }

    public interface ClickListener {
        void onClick(View v, int position);
    }
}

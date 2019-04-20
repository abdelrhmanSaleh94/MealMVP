package com.example.abdelrahmansaleh.mealmvp.adpter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.abdelrahmansaleh.mealmvp.R;
import com.example.abdelrahmansaleh.mealmvp.data.model.meal.MealData;
import com.example.abdelrahmansaleh.mealmvp.helper.Conestant;
import com.example.abdelrahmansaleh.mealmvp.helper.HelperMethods;
import com.example.abdelrahmansaleh.mealmvp.ui.categoryActivity.CategoryActivity;
import com.example.abdelrahmansaleh.mealmvp.ui.detailsActivity.DetailActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MealAdapter extends RecyclerView.Adapter<MealAdapter.MealViewHolder> {
    private Context context;
    private List<MealData> mealList;

    public MealAdapter(Context context, List<MealData> mealList) {
        this.context = context;
        this.mealList = mealList;
    }

    @NonNull
    @Override
    public MealViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vi = LayoutInflater.from( context ).inflate( R.layout.item_recycler_meal, parent, false );
        return new MealViewHolder( vi );
    }

    @Override
    public void onBindViewHolder(@NonNull MealViewHolder holder, int position) {
        holder.mealName.setText( mealList.get( position ).getStrMeal() );
        HelperMethods.useGlide( context, holder.mealThumb, mealList.get( position ).getStrMealThumb() );
        holder.itemView.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( context, DetailActivity.class );
                intent.putExtra( Conestant.EXTRA_DATA_DETAILS, mealList.get( position ).getStrMeal() );
                ((CategoryActivity) context).startActivity( intent );
            }
        } );
    }

    @Override
    public int getItemCount() {
        return mealList.size();
    }

    public class MealViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.mealThumb)
        ImageView mealThumb;
        @BindView(R.id.love)
        ImageView love;
        @BindView(R.id.mealName)
        TextView mealName;

        public MealViewHolder(View itemView) {
            super( itemView );
            ButterKnife.bind( this, itemView );
        }
    }

}

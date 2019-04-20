package com.example.abdelrahmansaleh.mealmvp.adpter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.abdelrahmansaleh.mealmvp.R;
import com.example.abdelrahmansaleh.mealmvp.data.model.category.CategoryData;
import com.example.abdelrahmansaleh.mealmvp.helper.HelperMethods;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {
    Context context;
    List<CategoryData> categoryList;
    private static ClickListener clickListener;

    public CategoryAdapter(Context context, List<CategoryData> categoryList) {
        this.context = context;
        this.categoryList = categoryList;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from( context ).inflate( R.layout.item_recycler_category, parent, false );
        return new CategoryViewHolder( view );
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        HelperMethods.useGlide( context, holder.categoryThumb, categoryList.get( position ).getStrCategoryThumb() );
        holder.categoryName.setText( categoryList.get( position ).getStrCategory() );
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.categoryThumb)
        ImageView categoryThumb;
        @BindView(R.id.categoryName)
        TextView categoryName;

        public CategoryViewHolder(View itemView) {
            super( itemView );
            ButterKnife.bind( this, itemView );
            itemView.setOnClickListener( this );
        }

        @Override
        public void onClick(View v) {
            clickListener.onClick( v, getAdapterPosition() );
        }
    }

    public void setOnItemClickListener(ClickListener clickListener) {
        CategoryAdapter.clickListener = clickListener;
    }


    public interface ClickListener {
        void onClick(View view, int position);
    }
}

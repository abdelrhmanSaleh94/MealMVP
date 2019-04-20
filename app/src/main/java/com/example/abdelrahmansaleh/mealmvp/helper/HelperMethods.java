package com.example.abdelrahmansaleh.mealmvp.helper;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;

import java.util.Random;

public class HelperMethods {

    public static ColorDrawable[] vibrantLightColorList =
            {
                    new ColorDrawable( Color.parseColor( "#ffeead" ) ),
                    new ColorDrawable( Color.parseColor( "#93cfb3" ) ),
                    new ColorDrawable( Color.parseColor( "#fd7a7a" ) ),
                    new ColorDrawable( Color.parseColor( "#faca5f" ) ),
                    new ColorDrawable( Color.parseColor( "#1ba798" ) ),
                    new ColorDrawable( Color.parseColor( "#6aa9ae" ) ),
                    new ColorDrawable( Color.parseColor( "#ffbf27" ) ),
                    new ColorDrawable( Color.parseColor( "#d93947" ) )
            };

    public static ColorDrawable getRandomDrawbleColor() {
        int idx = new Random().nextInt( vibrantLightColorList.length );
        return vibrantLightColorList[idx];
    }

    public static void useGlide(Context context, ImageView imageView, String imageUrl) {
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.error( getRandomDrawbleColor() );
        Glide.with( context ).load( imageUrl ).transition( DrawableTransitionOptions.withCrossFade() )
                .apply( requestOptions )
                .into( imageView )
        ;

    }
}

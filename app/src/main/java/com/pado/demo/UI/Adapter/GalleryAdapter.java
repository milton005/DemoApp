package com.pado.demo.UI.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.pado.demo.R;


import java.util.ArrayList;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class GalleryAdapter extends PagerAdapter {
    LayoutInflater mLayoutInflater;
    ArrayList<String> mItems=new ArrayList<>();
    @Override
    public int getCount() {
        return null == mItems ? 0 : mItems.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }
    public GalleryAdapter(@NonNull Context context,
                          @NonNull ArrayList<String> mediaGallery) {
        super();

        // Inflater which will be used for creating all the necessary pages
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // The items which will be displayed.
        mItems = mediaGallery;
    }
    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        // This method should create the page for the given position passed to it as an argument.
        // In our case, we inflate() our layout resource to create the hierarchy of view objects and then
        // set resource for the ImageView in it.
        // Finally, the inflated view is added to the container (which should be the ViewPager) and return it as well.

        // inflate our layout resource
        View itemView = mLayoutInflater.inflate(R.layout.inflate_image, container, false);

        // Display the resource on the view
        displayGalleryItem((ImageView) itemView.findViewById(R.id.imageView), mItems.get(position));

        // Add our inflated view to the container
        container.addView(itemView);

        // Detect the click events and pass them to any listeners


        // Return our view
        return itemView;
    }
    protected void unbindDrawables(View view) {
        if (view.getBackground() != null) {
            view.getBackground().setCallback(null);
        }
        if (view instanceof ViewGroup) {
            for (int i = 0; i < ((ViewGroup) view).getChildCount(); i++) {
                unbindDrawables(((ViewGroup) view).getChildAt(i));
            }
            ((ViewGroup) view).removeAllViews();
        }
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        // Removes the page from the container for the given position. We simply removed object using removeView()
        // but could’ve also used removeViewAt() by passing it the position.
        try {
            // Remove the view from the container
            container.removeView((View) object);

            // Try to clear resources used for displaying this view
//            Glide.clear(((View) object).findViewById(R.id.imageView));
            // Remove any resources used by this view
            unbindDrawables((View) object);
            // Invalidate the object
            object = null;
        } catch (Exception e) {
            Log.w(TAG, "destroyItem: failed to destroy item and clear it's used resources", e);
        }
    }
    private void displayGalleryItem(ImageView galleryView, String galleryItem) {
        if (null != galleryItem) {
            Glide.with(galleryView.getContext())// Bind it with the context of the actual view used
                    .load(galleryItem) // Load the image
                     // All our images are static, we want to display them as bitmaps
                    // the decode format - this will not use alpha at all
                     // temporary holder displayed while the image loads
                     // need to manually set the animation as bitmap cannot use cross fade
                    .thumbnail(0.2f) // make use of the thumbnail which can display a down-sized version of the image
                    .into(galleryView); // Voilla - the target view
        }
    }
}

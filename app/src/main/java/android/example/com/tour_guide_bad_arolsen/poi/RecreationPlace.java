package android.example.com.tour_guide_bad_arolsen.poi;


import android.databinding.BindingAdapter;
import android.example.com.tour_guide_bad_arolsen.poi.interfaces.PointOfInterest;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;

/**
 * Created by ByteTonight on 02.06.2017.
 */

public class RecreationPlace implements PointOfInterest, Parcelable {

    public static final Creator<RecreationPlace> CREATOR =
            new Creator<RecreationPlace>() {

                @Override
                public RecreationPlace createFromParcel(Parcel source) {
                    return new RecreationPlace(source);
                }

                @Override
                public RecreationPlace[] newArray(int size) {
                    return new RecreationPlace[size];
                }
            };

    public static final int NO_RESOURCE = -1;
    private String name;
    private String teaserText;
    private String detailText;
    private String address;
    private String website;
    private String mapLoc;
    private int previewImgResourceId = NO_RESOURCE;

    //Unwrap the parcel and populate instance
    public RecreationPlace(Parcel parcel) {
        name = parcel.readString();
        teaserText = parcel.readString();
        detailText = parcel.readString();
        previewImgResourceId = parcel.readInt();
        //Note to myself : See MinimalQuizApp for more on reading parcel data
    }

    public RecreationPlace(String name, String teaserText, String detailText, int previewImgResourceId) {

        this.name = name;
        this.teaserText = teaserText;
        this.detailText = detailText;
        this.previewImgResourceId = previewImgResourceId;
    }

    public RecreationPlace(String name, String teaserText, String address, String website,
                           String mapLoc, int previewImgResourceId) {

        this.name = name;
        this.teaserText = teaserText;
        this.address = address;
        this.website = website;
        this.mapLoc = mapLoc;
        this.previewImgResourceId = previewImgResourceId;
    }


    @Override
    public String getName() {
        return name;
    }


    @Override
    public String getTeaserText() {
        return teaserText;
    }


    @Override
    public String getDetailText() {
        return detailText;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public String getWebsite() {
        return website;
    }

    @Override
    public String getMapLoc() {
        return mapLoc;
    }

    @Override
    public boolean hasImage() {
        return previewImgResourceId != NO_RESOURCE;
    }

    /**
     * https://stackoverflow.com/a/35809319
     * https://mutualmobile.com/posts/using-data-binding-api-in-recyclerview
     * http://www.vogella.com/tutorials/AndroidDatabinding/article.html#exercise-using-data-binding-for-recyclerview
     */

    @Override
    public int getPreviewImageResourceId() {
        return previewImgResourceId;
    }

    /**
     * How this works ?
     * I've added the attribute app:imageUrl="@{poi.previewImageResourceId}" to the ImageView.
     * For the app namespace to work with my imageUrl attribute, I had to declare the namespace
     * in the layout as follows: xmlns:app="http://schemas.android.com/apk/res-auto"
     * THIS IS A MUST
     * Then in the method below, the annotation bind:imageUrl binds a call to my attribute
     * to getPreviewImage which HAS TO BE static. You'd think information as valuable as this can
     * be found in the Android docs ... as usual, it's hidden somewhere
     *
     * @param imageView
     * @param previewImgResourceId
     */
    @BindingAdapter("bind:imageUrl")
    public static void getPreviewImage(ImageView imageView, int previewImgResourceId) {
        if (previewImgResourceId == NO_RESOURCE)
            return;
        Glide.with(imageView.getContext()).load(previewImgResourceId).into(imageView);
    }

    /**
     * I was using this one to set the background image of an AppBarLayout.
     * It works, but the image is distorted in landscape mode. I'll keep this function
     * for just-in-case
     *
     * @param v
     * @param previewImgResourceId
     */
    @BindingAdapter("bind:bgImageUrl")
    public static void setBackgroundImage(final View v, int previewImgResourceId) {
        if (previewImgResourceId == NO_RESOURCE)
            return;

        /*
          Another way of doing it is by using
            setBackgroundResource(previewImgResourceId)
         */

        Glide.with(v.getContext()).load(previewImgResourceId).into(new SimpleTarget<GlideDrawable>() {
            @Override
            public void onResourceReady(GlideDrawable resource, GlideAnimation<? super GlideDrawable> glideAnimation) {
                if (android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.JELLY_BEAN) {
                    v.setBackgroundDrawable(resource);
                } else {
                    v.setBackground(resource);
                }
            }
        });
    }


    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * Flatten this object in to a Parcel.
     *
     * @param dest  The Parcel in which the object should be written.
     * @param flags Additional flags about how the object should be written.
     *              May be 0 or {@link #PARCELABLE_WRITE_RETURN_VALUE}.
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(teaserText);
        dest.writeString(detailText);
        dest.writeInt(previewImgResourceId);
    }
}

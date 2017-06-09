package android.example.com.tour_guide_bad_arolsen.poi.interfaces;

import android.graphics.drawable.Drawable;
import android.os.Parcelable;

/**
 * Created by ByteTonight on 02.06.2017.
 */

public interface PointOfInterest extends Parcelable{
    String getName();
    String getTeaserText();
    String getDetailText();
    String getAddress();
    String getWebsite();
    String getMapLoc();
    boolean hasImage();
    int getPreviewImageResourceId();
    //Drawable getPreviewImage();
}

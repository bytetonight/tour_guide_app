package android.example.com.tour_guide_bad_arolsen.poi.interfaces;

/**
 * Created by ByteTonight on 02.06.2017.
 */

public interface PublicEvent extends PointOfInterest{
    String getEventName();
    long getEventStartDateTime();
    long getEventEndDateTime();
    int getPreviewImgResourceId();

}

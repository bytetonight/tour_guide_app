package android.example.com.tour_guide_bad_arolsen.data;

import android.content.Context;
import android.example.com.tour_guide_bad_arolsen.R;
import android.example.com.tour_guide_bad_arolsen.poi.GenericPlaceModel;
import android.example.com.tour_guide_bad_arolsen.poi.interfaces.PointOfInterest;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by ByteTonight on 02.06.2017.
 */

public class VirtualDataBase2 {

    public static List<PointOfInterest> getHistoricalPlaces(Context c) {
        List<PointOfInterest> places = new ArrayList<>();
        places.add(new GenericPlaceModel(
                c.getString(R.string.historical_place_name_1),
                c.getString(R.string.historical_place_teaser_1),
                c.getString(R.string.place_detail),
                R.drawable.residenzschloss_1));

        places.add(new GenericPlaceModel(
                c.getString(R.string.historical_place_name_2),
                c.getString(R.string.historical_place_teaser_2),
                c.getString(R.string.place_detail),
                R.drawable.ev_stadtkirche_1));

        places.add(new GenericPlaceModel(
                c.getString(R.string.historical_place_name_3),
                c.getString(R.string.historical_place_teaser_3),
                c.getString(R.string.place_detail),
                R.drawable.alte_post_1));


        return places;
    }

    public static List<PointOfInterest> getGastronomyPlaces(Context c) {
        List<PointOfInterest> places = new ArrayList<>();
        places.add(new GenericPlaceModel(
                c.getString(R.string.gastronomy_place_name_1),
                c.getString(R.string.gastronomy_place_teaser_1),
                c.getString(R.string.place_detail),
                R.drawable.cafe_prinzessin_emma_1));

        places.add(new GenericPlaceModel(
                c.getString(R.string.gastronomy_place_name_2),
                c.getString(R.string.gastronomy_place_teaser_2),
                c.getString(R.string.place_detail),
                R.drawable.o_mythos));

        places.add(new GenericPlaceModel(
                c.getString(R.string.gastronomy_place_name_3),
                c.getString(R.string.gastronomy_place_teaser_3),
                c.getString(R.string.place_detail),
                R.drawable.no_image));

        places.add(new GenericPlaceModel(
                c.getString(R.string.gastronomy_place_name_4),
                c.getString(R.string.gastronomy_place_teaser_4),
                c.getString(R.string.place_detail),
                R.drawable.avalon_bar));

        return places;
    }

    public static List<PointOfInterest> getRecreationPlaces(Context c) {
        List<PointOfInterest> places = new ArrayList<>();
        places.add(new GenericPlaceModel(
                c.getString(R.string.recreation_place_name_1),
                c.getString(R.string.recreation_place_teaser_1),
                c.getString(R.string.place_detail),
                R.drawable.welcome_hotels_bad_arolsen_1));

        places.add(new GenericPlaceModel(
                c.getString(R.string.recreation_place_name_2),
                c.getString(R.string.recreation_place_teaser_2),
                c.getString(R.string.place_detail),
                R.drawable.arobella_bad_arolsen));

        return places;
    }

    public static List<PointOfInterest> getSportsPlaces(Context c) {
        List<PointOfInterest> places = new ArrayList<>();
        places.add(new GenericPlaceModel(
                c.getString(R.string.sports_place_name_1),
                c.getString(R.string.sports_place_teaser_1),
                c.getString(R.string.place_detail),
                R.drawable.golf_bad_arolsen_1));

        places.add(new GenericPlaceModel(
                c.getString(R.string.sports_place_name_2),
                c.getString(R.string.sports_place_teaser_2),
                c.getString(R.string.place_detail),
                R.drawable.waterski_bad_arolsen_1));

        return places;
    }

}

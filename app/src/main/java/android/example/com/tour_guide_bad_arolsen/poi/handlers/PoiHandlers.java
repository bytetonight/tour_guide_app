package android.example.com.tour_guide_bad_arolsen.poi.handlers;

import android.content.Intent;
import android.example.com.tour_guide_bad_arolsen.DetailsActivity;
import android.example.com.tour_guide_bad_arolsen.poi.interfaces.PointOfInterest;
import android.example.com.tour_guide_bad_arolsen.utils.Utils;
import android.view.View;
import android.widget.Toast;



/**
 * Created by ByteTonight on 05.06.2017.
 */

public class PoiHandlers {

    public void onClickLearnMore(View v, PointOfInterest poi) {
        Toast.makeText(v.getContext(), "Clicked "+poi.getName(), Toast.LENGTH_SHORT).show();
        Intent placeDetails = new Intent(v.getContext(), DetailsActivity.class);
        placeDetails.putExtra(Utils.ARG_POI, poi);
        v.getContext().startActivity(placeDetails);
    }
}

package android.example.com.tour_guide_bad_arolsen.poi.handlers;

import android.content.Context;
import android.content.Intent;
import android.example.com.tour_guide_bad_arolsen.DetailsActivity;
import android.example.com.tour_guide_bad_arolsen.R;
import android.example.com.tour_guide_bad_arolsen.poi.interfaces.PointOfInterest;
import android.example.com.tour_guide_bad_arolsen.utils.Utils;
import android.view.View;


/**
 * Created by ByteTonight on 05.06.2017.
 */

public class PoiHandlers {

    public void onClickLearnMore(View v, PointOfInterest poi) {
        Context context = v.getContext(); //quite cool hey ?
        Intent placeDetails = new Intent(context, DetailsActivity.class);
        placeDetails.putExtra(Utils.ARG_POI, poi);
        context.startActivity(placeDetails);
    }

    public void sharePoi(View v, PointOfInterest poi) {
        Context context = v.getContext();
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, poi.getName());
        sendIntent.setType("text/plain");
        context.startActivity(
                Intent.createChooser(
                        sendIntent, context.getString(R.string.share_with)));
    }
}

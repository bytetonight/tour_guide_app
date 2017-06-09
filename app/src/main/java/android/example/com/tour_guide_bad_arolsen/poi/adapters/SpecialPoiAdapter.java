package android.example.com.tour_guide_bad_arolsen.poi.adapters;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.example.com.tour_guide_bad_arolsen.BR;
import android.example.com.tour_guide_bad_arolsen.R;
import android.example.com.tour_guide_bad_arolsen.data.VirtualDataBase;
import android.example.com.tour_guide_bad_arolsen.databinding.PoiListItemBinding;
import android.example.com.tour_guide_bad_arolsen.databinding.PoiListItemGastronomyBinding;
import android.example.com.tour_guide_bad_arolsen.databinding.PoiListItemHistoricalBinding;
import android.example.com.tour_guide_bad_arolsen.poi.handlers.PoiHandlers;
import android.example.com.tour_guide_bad_arolsen.poi.interfaces.PointOfInterest;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.List;

/**
 * Created by ByteTonight on 02.06.2017.
 *
 *
 * TODO : READ https://www.bignerdranch.com/blog/descent-into-databinding/
 *
 * https://stackoverflow.com/questions/38818199/android-databindingutils-how-to-use-a-single-adapter-for-the-whole-project
 */

/*



public class SpecialPoiAdapter extends RecyclerView.Adapter<BindingHolder> {

    private List<PointOfInterest> items;
    private VirtualDataBase.Poi poiType;
    private PoiListItemHistoricalBinding binding_historcal;
    private PoiListItemGastronomyBinding binding_gastronomy;

    public SpecialPoiAdapter(VirtualDataBase.Poi type, final List<PointOfInterest> items) {
        super();
        this.items = items;
        poiType = type;
    }



    @Override
    public BindingHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        BindingHolder holder = BindingHolder.newInstance(R.layout.poi_list_item_historical,
                LayoutInflater.from(parent.getContext()), parent, false);
        //set listeners and action handlers
        return holder;
    }


    @Override
    public void onBindViewHolder(BindingHolder holder, int position) {
        ViewDataBinding binding = holder.getBinding();
        PointOfInterest item = items.get(position);
        binding.setVariable(BR.poi, item);
        binding.executePendingBindings();
    }


    @Override
    public int getItemCount() {
        return items.size();
    }
}
*/

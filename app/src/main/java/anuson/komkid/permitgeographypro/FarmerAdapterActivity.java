package anuson.komkid.permitgeographypro;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by komkid on 22/3/2560.
 */

public class FarmerAdapterActivity extends BaseAdapter {

    private Context context;
    private String[] mem_nameStrings,mem_farm_nameStrings,mem_picturesStrings;
    private TextView mem_nameTextView,mem_farm_nameTextView,mem_picturesTextView;

    private ImageView imageView;

    public FarmerAdapterActivity(Context context,
                                 String[] mem_nameStrings,
                                 String[] mem_farm_nameStrings,
                                 String[] mem_picturesStrings) {
        this.context = context;
        this.mem_nameStrings = mem_nameStrings;
        this.mem_farm_nameStrings = mem_farm_nameStrings;
        this.mem_picturesStrings = mem_picturesStrings;

    }

    @Override
    public int getCount() {return mem_farm_nameStrings.length;}

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view1 = layoutInflater.inflate(R.layout.farmer_daptera_activity, viewGroup,false);


        mem_nameTextView = (TextView) view1.findViewById(R.id.textView115);
        mem_farm_nameTextView = (TextView) view1.findViewById(R.id.textView116);
        imageView = (ImageView) view1.findViewById(R.id.imageView116);

        mem_nameTextView.setText(mem_farm_nameStrings[i]);
        mem_farm_nameTextView.setText(mem_nameStrings[i]);

        Picasso.with(context).load(mem_picturesStrings[i]).into(imageView);

        return view1;
    }
}

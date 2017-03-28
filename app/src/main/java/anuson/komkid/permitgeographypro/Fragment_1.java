package anuson.komkid.permitgeographypro;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;


public class Fragment_1 extends Fragment {

    private ImageView imageView;
    String s;
    private String[] Fragment_1Strings;
    private  String[] columnFragment = new String[]{
            "advice_fruit_id",
            "Fragment",
            "advice_fruit_text",
            "advice_fruit_pictures"};
    private String Fragment_1 = "Fragment_1";


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_1, container, false);

        Context c = getActivity().getApplicationContext();

        imageView = (ImageView) rootView.findViewById(R.id.imageView6);

        try {
            s = Menu_farmer_1.value;
            s = Menu_user_1.value;

            JSONArray jsonArray = new JSONArray(s);

            Fragment_1Strings = new String[columnFragment.length];
            for (int i=0;i<jsonArray.length();i+=1) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                if (Fragment_1.equals(jsonObject.getString(columnFragment[1])))
                    for (int j = 0; j < columnFragment.length; j += 1) {
                        Fragment_1Strings[j] = jsonObject.getString(columnFragment[j]);
                        Log.d("22MerV5", "Fragment(" + j + ") = " + Fragment_1Strings[j]);

                        Picasso.with(c).load(Fragment_1Strings[3]).fit().into(imageView);
                    }
                // for
            }   // for
        } catch (JSONException e) {
            e.printStackTrace();
        }



        return rootView;
    }

}
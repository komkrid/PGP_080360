package anuson.komkid.permitgeographypro;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

public class Menu_user_4 extends Activity {

    private String[] loginStrings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_user_4);

        loginStrings = getIntent().getStringArrayExtra("Login");

        try{
            SynFarmer synFarmer = new SynFarmer(this);
            synFarmer.execute();
            String s = synFarmer.get();
            Log.d("30JanV2","JSON Syn_Score ==>" + s);

            JSONArray jsonArray = new JSONArray(s);
            final String[] mem_idStrings = new String[jsonArray.length()];
            final String[] mem_userStrings = new String[jsonArray.length()];
            final String[] mem_passStrings = new String[jsonArray.length()];
            final String[] mem_nameStrings = new String[jsonArray.length()];
            final String[] mem_addStrings = new String[jsonArray.length()];
            final String[] mem_telStrings = new String[jsonArray.length()];
            final String[] mem_keyStrings = new String[jsonArray.length()];
            final String[] mem_farm_nameStrings = new String[jsonArray.length()];
            final String[] mem_farm_typeStrings = new String[jsonArray.length()];
            final String[] mem_farm_areaStrings = new String[jsonArray.length()];
            final String[] mem_farm_picStrings = new String[jsonArray.length()];
            final String[] mem_farm_latitudeStrings = new String[jsonArray.length()];
            final String[] mem_farm_longtitudeStrings = new String[jsonArray.length()];
            final String[] mem_farm_addStrings = new String[jsonArray.length()];
            final String[] mem_picturesStrings = new String[jsonArray.length()];

            for (int i=0;i<jsonArray.length();i++) {

                JSONObject jsonObject = jsonArray.getJSONObject(i);
                mem_idStrings[i] = jsonObject.getString("mem_id");
                mem_userStrings[i] = jsonObject.getString("mem_user");
                mem_passStrings[i] = jsonObject.getString("mem_pass");
                mem_nameStrings[i] = jsonObject.getString("mem_name");
                mem_addStrings[i] = jsonObject.getString("mem_add");
                mem_telStrings[i] = jsonObject.getString("mem_tel");
                mem_keyStrings[i] = jsonObject.getString("mem_key");
                mem_farm_nameStrings[i] = jsonObject.getString("mem_farm_name");
                mem_farm_typeStrings[i] = jsonObject.getString("mem_farm_type");
                mem_farm_areaStrings[i] = jsonObject.getString("mem_farm_area");
                mem_farm_picStrings[i] = jsonObject.getString("mem_farm_pic");
                mem_farm_latitudeStrings[i] = jsonObject.getString("mem_farm_latitude");
                mem_farm_longtitudeStrings[i] = jsonObject.getString("mem_farm_longtitude");
                mem_farm_addStrings[i] = jsonObject.getString("mem_farm_add");
                mem_picturesStrings[i] = jsonObject.getString("mem_pictures");

                ListView listView = (ListView) findViewById(R.id.liv_score_farmer);

                FarmerAdapterActivity farmerAAdapterActivity = new FarmerAdapterActivity(Menu_user_4.this,mem_nameStrings,mem_farm_nameStrings,
                        mem_picturesStrings);
                listView.setAdapter(farmerAAdapterActivity);

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                        Intent intent = new Intent(Menu_user_4.this, ListPostByUser.class);

                        intent.putExtra("mem_id",mem_idStrings[i]);
                        intent.putExtra("Login", loginStrings);
                        startActivity(intent);

                    }
                });



            }//for








        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

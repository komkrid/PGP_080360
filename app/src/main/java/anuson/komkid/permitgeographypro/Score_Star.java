package anuson.komkid.permitgeographypro;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;

public class Score_Star extends AppCompatActivity {

    private Button btnSubmit,btnblack;
    private TextView txtRatingValue,mem_nameTextView;
    private RatingBar ratingBar;
    private String ratingString;

    private String mem_u_idStrings,post_idStrings,mem_idStrings,mem_nameStrings;

    private boolean aBoolean = true;
    private Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score__star);

        addListenerOnRatingBar();
        addListenerOnButton();

        mem_u_idStrings = getIntent().getStringExtra("mem_u_id");
        post_idStrings = getIntent().getStringExtra("post_id");
        mem_idStrings = getIntent().getStringExtra("mem_id");
        mem_nameStrings = getIntent().getStringExtra("mem_name");




        mem_nameTextView = (TextView) findViewById(R.id.textView116);
        mem_nameTextView.setText("คุณ " + mem_nameStrings);

    }//onCreate

    private void addListenerOnButton() {
        ratingBar = (RatingBar) findViewById(R.id.ratingBar2);
        txtRatingValue = (TextView) findViewById(R.id.textView113);

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {

                txtRatingValue.setText(String.valueOf(v));
            }
        });

    }

    private void addListenerOnRatingBar() {
        ratingBar = (RatingBar) findViewById(R.id.ratingBar2);
        btnSubmit = (Button) findViewById(R.id.button14);
        btnblack = (Button) findViewById(R.id.button13);


        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                confirmData();


            }
        });//ButtonSubmit
        btnblack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();


            }
        });//ButtonSubmit


    }//addListenerOnRatingBar



    private void confirmData() {
        ratingString = String.valueOf(ratingBar.getRating());

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setIcon(R.drawable.dule_icon);
        builder.setTitle("โปรดรวจสอบข้อมูล");
        builder.setMessage("คุณได้ให้" + ratingString + "คะแนน" +"\n");
        //โชวข้อมูลการกรอก การแจ้งเตือนครั้งสุดท้าย

        builder.setNegativeButton("ยกเลิก", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.setPositiveButton("ตกลง", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Add_Score_Star add_score_star = new Add_Score_Star(Score_Star.this,ratingString,post_idStrings,mem_idStrings,mem_u_idStrings);
                add_score_star.execute();
                dialog.dismiss();
                finish();
            }
        });
        builder.show();
    }
}


package anuson.komkid.permitgeographypro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class Score_Star extends AppCompatActivity {

    private Button btnSubmit;
    private TextView txtRatingValue,mem_nameTextView;
    private RatingBar ratingBar;

    private String mem_u_idStrings,post_idStrings,mem_idStrings,mem_nameStrings;

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

        Log.d("19MerV5", "post_id_to_user ==>" + mem_u_idStrings);
        Log.d("19MerV5", "post_id_to_user ==>" + post_idStrings);
        Log.d("19MerV5", "post_id_to_user ==>" + mem_idStrings);
        Log.d("19MerV5", "post_id_to_user ==>" + mem_nameStrings);


        mem_nameTextView = (TextView) findViewById(R.id.textView116);
        mem_nameTextView.setText("คุณ "+mem_nameStrings);
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

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Score_Star.this,String.valueOf(ratingBar.getRating()),Toast.LENGTH_SHORT).show();
            }
        });

    }
}

package nitt.hackathon.oxytrees;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import static nitt.hackathon.oxytrees.R.drawable.t;

/**
 * Created by HP on 06-Oct-17.
 */

public class profile extends AppCompatActivity {
    TextView t1,t2,t3,t4,t5,t6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_layout);

        t1 = (TextView) findViewById(R.id.textView10);
        t1.setText(String.valueOf(global.fullname));

        t2 = (TextView) findViewById(R.id.textView11);
        t2.setText(String.valueOf(global.Contact));

        t3 = (TextView) findViewById(R.id.textView12);
        t3.setText(String.valueOf(global.age));

        t4 = (TextView) findViewById(R.id.textView14);
        t4.setText(String.valueOf(global.oxygenConsumption));

        t5 = (TextView) findViewById(R.id.textView15);
        t5.setText( String.valueOf(global.lat ));

        t6 = (TextView) findViewById(R.id.textView16);
        t6.setText(String.valueOf(global.points));


    }

    public void back(View view)
    {

        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

}
package nitt.hackathon.oxytrees;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;
import com.google.android.gms.maps.model.LatLng;

/**
 * Created by HP on 06-Oct-17.
 */

public class createEvents  extends AppCompatActivity {
    int request_code = 1;
    TextView t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_events);
        t = (TextView) findViewById(R.id.textView4);
        //t.setOnClickListener(new View.OnClickListener() {
          //  @Override
           // public void onClick(View v) {
                PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();

                Intent intent;
                try {
                    intent = builder.build(createEvents.this);
                    startActivityForResult(intent,request_code);
                } catch (GooglePlayServicesRepairableException e) {
                    e.printStackTrace();
                } catch (GooglePlayServicesNotAvailableException e) {
                    e.printStackTrace();
                }

           // }
        //});

    }

    protected void onActivityResult(int request_code1,int result_code1 , Intent data)
    {


        if(request_code1==request_code)
        {
            if(result_code1 == RESULT_OK)
            {
                Place place = PlacePicker.getPlace(data,createEvents.this);
                LatLng address = place.getLatLng();
            }
        }
    }

    public void back(View view)
    {

        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }

}
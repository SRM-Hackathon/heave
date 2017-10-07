package nitt.hackathon.oxytrees;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

/**
 * Created by HP on 06-Oct-17.
 */

public class AboutUs extends AppCompatActivity {

    private ImageView img ;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_about);
       img = (ImageView) findViewById(R.id.imageView9);

    }

    public void back(View view)
    {

        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }



    public void manti(View v)
    {
        Uri uriUrl = Uri.parse("https://github.com/manishtiwari98");
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }

    public void eth(View v)
    {
        Uri uriUrl = Uri.parse("https://github.com/EhteshamIzhar");
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }
    public void mygit(View v)
    {
        Uri uriUrl = Uri.parse("https://github.com/Lightning-Bug");
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }
}
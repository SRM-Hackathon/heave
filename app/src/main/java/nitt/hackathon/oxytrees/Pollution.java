package nitt.hackathon.oxytrees;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;

import javax.net.ssl.HttpsURLConnection;

import static nitt.hackathon.oxytrees.R.drawable.t;
import static nitt.hackathon.oxytrees.login.i;

/**
 * Created by HP on 06-Oct-17.
 */

public class Pollution extends AppCompatActivity {

    TextView t1,t2,t3;
    String s1,s2,s3;
    Double progress = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_oxygen);
        t1 = (TextView) findViewById(R.id.textView18);
        t2 = (TextView) findViewById(R.id.textView19);
        t3 = (TextView) findViewById(R.id.textView20);
        new SendPollutionData().execute(global.user_id);
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(s1));
                startActivity(intent);
            }
        });

        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(s2));
                startActivity(intent);
            }
        });

        t3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(s3));
                startActivity(intent);
            }
        });

        new SendPollutionData().execute(global.user_id);
    }

    public class SendPollutionData extends AsyncTask<String, Integer, String> {

        protected void onPreExecute() {
        }

        protected String doInBackground(String... arg0) {

            try {

                URL url = new URL("https://10c9a69f.ngrok.io/env/news/"); // here is your URL path

                JSONObject postDataParams = new JSONObject();
                postDataParams.put("user_id", arg0[0]);
                // postDataParams.put("user_pwd", arg0[1]);
                Log.e("params", postDataParams.toString());

                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setReadTimeout(15000 /* milliseconds */);
                conn.setConnectTimeout(15000 /* milliseconds */);
                conn.setRequestMethod("POST");
                conn.setDoInput(true);
                conn.setDoOutput(true);

                OutputStream os = conn.getOutputStream();
                BufferedWriter writer = new BufferedWriter(
                        new OutputStreamWriter(os, "UTF-8"));
                writer.write(getPostDataString(postDataParams));

                writer.flush();
                writer.close();
                os.close();

                int responseCode = conn.getResponseCode();

                if (responseCode == HttpsURLConnection.HTTP_OK) {
                    i = 1;

                    BufferedReader in = new BufferedReader(new
                            InputStreamReader(
                            conn.getInputStream()));

                    StringBuffer sb = new StringBuffer("");
                    String line = "";
                    int i = 0;


                    while ((line = in.readLine()) != null) {

                        //publishProgress(i++);

                        sb.append(line);
                        break;
                    }

                    in.close();
                    return sb.toString();

                } else {
                    return new String("false : " + responseCode);
                }
            } catch (Exception e) {
                return new String("Exception: " + e.getMessage());
            }

        }

        // @Override
        // protected void onProgressUpdate(Integer... values) {
        //super.onProgressUpdate(values);
        // progressBar.setVisibility(View.VISIBLE);
        //progressBar.setProgress(values[0]);
        // setProgressPercent(values);
        // }

        @Override
        protected void onPostExecute(String result) {
            Toast.makeText(getApplicationContext(), result,
                    Toast.LENGTH_LONG).show();
            try {
                JSONObject jsonObject = new JSONObject(result);
                t1.setText(jsonObject.optString("Heading1"));
                t2.setText(jsonObject.optString("Heading2"));
                t3.setText(jsonObject.optString("Heading3"));
                s1 = jsonObject.optString("Link1");
                s2 = jsonObject.optString("Link2");
                s3 = jsonObject.optString("Link3");
                progress = jsonObject.optDouble("aqi");
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }

        public String getPostDataString(JSONObject params) throws Exception {

            StringBuilder result = new StringBuilder();
            boolean first = true;

            Iterator<String> itr = params.keys();

            while (itr.hasNext()) {

                String key = itr.next();
                Object value = params.get(key);

                if (first)
                    first = false;
                else
                    result.append("&");

                result.append(URLEncoder.encode(key, "UTF-8"));
                result.append("=");
                result.append(URLEncoder.encode(value.toString(), "UTF-8"));

            }
            return result.toString();
        }
    }
    public void back(View view) {

        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}

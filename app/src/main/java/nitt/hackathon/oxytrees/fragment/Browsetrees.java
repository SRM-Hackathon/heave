package nitt.hackathon.oxytrees.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import nitt.hackathon.oxytrees.R;

/**
 * Created by HP on 06-Oct-17.
 */

public class Browsetrees extends Fragment {

    public Browsetrees() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.browse_trees, container, false);

<<<<<<< HEAD
        return view;
    }
=======
        mapView = (MapView) view.findViewById(R.id.maps);
        mapView.onCreate(savedInstanceState);
        mapView.onResume();
        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }

        mapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap mMap) {
                map = mMap;

                // For showing a move to my location button
                // map.setMyLocationEnabled(true);

                // For dropping a marker at a point on the Map
                LatLng sydney = new LatLng(12.824825, 80.046594);
                map.addMarker(new MarkerOptions().position(sydney).title("Marker Title").snippet("Marker Description").icon(BitmapDescriptorFactory.fromResource(R.drawable.m)));

                // For zooming automatically to the location of the marker
                CameraPosition cameraPosition = new CameraPosition.Builder().target(sydney).zoom(15).build();
                map.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));


            }
        });


        /*PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();
        Intent intent;
        try {
            intent = builder.build(getActivity());
            Log.v("hlo",""+intent);
            startActivityForResult(intent,PLACE_PICKER_REQUEST);
        } catch (GooglePlayServicesRepairableException e) {
            e.printStackTrace();
        } catch (GooglePlayServicesNotAvailableException e) {
            e.printStackTrace();
        }*/
        new browsetrees().execute("No","__all");

        return view;
    }


    public class browsetrees extends AsyncTask<String , Integer, String> {

        protected void onPreExecute(){}

        protected String doInBackground(String... arg0) {

            try {

                URL url = new URL("https://10c9a69f.ngrok.io/env/tree/"); // here is your URL path

                JSONObject postDataParams = new JSONObject();
                postDataParams.put("create", arg0[0]);
                postDataParams.put("user_id", "__all");
                Log.v("pari",""+ arg0[1]);
                Log.e("params",postDataParams.toString());

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

                int responseCode=conn.getResponseCode();

                if (responseCode == HttpsURLConnection.HTTP_OK) {
                   // i=1;

                    BufferedReader in=new BufferedReader(new
                            InputStreamReader(
                            conn.getInputStream()));

                    StringBuffer sb = new StringBuffer("");
                    String line="";



                    while((line = in.readLine()) != null) {

                        // publishProgress(i++);

                        sb.append(line);
                        break;
                    }

                    in.close();
                    return sb.toString();

                }
                else {
                    return new String("false : "+responseCode);
                }
            }
            catch(Exception e){
                return new String("Exception: " + e.getMessage());
            }

        }



        @Override
        protected void onPostExecute(String result) {
            Toast.makeText(getActivity(), result,
                    Toast.LENGTH_LONG).show();


            try {
                JSONArray jsonArray = new JSONArray(result);
                for(int i=0;i<jsonArray.length();i++)
                {
                    JSONObject jsonObject = jsonArray.optJSONObject(i);
                    JSONObject object = jsonObject.optJSONObject("fields");
                    String user = (String)object.optString("user");
                    Double d1 = Double.parseDouble(object.optString("tree_loc_lat"));
                    Double d2 = Double.parseDouble(object.optString("tree_loc_long"));
                    Log.v("lol",""+ global.user_id);
                    Log.v("tree ","" + object.optString("user"));
                    Log.v("truth", ""+(user== global.user_id));
                    if(user.equals(global.user_id)) {
                        map.addMarker(new MarkerOptions().position(new LatLng(d1, d2)).title(object.optString("tree_type")).snippet(object.optString("user")).icon(BitmapDescriptorFactory.fromResource(R.drawable.m)));
                    }
                else
                    {
                        map.addMarker(new MarkerOptions().position(new LatLng(d1,d2)).title(object.optString("tree_type")).snippet(object.optString("user")).icon(BitmapDescriptorFactory.fromResource(t)));

                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            // Toast.makeText(getApplicationContext(), result,
             //       Toast.LENGTH_LONG).show();

           /* if(i==1)
            {
                Intent intent = new Intent(MainActivity.this,okay.class);
                startActivity(intent);}*/

        }
    }

    public String getPostDataString(JSONObject params) throws Exception {

        StringBuilder result = new StringBuilder();
        boolean first = true;

        Iterator<String> itr = params.keys();

        while(itr.hasNext()){

            String key= itr.next();
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
    /*public void onActivityResult(int requestCode,int resultCode, Intent data)
    {
        if(requestCode==PLACE_PICKER_REQUEST)
        {
            if(resultCode==RESULT_OK)
            {
                Place place = PlacePicker.getPlace(data,getActivity());
               // String address = String.format("Place: %s",place.getAddress());
               // cityText.setText(address);
            }
        }
    }*/
>>>>>>> 3f94917ac1ebf93dc5284a4ef076c901201ccb5a
}

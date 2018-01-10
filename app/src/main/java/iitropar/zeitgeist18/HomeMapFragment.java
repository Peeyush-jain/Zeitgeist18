package iitropar.zeitgeist18;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
        import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
        import android.view.Menu;
        import android.view.MenuInflater;
        import android.view.MenuItem;
import android.view.View;
        import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.MarkerOptions;

import static android.content.ContentValues.TAG;


public class HomeMapFragment extends Fragment implements OnMapReadyCallback {

    private GoogleMap mMap;
    public HomeMapFragment(){

    }


    View myView;
    Context mainContext ;

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // Do something that differs the Activity's menu here

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        return false;
    }

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        myView = inflater.inflate(R.layout.fragment_home_sub_map, container, false);
        mainContext = myView.getContext();
        setHasOptionsMenu(true);
        SupportMapFragment mapFragment = (SupportMapFragment) this.getChildFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


        return myView;
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setIndoorEnabled(true);
        try {
            // Customise the styling of the base map using a JSON object defined
            // in a raw resource file.
            boolean success = googleMap.setMapStyle(
                    MapStyleOptions.loadRawResourceStyle(
                            getContext(), R.raw.style_json));

            if (!success) {
                Log.e(TAG, "Style parsing failed.");
            }
        } catch (Resources.NotFoundException e) {
            Log.e(TAG, "Can't find style. Error: ", e);
        }

        LatLng IITRopar = new LatLng(30.975382, 76.538868);
        mMap.addMarker(new MarkerOptions().position(IITRopar).title("IIT Ropar"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(IITRopar ,17));

    }



}

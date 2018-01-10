package iitropar.zeitgeist18;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


/**
 * Created by yadav on 10/3/17.
 */
public class HomeScheduleFragment extends Fragment {

    public HomeScheduleFragment(){

    }


    View myView;
    Context mainContext ;
    ImageView day1 , day2 , day3 , day4 ;

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

        myView = inflater.inflate(R.layout.fragment_home_sub_schedule, container, false);
        mainContext = myView.getContext();
        setHasOptionsMenu(true);
        day1 = myView.findViewById(R.id.day1);
        day2 = myView.findViewById(R.id.day2);
        day3 = myView.findViewById(R.id.day3);
        day4 = myView.findViewById(R.id.day4);


        day1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mainContext,ScheduleDay.class) ;
                intent.putExtra("dayNumber" , 1);

                startActivity(intent);
            }
        });

        day2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mainContext,ScheduleDay.class) ;
                intent.putExtra("dayNumber" , 2);

                startActivity(intent);
            }
        });

        day3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mainContext,ScheduleDay.class) ;
                intent.putExtra("dayNumber" , 3);

                startActivity(intent);
            }
        });

        day4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mainContext,ScheduleDay.class) ;
                intent.putExtra("dayNumber" , 4);

                startActivity(intent);
            }
        });




        return myView;
    }




}

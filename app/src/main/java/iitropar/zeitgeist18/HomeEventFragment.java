package iitropar.zeitgeist18;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class HomeEventFragment extends Fragment {
    // showing event that get started in 30 minutes
    private View myView ;
    private Context mainContext ;
    private DBHandler dba ;
    private ArrayList<Event> eventList ;
    private ArrayList<Event> upcomingEventList ;
    private RecyclerView recyclerView ;
    private static UpcomingEventAdapter upcomingEventAdapter ;
    private static LinearLayoutManager layoutManager ;

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        myView = inflater.inflate(R.layout.fragment_home_sub_event, container, false);
        mainContext = myView.getContext();
        setHasOptionsMenu(true);
        dba = new DBHandler(getContext(), null, null, 1);
        eventList = new ArrayList<>();
        upcomingEventList = new ArrayList<>();
        recyclerView = myView.findViewById(R.id.currentRecyclerView);

        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("dd");
        String formattedDate = df.format(c.getTime());
        int currentDate = Integer.parseInt(formattedDate);
        int offset = FestDate.festDate ; // To be changed according to days

        SimpleDateFormat df2 = new SimpleDateFormat("HH:mm");
        formattedDate = df2.format(c.getTime());
        String[] data1 = formattedDate.split(":");
        int currentHrs = Integer.parseInt(data1[0]);
        int currentMins = Integer.parseInt(data1[1]);


        eventList = dba.getDataDay(currentDate - offset);
        upcomingEventList.clear();
        for (int i = 0 ; i < eventList.size() ; i++){
            String time = eventList.get(i).getEventTime();
            String[] data = time.split(":");
            int hrs = Integer.parseInt(data[0]);
            String data2 = (data[1].subSequence(0,2)).toString() ;
            int mins = Integer.parseInt(data2);

            if (currentMins > mins){
                mins = mins + 60 ;
                hrs = hrs - 1 ;
                if (hrs < 0){
                    hrs = hrs + 24 ;
                }
            }


            if (currentHrs == hrs && (mins - currentMins < 30) && (mins - currentMins > 0)){
                upcomingEventList.add(eventList.get(i));
            }


        }
        if (upcomingEventList.size() == 0){

            myView = inflater.inflate(R.layout.blank, container, false);
            TextView text = myView.findViewById(R.id.blankText);
            text.setText(R.string.upcomingBlank);
            setHasOptionsMenu(true);
        }
        else {
            upcomingEventAdapter = new UpcomingEventAdapter(mainContext, upcomingEventList,getActivity().getSupportFragmentManager());
            layoutManager = new LinearLayoutManager( getActivity());
            recyclerView.setLayoutManager(layoutManager);
//        recyclerView.addItemDecoration(new SimpleDividerItemDecoration(
//                getActivity()
//        ));

            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.setAdapter(upcomingEventAdapter);


        }



        return myView;
    }




}

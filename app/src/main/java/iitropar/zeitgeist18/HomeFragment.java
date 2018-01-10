package iitropar.zeitgeist18;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

public class HomeFragment extends Fragment {

    View myView;
    private FragmentManager fragmentManager;
    private static DBHandler dba;
   
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        fragmentManager = getFragmentManager();

        // implement the on click event lister for the bottom navigation plane

        fragmentManager.beginTransaction()
                .replace(R.id.content_frame_home, new HomeEventFragment())
                .commit();
        getActivity().setTitle("Events");
        dba = new DBHandler(getContext(), null, null, 1);


        SharedPreferences wmbPreference = PreferenceManager.getDefaultSharedPreferences(getContext());
        boolean isFirstRun = wmbPreference.getBoolean("FIRSTRUN", true);
        if (isFirstRun)
        {
            // Code to run once
            dba.clearDatabase();
            databaseInsert();
            SharedPreferences.Editor editor = wmbPreference.edit();
            editor.putBoolean("FIRSTRUN", false);
            editor.commit();
        }
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        myView = inflater.inflate(R.layout.fragment_home , container, false);


        BottomNavigationView bottomNavigationView = (BottomNavigationView) myView.findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.action_map:
                                System.out.println("Map");
                                fragmentManager.beginTransaction()
                                        .replace(R.id.content_frame_home, new HomeMapFragment())
                                        .commit();
                                getActivity().setTitle("Map");
                                break;
                            case R.id.action_events:
                                System.out.println("Event");
                                fragmentManager.beginTransaction()
                                        .replace(R.id.content_frame_home, new HomeEventFragment())
                                        .commit();
                                getActivity().setTitle("Events");
                                break;
                            case R.id.action_schedule:
                                System.out.println("schedule");
                                fragmentManager.beginTransaction()
                                        .replace(R.id.content_frame_home, new HomeScheduleFragment())
                                        .commit();
                                getActivity().setTitle("Schedule");
                                break;
                        }
                        return true;
                    }
                });

        return myView;
    }



    public void databaseInsert(){
        insertData(1,1);
        insertData(1,2);
        insertData(1,3);
        insertData(1,4);
        insertData(2,1);
        insertData(2,2);
        insertData(2,3);
        insertData(2,4);
        insertData(3,1);
        insertData(3,2);
        insertData(3,3);
        insertData(3,4);



    }

    public void insertData(int eventType , int eventDay){
        Event event = new Event("Third Ball Elimination","LT PCSA","20:41 - 23:00","One Act Stage Play Competition");
        event.setEventRules("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
        event.setEventType(eventType);
        event.setEventDay(eventDay);
        Event event1 = new Event("Aagaaz Elimination","LT PCSA","20:42-24:00","One Act Stage Play Competition");
        event1.setEventRules("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
        event1.setEventType(eventType);
        event1.setEventDay(eventDay);
        Event event2 = new Event("Mantra Eliminations","LT PCSA","20:43 - 00:00","One Act Stage Play Competition");
        event2.setEventRules("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
        event2.setEventType(eventType);
        event2.setEventDay(eventDay);
        Event event3 = new Event("PantoMath","LT PCSA","20:45 - 00:30","One Act Stage Play Competition");
        event3.setEventRules("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
        event3.setEventType(eventType);
        event3.setEventDay(eventDay);
        Event event4 = new Event("Poetry Slam","LT PCSA","20:47 - 01:00","One Act Stage Play Competition");
        event4.setEventRules("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
        event4.setEventType(eventType);
        event4.setEventDay(eventDay);

        Event event5 = new Event("Arz Kiya Hai","LT PCSA","20:40 - 00:45","One Act Stage Play Competition");
        event5.setEventRules("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
        event5.setEventType(eventType);
        event5.setEventDay(eventDay);

        dba.insertTableEvents(event);
        dba.insertTableEvents(event1);
        dba.insertTableEvents(event2);
        dba.insertTableEvents(event3);
        dba.insertTableEvents(event4);
        dba.insertTableEvents(event5);




    }

}
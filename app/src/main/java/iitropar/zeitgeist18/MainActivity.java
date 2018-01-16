package iitropar.zeitgeist18;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private Context context;
    private FragmentManager fragmentManager;
    private DBHandler dba ;
    private ArrayList<Event> eventList ;
    private static boolean isNotify = false ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // TODO
        // hide 3 dots and insert back button
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setElevation(0);
        context = this ;
        eventList = new ArrayList<>() ;
        dba = new DBHandler(context, null, null, 1);

        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("dd");
        String formattedDate = df.format(c.getTime());
        int currentDate = Integer.parseInt(formattedDate);
        int offset = FestDate.festDate ; // To be changed according to days

        eventList = dba.getDataDay(currentDate - offset);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.content_frame, new HomeFragment())
                .commit();
//        if (!isNotify) {
//            isNotify = true ;
//            for (int i = 0; i < eventList.size(); i++) {
//                Event event = eventList.get(i);
//                String time = event.getEventTime();
//                String[] data = time.split(":");
//                int hrs = Integer.parseInt(data[0]);
//                String data2 = (data[1].subSequence(0, 2)).toString();
//                int mins = Integer.parseInt(data2);
//
//                addNotification(event.getEventName(), event.getEventVenue(), event.getEventTime(), hrs, mins, i);
//            }
//        }
         int minute1 = 57 ;
         int minute2 = 59 ;

//        addNotification("Third Ball Elimination","LT PCSA","20:09",15,minute1,1);
//        addNotification("Mantra Round","PCSA","34:00",15,minute1,2);
//        addNotification("Third","LT PCSA","20:09",15,minute1,3);
//        addNotification("Mantra","PCSA","34:00",15,minute1,4);
//        addNotification("Third Ball","LT PCSA","20:09",15,minute1,5);
//        addNotification("Round","PCSA","34:00",15,minute2,6);
//        addNotification("d Ball Elimination","LT PCSA","20:09",15,minute2,7);
//        addNotification("tra Round","PCSA","34:00",15,minute2,8);
//        addNotification("hird Ball Elimination","LT PCSA","20:09",15,minute2,9);
//        addNotification("ra Round","PCSA","34:00",15,minute2,10);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }




    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.myEvents) {
            Intent intent = new Intent(this, MyEvents.class);
            startActivity(intent);

        }else if (id == R.id.home) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);

        }
        else if (id == R.id.results) {
            Intent intent = new Intent(this, Results.class);
            startActivity(intent);

        } else if (id == R.id.about) {
            Intent intent = new Intent(this, AboutZeitgeist.class);
            startActivity(intent);

        } else if (id == R.id.contact) {
            Intent intent = new Intent(this, ContactUS.class);
            startActivity(intent);

        } else if (id == R.id.helpline) {
            Intent intent = new Intent(this, Helpline.class);
            startActivity(intent);
        } else if (id == R.id.developers) {
            Intent intent = new Intent(this, Developers.class);
            startActivity(intent);

        }else if (id == R.id.sponsors){
            Intent intent = new Intent(this, Sponsors.class);
            startActivity(intent);

        }else if (id == R.id.announcement){
            Intent intent = new Intent(this, Anouncement.class);
            startActivity(intent);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    public void addNotification(String eventName ,String eventVenue , String eventTime , int hrs , int minutes , int count){
        Intent notifyIntent = new Intent(this ,MyReceiver.class);
        notifyIntent.putExtra("notificationName",eventName);
        notifyIntent.putExtra("notificationVenue",eventVenue);
        notifyIntent.putExtra("notificationTime",eventTime);

        PendingIntent pendingIntent = PendingIntent.getBroadcast
                (context,count, notifyIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.HOUR_OF_DAY, hrs);
        calendar.set(Calendar.MINUTE, minutes);
        calendar.set(Calendar.SECOND, 0);


        alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),pendingIntent);

    }


}

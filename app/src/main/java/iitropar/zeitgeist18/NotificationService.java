package iitropar.zeitgeist18;

import android.app.IntentService;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationManagerCompat;
import android.widget.RemoteViews;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;


public class NotificationService extends IntentService {


    public NotificationService() {
        super("NotificationService");
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onHandleIntent(Intent intent) {
        Random random = new Random();
        int NOTIFICATION_ID = random.nextInt(99999 - 1000) + 1000;

        String name = intent.getStringExtra("notificationName");
        String venue = intent.getStringExtra("notificationVenue");
        String time = intent.getStringExtra("notificationTime");
        String currentTime = getCurrentTime();
        Notification.Builder builder = new Notification.Builder(this);
        final RemoteViews contentView = new RemoteViews(getPackageName(), R.layout.notification_card);
        contentView.setTextViewText(R.id.notificationText, name);
        contentView.setTextViewText(R.id.notification_venue, venue);
        contentView.setTextViewText(R.id.notification_eventTime,time);
        contentView.setTextViewText(R.id.notificationCurrentTime,currentTime);
        builder.setSmallIcon(R.drawable.ic_launcher);
        builder.setContent(contentView);


        Intent notifyIntent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 2, notifyIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        //to be able to launch your activity from the notification
        builder.setContentIntent(pendingIntent);
        Notification notificationCompat = builder.build();
        builder.setAutoCancel(true);
        notificationCompat.flags |= Notification.FLAG_AUTO_CANCEL | Notification.FLAG_INSISTENT | Notification.FLAG_SHOW_LIGHTS;
        notificationCompat.defaults |= Notification.DEFAULT_SOUND | Notification.DEFAULT_VIBRATE;
        //notification.defaults |= Notification.DEFAULT_VIBRATE;
        //notification.flags |= Notification.FLAG_SHOW_LIGHTS;
        notificationCompat.ledARGB = 0xFFFFA500;
        notificationCompat.ledOnMS = 800;
        notificationCompat.ledOffMS = 1000;

        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(this);

        managerCompat.notify(NOTIFICATION_ID, notificationCompat);
    }

    public String getCurrentTime(){
        Calendar c = Calendar.getInstance();
        SimpleDateFormat df2 = new SimpleDateFormat("HH:mm");
        String formattedDate = df2.format(c.getTime());

        return formattedDate ;
    }
}
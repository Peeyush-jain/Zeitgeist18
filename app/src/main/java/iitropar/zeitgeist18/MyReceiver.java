package iitropar.zeitgeist18;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

public class MyReceiver extends BroadcastReceiver {
    public MyReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String name = intent.getStringExtra("notificationName");
        String venue = intent.getStringExtra("notificationVenue");
        String time = intent.getStringExtra("notificationTime");

        Intent intent1 = new Intent(context, NotificationService.class);
        intent1.putExtra("notificationName",name);
        intent1.putExtra("notificationVenue",venue);
        intent1.putExtra("notificationTime",time);

        context.startService(intent1);
    }


}

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

class ArticleReceiver extends BroadcastReceiver {

    private static final String ARTICLE_SERVICE = "ARTICLE_SERVICE";

    @Override
    public void onReceive(Context context, Intent intent)
    {

        String action = intent.getAction();
        Intent serviceIntent = null;
        if (ARTICLE_SERVICE.equals(action)) {
            //creates bundle and gets data
            Bundle data = intent.getExtras().getBundle("data");
            serviceIntent = WebIntentService.createIntentService(context, data);
        }

        //displays message/alarm about new article
        Toast.makeText(context, "See article", Toast.LENGTH_LONG).show();


    }
    //sets up alarm for message/notification
    public void setAlarm(Context context)
    {
        //sets alarm, then intent and pending intent
        AlarmManager alarm =( AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(context, BroadcastReceiver.class);
        PendingIntent pending = PendingIntent.getBroadcast(context, 0, intent, 0);
        //// sets repeating alarms milliseconds * seconds * minutes (intervals)
        alarm.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), 2 * 100 * 60, pending);
    }
    }

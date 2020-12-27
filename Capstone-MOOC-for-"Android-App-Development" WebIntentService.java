import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import androidx.annotation.Nullable;
import androidx.core.os.MessageCompat;



class WebIntentService extends IntentService {
    private static final String START = "START";

    public WebIntentService() {
        super("WebIntentService");
    }
    WebView webView;
    ProgressBar loading;
    String url = "";

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        String action = intent.getAction();
        //if action starts, creates bundle data and passes to next method
        if (START.equals(action)) {
            Bundle data = intent.getExtras().getBundle("data");
            startMessage(data);
            new MainActivity();
        }
    }

    public static Intent createIntentService(Context context, Bundle bundle) {
        //creates intent for message, putting data as extra
        Intent intent = new Intent(context, WebIntentService.class);
        intent.setAction(START);
        intent.putExtra("data", bundle);
        return intent;
    }

    //processes data, displays message
    private void startMessage(Bundle data) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.putExtra("data", data);

        StringBuilder mBuilder;
        mBuilder = new StringBuilder(String.valueOf(getApplicationContext()))
                .setContentTitle("Article to read");
        MessageCompat notification;
        notification.notify(mBuilder.insert());


    }


    class WebActivity extends MainActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //inflates the activity's layout from XML
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Intent intent = new Intent(String.valueOf(WebIntentService.class));

        url = intent.getStringExtra("url");
        loading = findViewById(R.id.loading);
        webView = findViewById(R.id.webView);


        //display web pages inside app
        webView.setWebViewClient(new WebViewClient() {


            public boolean urlLoading(WebView view, String url) {
                //progress/loading bar visible
                loading.setVisibility(View.VISIBLE);
                view.loadUrl(url);

                return true;
            }
            //once page loaded, loading/progress bar disappears

            public void Loaded(WebView view, final String url) {
                loading.setVisibility(View.GONE);
            }
        });

        webView.loadUrl(url);

    }

    public void setContentView(int activity_details) {
    }


    protected void onHandleIntent(@Nullable Intent intent) {

    }
}}

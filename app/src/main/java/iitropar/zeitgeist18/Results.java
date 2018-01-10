package iitropar.zeitgeist18;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class Results extends AppCompatActivity {

    private  WebView webview ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        webview = new WebView(this);
        webview = findViewById(R.id.webview);

        String data = "<iframe src=\"https://docs.google.com/spreadsheets/d/e/2PACX-1vRvbOEy6Upx1gg0isu-vQS573VwtzJy9X4JM6WIH-AN-ouYleFPjvENkuI6nK4HCMNPoefMyuOqNJXQ/pubhtml?widget=true&amp;headers=false\"></iframe>";
        webview.loadData(data, "text/html", null);

    }
}

package com.example.webview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {
    WebView web;
    SwipeRefreshLayout swips;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        swips = findViewById(R.id.swipId);
        swips.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                load();

            }
        });
        load();
    }

        public void load () {
            web = (WebView) findViewById(R.id.webViewId);
            web.loadUrl("https://github.com/nahin-khaan");   //webview server


            //webview performance
            WebSettings webs = web.getSettings();
            webs.setJavaScriptEnabled(true);
            webs.setSupportZoom(true);
            webs.setBuiltInZoomControls(true);
            webs.setCacheMode(webs.LOAD_NO_CACHE);
            webs.setDomStorageEnabled(true);
            web.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
            web.setScrollbarFadingEnabled(true);
            web.setWebViewClient(new WebViewClient() {
                                     @Override
                                     public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                                     }

                                     @Override
                                     public void onPageFinished(WebView view, String url) {
                                         swips.setRefreshing(false);
                                     }
                                 }
            );
        }




        //with back pressed action
        public void onBackPressed()
        {
            if (web.canGoBack()) {
                web.goBack();
            } else {
                finish();
            }

        }
}



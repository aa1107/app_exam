package com.example.a501_03.app_class_portfolio_leejanghee0330;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.io.File;
import java.io.FilenameFilter;

public class MainActivity extends AppCompatActivity {

    WebView webView_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 상단 컨트롤 바를 제거하는 코드
//        View decorView = getWindow().getDecorView();
//        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION|View.SYSTEM_UI_FLAG_FULLSCREEN;
//        decorView.setSystemUiVisibility(uiOptions);

        setMainWebView();

    }

    private void setMainWebView(){
        webView_main=(WebView)findViewById(R.id.webview_main);

        WebSettings webSettings=webView_main.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView_main.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if(url.startsWith("app://")){
                    Intent intent=new Intent(MainActivity.this,TestActivity.class);
                    startActivity(intent);
                }else{
                    view.loadUrl(url);
                }
                return true;
//                webView_main.loadUrl(url);
//                return true;
            }
        });
        webView_main.loadUrl("http://aa1107.dothome.co.kr/chungnam/index.html");
    }
}

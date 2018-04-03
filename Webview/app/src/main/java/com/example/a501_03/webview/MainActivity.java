package com.example.a501_03.webview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    WebView webView_test;
    EditText edittext_url;
    ImageButton imgbtn_go;

    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView_test = (WebView)findViewById(R.id.webview_test);
        edittext_url = (EditText)findViewById(R.id.edittext_url);
        imgbtn_go = (ImageButton)findViewById(R.id.imgbtn_go);

        //websetting 객체를 통해 웹뷰 설정
        WebSettings webSettings = webView_test.getSettings();
        //자바스크립트 허용
        webSettings.setJavaScriptEnabled(true);
        //새창으로 페이지 열기 방지, 이 설정이 없으면 웹 브라우저 새창에서 열림
        webView_test.setWebViewClient(new WebViewClient(){
                    @Override
                    public boolean shouldOverrideUrlLoading(WebView view, String url) {
                        webView_test.loadUrl(url);
                        return true;
            }
        });

        ImgBtnListener imgBtnListener=new ImgBtnListener();
        imgbtn_go.setOnClickListener(imgBtnListener);
    }

    class ImgBtnListener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            String url=edittext_url.getText().toString();
            webView_test.loadUrl("http://"+url);
        }
    }
}

package cn.edu.fjnu.cl.mybrowser;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String url;
        setContentView(R.layout.activity_main);
        Intent intent=getIntent();
        url=intent.getDataString();
        Mybrowser(url);
    }
    private void Mybrowser(String url){
        WebView webview=(WebView)findViewById(R.id.wbv);
        webview.loadUrl(url);
        webview.getSettings().setJavaScriptEnabled(true);
        //设置使直接通过WebView显示网页
        webview.setWebViewClient(new  WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                //使用WebView加载显示url
                view.loadUrl(url);
                return true;
            }
        });
    }
}

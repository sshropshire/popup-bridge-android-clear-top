package com.braintreepayments.popupbridge.demo;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

import com.braintreepayments.api.PopupBridgeClient;

public class ProductStationAndOrderPageActivity extends AppCompatActivity {

    private WebView mWebView;
    private PopupBridgeClient mPopupBridgeClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup);
        mWebView = findViewById(R.id.web_view);

        mPopupBridgeClient = new PopupBridgeClient(this, mWebView, "my-custom-url-scheme");
        mPopupBridgeClient.setErrorListener(error -> showDialog(error.getMessage()));

        mWebView.loadUrl(getIntent().getStringExtra("url"));
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPopupBridgeClient.deliverPopupBridgeResult(this);
    }

    @Override
    protected void onNewIntent(Intent newIntent) {
        super.onNewIntent(newIntent);
        setIntent(newIntent);
    }

    public void showDialog(String message) {
        new AlertDialog.Builder(this)
                .setMessage(message)
                .setPositiveButton(android.R.string.ok, (dialog, which) -> dialog.dismiss())
                .show();
    }

    public void onTurnInTmpActivity(View view) {
        Intent intent = new Intent(this, ShooppingCartActivity.class);
        startActivity(intent);
    }
}

package com.braintreepayments.popupbridge.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ShooppingCartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tmp);
    }

    //Our order page is also PopupActivity, which is the same activity with our product station page.

    /* Problem is that we have a second activity, shopping cart activity(native), between our
    product station and order page. Product station and Order page are all WebActivity while shopping cart
    Activity is a native activity. We can not make product station and order page native or make shopping
    cart a WebActivity. So we found your quick start in Repo not suitable to our mixed flow.*/
    public void onTmpClick(View view){
        Intent intent = new Intent(this, ProductStationAndOrderPageActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        intent.putExtra("url", "https://braintree.github.io/popup-bridge-example/paypal");
        startActivity(intent);
    }
}
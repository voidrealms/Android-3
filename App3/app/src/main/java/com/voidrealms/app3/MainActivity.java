package com.voidrealms.app3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static Button btnStart;
    private static Button btnResult;
    private static final int feedCustomer = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnStart = (Button)findViewById(R.id.btnStart);
        btnResult = (Button)findViewById(R.id.btnResult);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onStartClicked();
            }
        });

        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onResultClicked();
            }
        });
    }

    private void onStartClicked()
    {
        Log.d(AppSettings.tag,"onStartClicked");

        Intent intent = new Intent("android.intent.action.Customer");
        startActivity(intent);
    }

    private void onResultClicked()
    {
        Log.d(AppSettings.tag,"onResultClicked");
        Intent intent = new Intent("android.intent.action.Customer");

        intent.putExtra("food","pizza");

        startActivityForResult(intent,feedCustomer);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Log.d(AppSettings.tag,"onActivityResult");
        Log.d(AppSettings.tag,"requestCode: " + requestCode);
        Log.d(AppSettings.tag,"resultCode: " + resultCode);

        if(data == null)
        {
            Log.e(AppSettings.tag,"data: NULL");
        }
        else
        {
            if(data.hasExtra("comment")) Log.d(AppSettings.tag,"data: " + data.getStringExtra("comment"));
        }

        if(requestCode == feedCustomer && resultCode == RESULT_OK)
        {
            Log.d(AppSettings.tag,"We fed the customer");
        }
        else
        {
            Log.d(AppSettings.tag,"NOPE!");
        }



    }
}

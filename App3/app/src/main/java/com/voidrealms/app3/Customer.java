package com.voidrealms.app3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Customer extends AppCompatActivity {

    private  static Button btnClose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);

        btnClose = (Button)findViewById(R.id.btnClose);

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onCloseClicked();
            }
        });
    }

    private void onCloseClicked()
    {
        Log.d(AppSettings.tag,"onCloseClicked");



        // TO DO = SAVE SAVE SAVE

        Intent intent = getIntent();

        if(intent.hasExtra("food"))
        {
            Log.d(AppSettings.tag,"Thank you I love: " + intent.getStringExtra("food"));
        }
        else
        {
            Log.e(AppSettings.tag,"WHERE IS MY FOOD!");
        }

        intent.putExtra("comment","thank you!!!!");
        setResult(RESULT_OK,intent);
        finish();
    }
}

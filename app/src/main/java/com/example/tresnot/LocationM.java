package com.example.tresnot;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class LocationM extends AppCompatActivity {
    InputStream Ccode;
    TextView textView;
    Button buttonCode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_m);

        textView=findViewById(R.id.TheCode);
        buttonCode=findViewById(R.id.CodeSee);

        buttonCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Sos="";

                try{
                    Ccode=getAssets().open("mult.c");
                    int rootsize=Ccode.available();
                    byte[] baxArray=new byte[rootsize];
                    Ccode.read(baxArray);
                    Ccode.close();
                    Sos=new String(baxArray);

                }catch (IOException mac){
                    mac.printStackTrace();
                }
                textView.setText((CharSequence) Sos);


            }
        });
    }
}

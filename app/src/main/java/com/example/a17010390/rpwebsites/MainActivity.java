package com.example.a17010390.rpwebsites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    Spinner spn1, spn2;
    Button btnGo;
    ArrayList<String> alcategory;
    ArrayAdapter<String> aacategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spn1 = findViewById(R.id.spn1);
        spn2 = findViewById(R.id.spn2);
        btnGo = findViewById(R.id.buttonGo);

        alcategory = new ArrayList<>();

        aacategory = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, alcategory);

        spn2.setAdapter(aacategory);

        spn1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {

                alcategory.clear();

                if (position == 0) {

                    String[] strSubMenu = getResources().getStringArray(R.array.category);
                    alcategory.addAll(Arrays.asList(strSubMenu));
                    spn2.setSelection(2);
                }
                else if (position == 1){
                    String[] strMenu = getResources().getStringArray(R.array.sub_category);
                    alcategory.addAll(Arrays.asList(strMenu));
                    spn2.setSelection(1);
                }
                aacategory.notifyDataSetChanged();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String url = "";

                if(spn1.getSelectedItemPosition() == 0) {
                    if(spn2.getSelectedItemPosition() == 0) {
                        url = "https://www.rp.edu.sg/";
                    }
                    else if(spn2.getSelectedItemPosition() == 1) {
                        url = "https://www.rp.edu.sg/student-life";
                    }

                }
                else if(spn1.getSelectedItemPosition() == 1){
                    if(spn2.getSelectedItemPosition() == 0) {
                        url = "https://www.rp.edu.sg/soi/full-time-diplomas/details/r47";
                    }
                    else if(spn2.getSelectedItemPosition() == 1) {
                        url = "https://www.rp.edu.sg/soi/full-time-diplomas/details/r12";
                    }
                }

                Intent myIntent = new Intent(MainActivity.this, WebViewActivity.class);
                myIntent.putExtra("url", url);
                startActivity(myIntent);
            }
        });
    }
}

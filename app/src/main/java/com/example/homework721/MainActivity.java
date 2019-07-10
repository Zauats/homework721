package com.example.homework721;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    EditText searchText;
    Button searchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        searchText = findViewById(R.id.search);
        searchButton = findViewById(R.id.searchButton);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchClick();
            }
        });

    }

    public void searchClick(){
        String searchString = searchText.getText().toString();
        String param = "geo:?q=";
        if (searchString.indexOf(", ") != -1 & searchString.matches("-{0,1}[0-9]{1,3}.[0-9]*\"{1} {1}" +
                                                                          "-{0,1}[0-9]{1,3}.[0-9]*")){
            param = "geo:";
        }
        Uri objectName = Uri.parse(param + searchString);
        Intent findObject = new Intent(Intent.ACTION_VIEW, objectName);
        startActivity(findObject);
    }

}

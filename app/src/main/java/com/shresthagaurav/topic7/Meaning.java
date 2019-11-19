package com.shresthagaurav.topic7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Meaning extends AppCompatActivity {
TextView tket,tvalue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meaning);
        tket=findViewById(R.id.key);
        tvalue=findViewById(R.id.value);
        Bundle bun = getIntent().getExtras();
        if(bun!=null){
            String word=bun.getString("key");
            String meaning=bun.getString("meaning");
            tket.append(word);
            tvalue.append(meaning);

        }
    }
}

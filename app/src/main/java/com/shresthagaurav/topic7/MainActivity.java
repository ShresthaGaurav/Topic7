package com.shresthagaurav.topic7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;

public class MainActivity extends AppCompatActivity {
    EditText word, meaning;
    Button btnsave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        word = findViewById(R.id.word);
        meaning = findViewById(R.id.meaning);
        btnsave = findViewById(R.id.btnsave);
        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save();

            }
        });


    }

    void save() {
        try {
            PrintStream printStream = new PrintStream(openFileOutput("word.txt", MODE_PRIVATE | MODE_APPEND));
            printStream.println(word.getText().toString() + ">" + meaning.getText().toString());
            Toast.makeText(this, "saved", Toast.LENGTH_SHORT).show();
            word.setText("");
            meaning.setText("");
        } catch (IOException e) {
            Log.d("dictionary app", "err" + e.toString());
            e.printStackTrace();
        }


    }
}

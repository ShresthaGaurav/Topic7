package com.shresthagaurav.topic7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ListSave extends AppCompatActivity {
ListView meaningList;
Map<String,String> dictionary;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_save);
        meaningList=findViewById(R.id.ListV);
        dictionary = new HashMap<>();
        readFile();
        ArrayAdapter arrayAdapter= new ArrayAdapter(
                this,android.R.layout.simple_expandable_list_item_1,new ArrayList<String>(dictionary.keySet())
        );
        meaningList.setAdapter(arrayAdapter);
        meaningList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String key=parent.getItemAtPosition(position).toString();
                String meaning=dictionary.get(key);
                Intent intent = new Intent(ListSave.this,Meaning.class);
                intent.putExtra("key",key);
                intent.putExtra("meaning",meaning);
                startActivity(intent);

            }
        });
    }
    void readFile(){
        try {
            FileInputStream fis= openFileInput("word.txt");
            InputStreamReader isr= new InputStreamReader(fis);
            BufferedReader br= new BufferedReader(isr);
            String line="";
            while((line=br.readLine())!=null){
                String[] parts = line.split(">");
                dictionary.put(parts[0],parts[1]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

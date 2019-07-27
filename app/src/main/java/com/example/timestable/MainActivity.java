package com.example.timestable;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);
        listView = (ListView) findViewById(R.id.listView);

        seekBar.setMax(20);
        seekBar.setProgress(10);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                //Below we just do all that because we don't have option to set min seekBar value

                int min = 1;
                int timesTable;


                if(progress < min){

                    timesTable = min;
                    seekBar.setProgress(timesTable);

                }else {
                    timesTable = progress;
                }

                listGenerator(timesTable);

            }


            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        listGenerator(10);

    }


    public void listGenerator(int timesTable){

        List<String> table = new ArrayList<String>();

        for(int i = 1; i<=10 ; i++){

            table.add(timesTable + " * " + i + " = " +Integer.toString(i*timesTable));

        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, table);

        listView.setAdapter(arrayAdapter);
    }


}
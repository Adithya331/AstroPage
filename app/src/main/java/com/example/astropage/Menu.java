package com.example.astropage;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TableRow;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class Menu extends AppCompatActivity {

    private TableRow selectedRow;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TableRow home = findViewById(R.id.home);
        TableRow seeInstructions = findViewById(R.id.see_instructions);
        TableRow pauseSession = findViewById(R.id.pause_session);
        TableRow transferSession = findViewById(R.id.transfer_session);
        TableRow summary = findViewById(R.id.summary);
        TableRow logOut = findViewById(R.id.log_out);

        home.setOnClickListener(rowOnClickListener);
        seeInstructions.setOnClickListener(rowOnClickListener);
        pauseSession.setOnClickListener(rowOnClickListener);
        transferSession.setOnClickListener(rowOnClickListener);
        summary.setOnClickListener(rowOnClickListener);
        logOut.setOnClickListener(rowOnClickListener);
    }

    public final View.OnClickListener rowOnClickListener = new View.OnClickListener() {
        @SuppressLint("ResourceAsColor")
        public void onClick(View v) {
            if (selectedRow != null) {
                selectedRow.setBackgroundColor(Color.TRANSPARENT);
                selectedRow.getChildAt(0).setBackgroundResource(R.drawable.unselected_item);
            }

            selectedRow = (TableRow) v;
            int myColor = ContextCompat.getColor(Menu.this, R.color.selected_row);
            selectedRow.setBackgroundColor(myColor);
            selectedRow.getChildAt(0).setBackgroundResource(R.drawable.selected_item);
        }
    };
}

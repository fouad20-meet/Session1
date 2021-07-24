package com.example.session1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView textView;
    private EditText editText;
    private Button minus,plus,check;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        editText = findViewById(R.id.editText);

        check = findViewById(R.id.check);
        minus = findViewById(R.id.minus);
        plus = findViewById(R.id.plus);
        minus.setOnClickListener(this);
        plus.setOnClickListener(this);
        check.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view==minus){
            String num = ""+(Integer.parseInt(textView.getText().toString())-1);
            textView.setText(num);
        }
        if (view==plus){
            String num = ""+(Integer.parseInt(textView.getText().toString())+1);
            textView.setText(num);
        }
        if (check==view){
            if (textView.getText().toString().equals(editText.getText().toString())) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);

                // Set a title for alert dialog
                builder.setTitle("Set to 0?");

                // Set the alert dialog yes button click listener
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        textView.setText("0");
                    }
                });

                // Set the alert dialog no button click listener
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                AlertDialog dialog = builder.create();
                // Display the alert dialog on interface
                dialog.show();
            }
            else
                Toast.makeText(this,"Don't match",Toast.LENGTH_LONG).show();
        }
    }
}
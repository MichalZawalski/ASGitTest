package com.example.myfirstapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {
    private StatusControl status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        // Capture the layout's TextView and set the string as its text
        TextView textView = (TextView) findViewById(R.id.textView);

        textView.setText("Witaj " + MainActivity.getLogin());

        status = StatusControl.getInstance();
        status.displayStatus((TextView) findViewById(R.id.statusField));
    }

    public void statusList(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(DisplayMessageActivity.this);

        builder.setItems(status.getStatusList(), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                status.setStatus(which);
                status.displayStatus((TextView) findViewById(R.id.statusField));
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();

        return;
    }

    public void openSettings(View view) {
        Intent intent = new Intent(this, Settings.class);
        startActivity(intent);
    }
}

package com.example.saisankar.uicontrolexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class DisplayActivity extends AppCompatActivity {
    TextView display_name,display_email,display_type,display_number;
    DBHelper helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        display_name = findViewById(R.id.id_display_name);
        display_email = findViewById(R.id.id_display_email);
        display_number = findViewById(R.id.id_display_number);
        display_type = findViewById(R.id.id_display_type);
        helper = new DBHelper(this,null,null,0);
        Contact contact = helper.getData();
        if(contact!=null){
            display_name.setText(contact.getContact_name());
            display_number.setText(contact.getContact_number());
            display_type.setText(contact.getContact_type());
            display_email.setText(contact.getContact_email());
        }
        else{
            Toast.makeText(this, "No contacts are saved", Toast.LENGTH_SHORT).show();
        }

        
    }

    public void createContact(View view) {
        Intent intent;
        intent=new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}

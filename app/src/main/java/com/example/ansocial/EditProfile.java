package com.example.ansocial;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.firestore.FirebaseFirestore;

public class EditProfile extends AppCompatActivity {
    // Access a Cloud Firestore instance from your Activity
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    EditText fullName, displayName, email, phone, location, occupation, bio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater  = getMenuInflater();
        menuInflater.inflate(R.menu.edit_profile_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_save_profile:
                startActivity(new Intent(EditProfile.this, ProfileActivity.class));
                Toast.makeText(this, "Profile Updated", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_cancel:
                startActivity(new Intent(EditProfile.this, FirebaseUIActivity.class));
                Toast.makeText(this, "Edit operation cancelled", Toast.LENGTH_SHORT).show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //Grab views
    public void saveProfile(View view){
        fullName = findViewById(R.id.edit_full_name);
        displayName = findViewById(R.id.edit_display_name);
        email = findViewById(R.id.edit_email_address);
        phone = findViewById(R.id.edit_phone_number);
        location = findViewById(R.id.edit_location);
        occupation = findViewById(R.id.edit_occupation);
        bio = findViewById(R.id.edit_bio);

        //Get strings
        String fullNameText = fullName.getText().toString();
        String displayNameText = displayName.getText().toString();
        String emailText = email.getText().toString();
        String phoneText = phone.getText().toString();
        String locationText = location.getText().toString();
        String occupationText = occupation.getText().toString();
        String bioText = bio.getText().toString();

    }

    //Cleans our input text when the user information is sent to the database
//    Clear our text fields after save/cancel
    /*private void clean() {
        textTitle.setText("");
        textPrice.setText("");
        textDescription.setText("");
        textTitle.requestFocus();

    }*/
}

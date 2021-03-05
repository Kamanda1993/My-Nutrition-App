package com.example.mynutritionapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ViewusersActivity extends AppCompatActivity {
    ArrayList<NutriUser> nutriUsers;
    RecyclerView mRecyclerUsers;
    CustomAdapter adapter;
    ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewusers);

        dialog = new ProgressDialog(this);
        dialog.setTitle("Loading");
        dialog.setMessage("Kindly wait...");

        nutriUsers = new ArrayList<>();
        mRecyclerUsers = findViewById(R.id.mRecyclerUsers);
        mRecyclerUsers.setHasFixedSize(true);
        mRecyclerUsers.setLayoutManager(new LinearLayoutManager(this));

        adapter = new CustomAdapter(this, nutriUsers);

        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("NutriUsers");

        dialog.show();
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                nutriUsers.clear();
                for (DataSnapshot Snap : snapshot.getChildren()) {
                    NutriUser nutriUser = Snap.getValue(NutriUser.class);
                    nutriUsers.add(nutriUser);
                }
                adapter.notifyDataSetChanged();
                dialog.dismiss();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                message("DATABASE LOCKED", "Sorry, we couldn't access the DB. Contact your Developer for help");

            }
        });
        mRecyclerUsers.setAdapter(adapter);
    }
    public void message(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setTitle(message);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.create().show();
    }
}

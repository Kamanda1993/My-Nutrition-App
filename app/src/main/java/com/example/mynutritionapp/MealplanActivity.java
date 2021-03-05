package com.example.mynutritionapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.strictmode.CleartextNetworkViolation;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MealplanActivity extends AppCompatActivity {
        EditText mEdtFood, mEdtFruit;
        Button mBtnSave, mBtnView;
        String food;
        String fruit;
        ProgressDialog dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mealplan);

        mEdtFood = findViewById(R.id.edt_food);
        mEdtFruit = findViewById(R.id.edt_fruit);

        mBtnSave = findViewById(R.id.btn_save);
        mBtnView = findViewById(R.id.btn_view);

        dialog = new ProgressDialog(this);
        dialog.setTitle("Saving");
        dialog.setMessage("Please Wait...");


        mBtnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //start by receiving data from the user
                String Food, Fruit;
                Food = mEdtFood.getText().toString();
                Fruit = mEdtFruit.getText().toString();

                if (Food.isEmpty()){
                    mEdtFood.setError("Please enter food");
                }else if (Fruit.isEmpty()){
                    mEdtFruit.setError("Please enter fruit");
                }else {
                    //connect to our table/child
                    long time = System.currentTimeMillis();
                    DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("NutriUsers/"+time);
                    NutriUser nutriUser = new NutriUser(String.valueOf(Food),String.valueOf(Fruit),String.valueOf(time));
                    dialog.show();
                    ref.setValue(nutriUser).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            dialog.dismiss();
                            if (task.isSuccessful()) {
                            message("BRAVO", "Saving Done");
                            clear();
                        } else {
                                message("FAILED", "Saving failed");
                            }

                        }
                    });
                }

            }
        });

        mBtnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),ViewusersActivity.class));
            }
        });

    }
    public void message(String title, String message){
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
    public void clear(){
        mEdtFood.setText("");
        mEdtFruit.setText("");
    }
}
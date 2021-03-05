package com.example.mynutritionapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class NotebookActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notebook);

        EditText edNote, edComment;
        TextView txtnote, txtcomment;
        Button btnsaveview;

        edNote = (EditText) findViewById(R.id.ednote);
        edComment = (EditText) findViewById(R.id.edcomment);
        
        txtnote = (TextView) findViewById(R.id.txtnote);
        txtcomment = (TextView) findViewById(R.id.txtcomment);

        btnsaveview = (Button) findViewById(R.id.btnsaveview);


        //setting on click listeners on buttons
        btnsaveview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String note, comment;

                //get note and comment from users
                note = edNote.getText().toString().trim();
                comment = edComment.getText().toString().trim();

                if (note.isEmpty()) {
                    edNote.setError("Please add Note");
                } else if (comment.isEmpty()) {
                    edComment.setError("Please place a Comment");

                }
                txtnote.setText(edNote.getText().toString().trim());
                txtcomment.setText(edComment.getText().toString().trim());
            }

        });

    }


}
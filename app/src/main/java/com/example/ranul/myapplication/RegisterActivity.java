package com.example.ranul.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ranul.myapplication.DB.DatabaseHelper;

public class RegisterActivity extends AppCompatActivity {

    DatabaseHelper myDb;
    EditText editname, editemail, editmobile, editpassword;
    Button regisBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //Call the constructor of DatabaseHelper Class
        myDb = new DatabaseHelper(this);

        //cast variables
        editname     = (EditText)findViewById(R.id.editName);
        editemail    = (EditText)findViewById(R.id.editE_mail);
        editmobile   = (EditText)findViewById(R.id.editMobile);
        editpassword = (EditText)findViewById(R.id.editPassword);
        regisBtn     = (Button) findViewById(R.id.registBtn);

        addData();
    }

    public void addData(){
        regisBtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        boolean isInserted = myDb.insertData(editname.getText().toString(), editemail.getText().toString(),
                                editmobile.getText().toString(), editpassword.getText().toString());

                        if (isInserted=true)
                            Toast.makeText(RegisterActivity.this, "Successfully Registered !", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(RegisterActivity.this, "ERROR !", Toast.LENGTH_LONG).show();
                    }

                });
    }
}

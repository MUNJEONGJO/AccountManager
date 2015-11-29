package com.example.jomunjeong.hello;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

//test
public class LoginActivity extends AppCompatActivity {

    private TextInputLayout passwordWrapper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        passwordWrapper = (TextInputLayout) findViewById(R.id.passwordWrapper);

        passwordWrapper.setHint("Password");

    }

    public void onButton1Clicked(View v){


        if(passwordWrapper != null){

            String pw = passwordWrapper.getEditText().getText().toString();

            if(pw.equals("")) {
                Toast.makeText(getApplicationContext(), "값을 입력해주세요", Toast.LENGTH_LONG).show();

            } else {


                String dbPW = "";

                SQLiteHandler handler = SQLiteHandler.open(getApplicationContext());
                // 데이터 검색
                Cursor c = handler.select_Account();
                while(c.moveToNext()) {
                    dbPW = c.getString(c.getColumnIndex("pw"));
                }//end while

                Log.i("태그", dbPW);

                if(dbPW.equals("")){
                    handler.insert_update_Master(pw);
                    handler.close();

                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);

                    startActivity(intent);
                } else if (dbPW.equals(pw)){

                    handler.close();

                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);

                    startActivity(intent);
                } else {

                    handler.close();
                }
            }
        }
    }
}

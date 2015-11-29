package com.example.jomunjeong.hello;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

public class AddAccountActivity extends AppCompatActivity {


    private TextInputLayout sitenameWrapper;
    private TextInputLayout urlWrapper;
    private TextInputLayout idWrapper;
    private TextInputLayout pwWrapper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_account);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        sitenameWrapper = (TextInputLayout) findViewById(R.id.sitenameWrapper);
        urlWrapper = (TextInputLayout) findViewById(R.id.urlWrapper);
        idWrapper = (TextInputLayout) findViewById(R.id.idWrapper);
        pwWrapper = (TextInputLayout) findViewById(R.id.pwWrapper);

        sitenameWrapper.setHint("사이트명");
        urlWrapper.setHint("url");
        idWrapper.setHint("아이디");
        pwWrapper.setHint("비밀번호");
    }

    public void onSaveClicked(View v){


        if(sitenameWrapper != null && urlWrapper != null && idWrapper != null && pwWrapper != null){

            String sitename = sitenameWrapper.getEditText().getText().toString();
            String url = urlWrapper.getEditText().getText().toString();
            String id = idWrapper.getEditText().getText().toString();
            String pw = pwWrapper.getEditText().getText().toString();

            if(sitename.equals("") || url.equals("") || id.equals("") || pw.equals("")) {
                Toast.makeText(getApplicationContext(), "값을 입력해주세요", Toast.LENGTH_LONG).show();

            } else {

                SQLiteHandler handler = SQLiteHandler.open(getApplicationContext());
                Account account = new Account(sitename, url, id, pw);
                handler.insert_Account(account);
                handler.close();

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);

                startActivity(intent);

            }
        }
    }
}

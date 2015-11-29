package com.example.jomunjeong.hello;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Account> accounts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupToolbar();

        RecyclerView rv = (RecyclerView)findViewById(R.id.rv);
        //rv.setHasFixedSize(true);


        accounts = new ArrayList<>();

        SQLiteHandler handler = SQLiteHandler.open(getApplicationContext());
        // 데이터 검색
        Cursor c = handler.select_Account();
        while(c.moveToNext()) {
            Account account = new Account();
            account.siteName = c.getString(c.getColumnIndex("siteName"));
            account.url = c.getString(c.getColumnIndex("url"));
            account.id = c.getString(c.getColumnIndex("id"));
            account.pw = c.getString(c.getColumnIndex("pw"));
            accounts.add(account);
        }//end while

        handler.close();

        if(accounts != null){

            //accounts = Account.initializeData();
            RVAdapter adapter = new RVAdapter(accounts);
            rv.setAdapter(adapter);
            rv.setLayoutManager(new LinearLayoutManager(this));

        }

    }

    private void setupToolbar(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Show menu icon
        final ActionBar ab = getSupportActionBar();
        ab.setHomeAsUpIndicator(R.drawable.ic_menu);
        ab.setDisplayHomeAsUpEnabled(true);
    }


    public void onFloatingActionButtonClicked(View v){

        //Toast.makeText(getApplicationContext(), "버튼이 눌렸어요.", Toast.LENGTH_LONG).show();

        //Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://m.naver.com"));
        Intent intent = new Intent(getApplicationContext(), AddAccountActivity.class);

        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

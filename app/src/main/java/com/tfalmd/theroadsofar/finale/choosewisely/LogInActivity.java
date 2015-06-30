package com.tfalmd.theroadsofar.finale.choosewisely;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.tfalmd.theroadsofar.finale.choosewisely.dialog.RegisterDialog;
import com.tfalmd.theroadsofar.finale.choosewisely.model.Hero;
import com.tfalmd.theroadsofar.finale.choosewisely.model.dao.HeroDao;


public class LogInActivity extends ActionBarActivity implements RegisterDialog.RegisterListiner{

    private HeroDao hd = new HeroDao(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        Button login = (Button) findViewById(R.id.btnLogIn);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText name = (EditText) findViewById(R.id.etLogin);

                if (hd.find(name.getText().toString()) != null) {
                    Intent intent = new Intent(LogInActivity.this, MainActivity.class);
                    intent.putExtra("user", name.getText().toString());
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Usuário invalido", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_log_in, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_register:
                RegisterDialog rd = new RegisterDialog();
                rd.show(getFragmentManager(), null);
                return true;
            case R.id.action_about:
                Intent intent = new Intent(LogInActivity.this, AboutActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onDialogPositiveClick(String name) {
        Hero h = new Hero(0, name, 0);
        hd.create(h);
    }
}
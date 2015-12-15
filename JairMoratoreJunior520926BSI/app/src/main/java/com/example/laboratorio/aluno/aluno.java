package com.example.laboratorio.aluno;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.Parse;
import com.parse.ParseAnalytics;

import static android.view.View.*;


public class aluno extends Activity {
    EditText editTextUsuario;
    EditText editTextSenha;
    Button buttonLogar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aluno);

        buttonLogar = (Button) findViewById(R.id.buttonLogar);
        editTextUsuario = (EditText) findViewById(R.id.editTextUsuario);
        editTextSenha = (EditText) findViewById(R.id.editTextSenha);
        buttonLogar.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                logar();           }
        });

        ParseAnalytics.trackAppOpenedInBackground(getIntent());
        Parse.enableLocalDatastore(this);
        Parse.initialize(this,"4ccEeTfMXUdCInCihW9L9UBzsA4ifIlimhaB32ZA","6MFYrXz87oh2UoSn1lcydSVvNDpYob0Nhtn6dMUa");

    }


    public void logar(){
        String usuario = editTextUsuario.getText().toString();
        String senha = editTextSenha.getText().toString();
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(getApplicationContext(), usuario, duration);
        toast.show();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_aluno, menu);
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

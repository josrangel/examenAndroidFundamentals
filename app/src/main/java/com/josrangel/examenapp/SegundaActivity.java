package com.josrangel.examenapp;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class SegundaActivity extends AppCompatActivity {

    String valorBoton;
    TextView tvMuestra;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);
        tvMuestra = findViewById(R.id.tvMuestra);
    }

    public void ingles(View v){
        Toast.makeText(this,R.string.btnHola,Toast.LENGTH_SHORT).show();
        valorBoton="ingles";
        tvMuestra.setText(valorBoton);
    }

    public void espanol(View v){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setMessage(R.string.mensaje_alerta)
                .setTitle(R.string.titulo_alerta);

        AlertDialog dialog = builder.create();
        dialog.show();
        valorBoton="espanol";
        tvMuestra.setText(valorBoton);
    }

    public void regresa(View v){
        Intent returnIntent = new Intent();
        returnIntent.putExtra("result",valorBoton);
        setResult(Activity.RESULT_OK,returnIntent);
        finish();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("valorBoton",valorBoton);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        tvMuestra.setText(savedInstanceState.getString("valorBoton"));
    }
}
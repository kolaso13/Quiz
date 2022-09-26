package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private int botonesRespuestas[] = {
            R.id.respuesta1,R.id.respuesta2,R.id.respuesta3,R.id.respuesta4
    };
    private int pregunta = 0;
    private String correcto, textoBoton;
    Button res1, res2, res3, res4, btnContinuar;
    ImageButton leon, ardilla, tortuga, panda;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        getResources().getStringArray(R.array.preguntas);

        correcto = mostrarPregunta(pregunta);

        btnContinuar = findViewById(R.id.continuar);

        res1 = findViewById(R.id.respuesta1);
        res2 = findViewById(R.id.respuesta2);
        res3 = findViewById(R.id.respuesta3);
        res4 = findViewById(R.id.respuesta4);
        leon= findViewById(R.id.leon);
        ardilla = findViewById(R.id.ardilla);
        tortuga = findViewById(R.id.tortuga);
        panda = findViewById(R.id.panda);

        leon.setVisibility(View.GONE);
        ardilla.setVisibility(View.GONE);
        tortuga.setVisibility(View.GONE);
        panda.setVisibility(View.GONE);

        btnContinuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (pregunta != getResources().getStringArray(R.array.preguntas).length-1){
                    pregunta++;
                    correcto = mostrarPregunta(pregunta);
                }
                else if(pregunta != getResources().getStringArray(R.array.preguntas).length){
                    mostrarImgenes();
                }
                res1.setBackgroundColor(Color.parseColor("#FF6200ee"));
                res2.setBackgroundColor(Color.parseColor("#FF6200ee"));
                res3.setBackgroundColor(Color.parseColor("#FF6200ee"));
                res4.setBackgroundColor(Color.parseColor("#FF6200ee"));
            }
        });

        res1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textoBoton = (String) res1.getText();
                if (Objects.equals(correcto, textoBoton)){
                    Toast.makeText(MainActivity.this, "Correcto", Toast.LENGTH_SHORT).show();
                    res1.setBackgroundColor(Color.parseColor("#31C000"));
                }else {
                    Toast.makeText(MainActivity.this, "Incorrecto", Toast.LENGTH_SHORT).show();
                    res1.setBackgroundColor(Color.parseColor("#CD0000"));
                }
                Log.i("Correcto",correcto);
                Log.i("Texto",textoBoton);
            }
        });
        res2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textoBoton = (String) res2.getText();
                if (Objects.equals(correcto, textoBoton)){
                    Toast.makeText(MainActivity.this, "Correcto", Toast.LENGTH_SHORT).show();
                    res2.setBackgroundColor(Color.parseColor("#31C000"));
                }else {
                    Toast.makeText(MainActivity.this, "Incorrecto", Toast.LENGTH_SHORT).show();
                    res2.setBackgroundColor(Color.parseColor("#CD0000"));
                }
            }
        });
        res3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textoBoton = (String) res3.getText();
                if (Objects.equals(correcto, textoBoton)){
                    Toast.makeText(MainActivity.this, "Correcto", Toast.LENGTH_SHORT).show();
                    res3.setBackgroundColor(Color.parseColor("#31C000"));
                }else {
                    Toast.makeText(MainActivity.this, "Incorrecto", Toast.LENGTH_SHORT).show();
                    res3.setBackgroundColor(Color.parseColor("#CD0000"));
                }
            }
        });
        res4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textoBoton = (String) res4.getText();
                if (Objects.equals(correcto, textoBoton)){
                    Toast.makeText(MainActivity.this, "Correcto", Toast.LENGTH_SHORT).show();
                    res4.setBackgroundColor(Color.parseColor("#31C000"));
                }else {
                    Toast.makeText(MainActivity.this, "Incorrecto", Toast.LENGTH_SHORT).show();
                    res4.setBackgroundColor(Color.parseColor("#CD0000"));
                }
            }
        });
        panda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Correcto", Toast.LENGTH_SHORT).show();
            }
        });
        leon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Incorrecto", Toast.LENGTH_SHORT).show();
            }
        });
        tortuga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Incorrecto", Toast.LENGTH_SHORT).show();
            }
        });
        ardilla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Incorrecto", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void mostrarImgenes() {
        res1.setVisibility(View.GONE);
        res2.setVisibility(View.GONE);
        res3.setVisibility(View.GONE);
        res4.setVisibility(View.GONE);

        leon.setVisibility(View.VISIBLE);
        ardilla.setVisibility(View.VISIBLE);
        tortuga.setVisibility(View.VISIBLE);
        panda.setVisibility(View.VISIBLE);
        TextView pregunta = (TextView) findViewById(R.id.pregunta);
        pregunta.setText(getString(R.string.preguntaImg));
    }

    private String mostrarPregunta(int num){
        String[] preguntas = getResources().getStringArray(R.array.preguntas);
        String[] opcion = preguntas[num].split(";");
        TextView text_pregunta = (TextView) findViewById(R.id.pregunta);
        text_pregunta.setText(opcion[0]);
        String correcto = "";
        for (int x = 0; x < opcion.length-1;x++){
            Log.i("s",opcion[x]);
            TextView text_resp = (TextView) findViewById(botonesRespuestas[x]);
            if (x == 0){
                if (opcion[x+1].charAt(0) == '*'){
                    text_resp.setText(opcion[x+1].substring(1));
                    correcto = opcion[x+1].substring(1);
                }else {
                    text_resp.setText(opcion[x+1]);
                }
            }else{
                if (opcion[x+1].charAt(0) == '*'){
                    text_resp.setText(opcion[x+1].substring(1));
                    correcto = opcion[x+1].substring(1);
                }else {
                    text_resp.setText(opcion[x+1]);
                }
            }
        }
        return correcto;
    }
}
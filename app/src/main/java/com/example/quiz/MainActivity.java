package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private int botonesRespuestas[] = {
            R.id.respuesta1,R.id.respuesta2,R.id.respuesta3,R.id.respuesta4
    };
    private int rescorrectas=0, resincorrectas=0, preguntaactual = 0;
    int red = Color.argb(100, 255,0,0);
    int green = Color.argb(100, 0,255,0);
    int transparent = Color.argb(0, 0,0,0);
    private int pregunta = 0;
    private String correcto, textoBoton;
    TextToSpeech textToSpeech;
    MediaPlayer vegetta, perowilly, mpFin;
    Button res1, res2, res3, res4, btnContinuar, btnReiniciar, btnFinalizar, btncambio;
    ImageButton leon, ardilla, tortuga, panda;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        getResources().getStringArray(R.array.preguntas);

        correcto = mostrarPregunta(pregunta);
        btnReiniciar =findViewById(R.id.reiniciar);
        btnContinuar = findViewById(R.id.continuar);
        btnFinalizar = findViewById(R.id.check);
        btncambio= findViewById(R.id.cambiar);

        vegetta = MediaPlayer.create(this, R.raw.vegettaintro);
        perowilly = MediaPlayer.create(this, R.raw.perowilly);

        res1 = findViewById(R.id.respuesta1);
        res2 = findViewById(R.id.respuesta2);
        res3 = findViewById(R.id.respuesta3);
        res4 = findViewById(R.id.respuesta4);
        leon= findViewById(R.id.leon);
        ardilla = findViewById(R.id.ardilla);
        tortuga = findViewById(R.id.tortuga);
        panda = findViewById(R.id.panda);

        btnFinalizar.setVisibility(View.GONE);
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

                res1.setClickable(true);
                res2.setClickable(true);
                res3.setClickable(true);
                res4.setClickable(true);


            }
        });

        btnReiniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Activity Acti = MainActivity.this;
                Acti.recreate();
            }
        });

        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                leon.setVisibility(View.GONE);
                ardilla.setVisibility(View.GONE);
                tortuga.setVisibility(View.GONE);
                panda.setVisibility(View.GONE);
                btnFinalizar.setVisibility(View.GONE);
                btnContinuar.setVisibility(View.GONE);
                res1.setVisibility(View.GONE);
                res2.setVisibility(View.GONE);
                res3.setVisibility(View.GONE);
                res4.setVisibility(View.GONE);
                TextView text_pregunta =  findViewById(R.id.pregunta);
                text_pregunta.setText(getString(R.string.resultado));
                TextView correctoTV = findViewById(R.id.correcto);
                TextView incorrectoTV = findViewById(R.id.incorrecto);
                correctoTV.setText("Respuestas Correctas"+ rescorrectas);
                incorrectoTV.setText("Respuestas Inorrectas"+ resincorrectas);
            }
        });

        btncambio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });

        res1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textoBoton = (String) res1.getText();
                if (Objects.equals(correcto, textoBoton)){
                    Toast.makeText(MainActivity.this, "Correcto", Toast.LENGTH_SHORT).show();
                    res1.setBackgroundColor(Color.parseColor("#31C000"));
                    rescorrectas++;
                    vegetta.start();
                }else {
                    Toast.makeText(MainActivity.this, "Incorrecto", Toast.LENGTH_SHORT).show();
                    res1.setBackgroundColor(Color.parseColor("#CD0000"));
                    resincorrectas++;
                    perowilly.start();
                }
                res1.setClickable(false);
                res2.setClickable(false);
                res3.setClickable(false);
                res4.setClickable(false);
            }
        });
        res2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textoBoton = (String) res2.getText();
                if (Objects.equals(correcto, textoBoton)){
                    Toast.makeText(MainActivity.this, "Correcto", Toast.LENGTH_SHORT).show();
                    res2.setBackgroundColor(Color.parseColor("#31C000"));
                    rescorrectas++;
                    vegetta.start();
                }else {
                    Toast.makeText(MainActivity.this, "Incorrecto", Toast.LENGTH_SHORT).show();
                    res2.setBackgroundColor(Color.parseColor("#CD0000"));
                    resincorrectas++;
                    perowilly.start();
                }
                res2.setClickable(false);
                res1.setClickable(false);
                res3.setClickable(false);
                res4.setClickable(false);
            }
        });
        res3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textoBoton = (String) res3.getText();
                if (Objects.equals(correcto, textoBoton)){
                    Toast.makeText(MainActivity.this, "Correcto", Toast.LENGTH_SHORT).show();
                    res3.setBackgroundColor(Color.parseColor("#31C000"));
                    rescorrectas++;
                    vegetta.start();
                }else {
                    Toast.makeText(MainActivity.this, "Incorrecto", Toast.LENGTH_SHORT).show();
                    res3.setBackgroundColor(Color.parseColor("#CD0000"));
                    resincorrectas++;
                    perowilly.start();
                }
                res3.setClickable(false);
                res1.setClickable(false);
                res2.setClickable(false);
                res4.setClickable(false);
            }
        });
        res4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textoBoton = (String) res4.getText();
                if (Objects.equals(correcto, textoBoton)){
                    Toast.makeText(MainActivity.this, "Correcto", Toast.LENGTH_SHORT).show();
                    res4.setBackgroundColor(Color.parseColor("#31C000"));
                    rescorrectas++;
                    vegetta.start();
                }else {
                    Toast.makeText(MainActivity.this, "Incorrecto", Toast.LENGTH_SHORT).show();
                    res4.setBackgroundColor(Color.parseColor("#CD0000"));
                    resincorrectas++;
                    perowilly.start();
                }
                res4.setClickable(false);
                res1.setClickable(false);
                res2.setClickable(false);
                res3.setClickable(false);
            }
        });

        panda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                panda.setColorFilter(green);
                panda.setClickable(false);
                leon.setClickable(false);
                tortuga.setClickable(false);
                ardilla.setClickable(false);
                rescorrectas++;
                vegetta.start();
            }
        });
        leon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resincorrectas++;
                leon.setColorFilter(red);
                panda.setClickable(false);
                leon.setClickable(false);
                tortuga.setClickable(false);
                ardilla.setClickable(false);
                perowilly.start();
            }
        });
        tortuga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resincorrectas++;
                tortuga.setColorFilter(red);
                panda.setClickable(false);
                leon.setClickable(false);
                tortuga.setClickable(false);
                ardilla.setClickable(false);
                perowilly.start();
            }
        });
        ardilla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resincorrectas++;
                ardilla.setColorFilter(red);
                panda.setClickable(false);
                leon.setClickable(false);
                tortuga.setClickable(false);
                ardilla.setClickable(false);
                perowilly.start();
            }
        });

        textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                // if No error is found then only it will run
                if(i!=TextToSpeech.ERROR){
                    // To Choose language of speech
                    textToSpeech.setLanguage(Locale.UK);
                }
            }
        });

        TextView textPreguntas = (TextView) findViewById(R.id.pregunta);
        textPreguntas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textToSpeech.speak(textPreguntas.getText().toString(),TextToSpeech.QUEUE_FLUSH,null);
            }
        });
    }

    private void mostrarImgenes() {
        res1.setVisibility(View.GONE);
        res2.setVisibility(View.GONE);
        res3.setVisibility(View.GONE);
        res4.setVisibility(View.GONE);
        btnContinuar.setVisibility(View.GONE);
        pregunta++;
        btnFinalizar.setVisibility(View.VISIBLE);
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
        TextView text_pregunta =  findViewById(R.id.pregunta);
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
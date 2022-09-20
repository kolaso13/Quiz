package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int idRespuestas[] = {
        R.id.respuesta1,R.id.respuesta2,R.id.respuesta3,R.id.respuesta4
    };
    private int correcta;
    private int preguntaActual;
    private String[] preguntas;
    private TextView text_question;
    private RadioGroup group;
    private boolean[] respuesta_correcta;
    private Button botonContinuar, botonAnterior;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text_question = (TextView) findViewById(R.id.pregunta);
        group = (RadioGroup) findViewById(R.id.gruporespuestas);
        botonContinuar = (Button) findViewById(R.id.check);
        botonAnterior = (Button) findViewById(R.id.anterior);

        preguntas = getResources().getStringArray(R.array.preguntas);
        respuesta_correcta = new boolean[preguntas.length];
        preguntaActual=0;
        mostrarPregunta();

        botonContinuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = group.getCheckedRadioButtonId();
                int answer= -1;
                for (int i=0; i < idRespuestas.length;i++){
                    if(idRespuestas[i] == id){
                        answer = i;
                    }
                }

                respuesta_correcta[preguntaActual] = (answer == correcta);
                if(preguntaActual < preguntas.length-1){
                    preguntaActual++;
                    mostrarPregunta();
                }else{
                    int correctas = 0, incorrectas = 0;
                    for(boolean b: respuesta_correcta){
                      if (b) correctas++;
                      else incorrectas++;
                    }
                    String resultados = String.format("Correctas: %d -- Incorrectas: %d",correctas,incorrectas);
                    Toast.makeText(MainActivity.this, resultados, Toast.LENGTH_LONG).show();
                }
            }
        });
        botonAnterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(preguntaActual > 0){
                    preguntaActual--;
                    mostrarPregunta();
                }
            }
        });
    }

    private void mostrarPregunta() {
        String q = preguntas[preguntaActual];
        String[] partes = q.split(";");

        group.clearCheck();
        text_question.setText(partes[0]);
        for(int i=0;i<idRespuestas.length;i++){
            RadioButton rb = (RadioButton) findViewById(idRespuestas[i]);
            String respuesta = partes[i+1];
            if(respuesta.charAt(0) == '*'){
                correcta = i;
                respuesta = respuesta.substring(1);
            }
            rb.setText(respuesta);
        }
        if(preguntaActual == 0){
            botonAnterior.setVisibility(View.GONE);
        }else{
            botonAnterior.setVisibility(View.VISIBLE);
        }
        if(preguntaActual == preguntas.length-1){
            botonContinuar.setText(R.string.check);
        }
    }
}
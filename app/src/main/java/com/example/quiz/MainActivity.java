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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView text_question = (TextView) findViewById(R.id.pregunta);
        text_question.setText(R.string.pregunta);

        String[] respuestas = getResources().getStringArray(R.array.respuestas);
        for(int i=0;i<idRespuestas.length;i++){
            RadioButton rb = (RadioButton) findViewById(idRespuestas[i]);
            rb.setText(respuestas[i]);
        }

        final int correcta = getResources().getInteger(R.integer.correcto);
        final RadioGroup group = (RadioGroup) findViewById(R.id.gruporespuestas);
        Button check = (Button) findViewById(R.id.check);
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = group.getCheckedRadioButtonId();
                int answer= -1;
                for (int i=0; i < idRespuestas.length;i++){
                    if(idRespuestas[i] == id){
                        answer = i;
                    }

                }
                if(answer == correcta){
                    Toast.makeText(MainActivity.this, R.string.correctolabel, Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, R.string.incorrectolabel, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
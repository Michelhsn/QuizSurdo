package com.example.swchallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Quizz extends AppCompatActivity {

    ImageView pergunta;
    String respostaCerta = "";
    Integer pontos = 0;
    List<Questoes> questoes = new ArrayList<Questoes>(){
        {
            add(new Questoes(R.drawable.casa, "casa"));
            add(new Questoes(R.drawable.demorar, "demorar"));
            add(new Questoes(R.drawable.bobo, "bobo"));
            add(new Questoes(R.drawable.obrigado, "obrigado"));
            add(new Questoes(R.drawable.porque, "porque"));
            add(new Questoes(R.drawable.beleza, "bonito"));
            add(new Questoes(R.drawable.posso, "poder"));
            add(new Questoes(R.drawable.velho, "velho"));
            add(new Questoes(R.drawable.zero, "zero"));
            add(new Questoes(R.drawable.saudade, "saudade"));
        }
    };

    private void carregarQuestao(){
        if(questoes.size()>0){
            Questoes q = questoes.remove(0);
            pergunta.setImageResource(q.getPergunta());
            respostaCerta = q.getRespostaCerta();
        }
        else{ //acabaram as questões
            Intent intent = new Intent(this, Resposta.class);
            intent.putExtra("pontos", pontos);
            startActivity(intent);
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizz);
        getSupportActionBar().hide();
        pergunta = (ImageView) findViewById(R.id.pergunta);
        carregarQuestao();
    }

    public void responder(View v){
        TextView resposta = (TextView) findViewById(R.id.resposta);

        Intent intent = new Intent(this, Resposta.class);
        if (resposta.getText().toString().equals(respostaCerta)){
            pontos++;
        }
        intent.putExtra("acertou", resposta.getText().toString().equals(respostaCerta));
        intent.putExtra("pontos", pontos);
        resposta.setText("");
        startActivity(intent);
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        carregarQuestao();

    }
}

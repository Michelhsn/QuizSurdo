package com.example.swchallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Resposta extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resposta);
        getSupportActionBar().hide();
        Button btnJogarNovamente = (Button)findViewById(R.id.jogarNovamente);
        ImageView imgResposta = (ImageView)findViewById(R.id.imgresposta);
        TextView respostaCheck = (TextView)findViewById(R.id.respostaCheck);

        Intent intent = getIntent();
        int pontos = intent.getIntExtra("pontos", 0);
        boolean acertou = intent.getBooleanExtra("acertou", false);
        if(intent.hasExtra("acertou")){
            btnJogarNovamente.setVisibility(View.INVISIBLE);
            if(acertou){
                imgResposta.setImageResource(R.drawable.acertou);
                respostaCheck.setText("");
            }
            else{
                imgResposta.setImageResource(R.drawable.errou);
                respostaCheck.setText("");
            }

            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(4000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    finish();
                }
            });
            thread.start();
        }else{
            btnJogarNovamente.setVisibility(View.VISIBLE);
            respostaCheck.setText("Fizeste " + pontos + " pontos!");

            if(pontos <= 3)
                imgResposta.setImageResource(R.drawable.faltou_muito);
            else if (pontos >3 && pontos < 10){
                imgResposta.setImageResource(R.drawable.quasela);
            }
            else
                imgResposta.setImageResource(R.drawable.acertoutudo);
        }




    }

    public void jogarNovamente(View v){
        Intent intent = new Intent(this, Quizz.class);
        startActivity(intent);
        finish();
    }


}

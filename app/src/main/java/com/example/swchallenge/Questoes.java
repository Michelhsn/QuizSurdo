package com.example.swchallenge;

import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class Questoes {

    private int pergunta;
    private List<String> respostas = new ArrayList<>();
    private String respostaCerta;

    public Questoes(int pergunta, String respostaCerta){
        this.pergunta = pergunta;
        this.respostaCerta = respostaCerta;
    }

    public int getPergunta(){ return this.pergunta; }
    public String getRespostaCerta(){ return this.respostaCerta; }
}

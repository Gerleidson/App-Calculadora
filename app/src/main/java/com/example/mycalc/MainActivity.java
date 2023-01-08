package com.example.mycalc;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button numero_zero,numero_um,numero_dois,numero_tres,numero_quatro,numero_cinco,
            numero_seis,numero_sete,numero_oito,numero_nove,ponto,soma,subtracao,multiplicacao,divisao,
    igual,limpar,backspace;

    private TextView expressao,resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IniciarComponentes();
        getSupportActionBar().hide();

        for (Button button : Arrays.asList(numero_zero, numero_um, numero_dois, numero_tres, numero_quatro, numero_cinco, numero_seis, numero_sete, numero_oito, numero_nove, ponto, soma, subtracao, multiplicacao, divisao, backspace)) {
            button.setOnClickListener(this);
        }

        limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expressao.setText("");
                resultado.setText("");
            }
        });

        backspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView txtExpressao = findViewById(R.id.expressao);
                String string = txtExpressao.getText().toString();

                if (!string.isEmpty()){
                    byte var0 = 0;
                    int var1 = string.length() -1;
                    String expressao = string.substring(var0,var1);
                    txtExpressao.setText(expressao);
                }
                resultado.setText("");
            }
        });

        igual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try{
                    Expression expression = new ExpressionBuilder(expressao.getText().toString()).build();
                    double result = expression.evaluate();
                    long longResult = (long) result;

                    if (result == (double)longResult){
                        resultado.setText((CharSequence) String.valueOf(longResult));
                    }else{
                        resultado.setText((CharSequence) String.valueOf(result));
                    }

                }catch (Exception e){

                }

            }
        });

    }
    @SuppressLint("WrongViewCast")
    private void IniciarComponentes() {
        numero_zero = findViewById(R.id.numero_zero);
        numero_um = findViewById(R.id.numero_um);
        numero_dois = findViewById(R.id.numero_dois);
        numero_tres = findViewById(R.id.numero_tres);
        numero_quatro = findViewById(R.id.numero_quatro);
        numero_cinco = findViewById(R.id.numero_cinco);
        numero_seis = findViewById(R.id.numero_seis);
        numero_sete = findViewById(R.id.numero_sete);
        numero_oito = findViewById(R.id.numero_oito);
        numero_nove = findViewById(R.id.numero_nove);
        ponto = findViewById(R.id.ponto);
        soma = findViewById(R.id.soma);
        subtracao = findViewById(R.id.subtracao);
        multiplicacao = findViewById(R.id.multiplicacao);
        divisao = findViewById(R.id.divisao);
        igual = findViewById(R.id.igual);
        limpar = findViewById(R.id.limpar);
        expressao = findViewById(R.id.expressao);
        resultado = findViewById(R.id.resultado);
        backspace = findViewById(R.id.backspace);
    }

    public void Acrescentar (String string, boolean limpar_dados){
        if(resultado.getText().equals("")){
            expressao.setText("");
        }
        if(limpar_dados){
            resultado.setText(" ");
            expressao.append(string);
        }else{
            expressao.append(resultado.getText());
            expressao.append(string);
            resultado.setText(" ");
        }
}

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.numero_zero:
                Acrescentar("0",true);
                break;
            case R.id.numero_um:
                Acrescentar("1",true);
                break;
            case R.id.numero_dois:
                Acrescentar("2",true);
                break;
            case R.id.numero_tres:
                Acrescentar("3",true);
                break;
            case R.id.numero_quatro:
                Acrescentar("4",true);
                break;
            case R.id.numero_cinco:
                Acrescentar("5",true);
                break;
            case R.id.numero_seis:
                Acrescentar("6",true);
                break;
            case R.id.numero_sete:
                Acrescentar("7",true);
                break;
            case R.id.numero_oito:
                Acrescentar("8",true);
                break;
            case R.id.numero_nove:
                Acrescentar("9",true);
                break;
            case R.id.ponto:
                Acrescentar(".",true);
                break;
            case R.id.soma:
                Acrescentar("+",false);
                break;
            case R.id.subtracao:
                Acrescentar("-",false);
                break;
            case R.id.multiplicacao:
                Acrescentar("*",false);
                break;
            case R.id.divisao:
                Acrescentar("/",false);
                break;
            case R.id.backspace:
                Acrescentar("",false);
                break;
        }
    }
}
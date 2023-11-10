package devandroid.yuri.conversordemoedas.controller;


import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.NonNull;

import devandroid.yuri.conversordemoedas.model.Pessoa;

public class PessoaController {

    TextView resultadoTextView;
    EditText valorEditText;

    Pessoa model;


    public PessoaController(EditText valorEditText,TextView resultadoTextView ){

        this.valorEditText = valorEditText;
        this.resultadoTextView = resultadoTextView;
        this.model = new Pessoa();

    }



    @NonNull
    @Override
    public String toString() {
        Log.d("MVC_Controller", "Controller Iniciado");
        return super.toString();

    }

    public void libra(){

        try{
            double valor =Double.parseDouble(valorEditText.getText().toString());
            double resultado =model.libra(valor);

            resultadoTextView.setText(String.valueOf(resultado));

        }catch (NumberFormatException e){

            exibirMensagemErro("Digite números válidos");

        }


    }
    public void euro(){

        try{
            double valor =Double.parseDouble(valorEditText.getText().toString());
            double resultado =model.euro(valor);

            resultadoTextView.setText(String.valueOf(resultado));

        }catch (NumberFormatException e){

            exibirMensagemErro("Digite números válidos");

        }

    }

    public void dolar(){

        try{
            double valor =Double.parseDouble(valorEditText.getText().toString());
            double resultado =model.dolar(valor);

            resultadoTextView.setText(String.valueOf(resultado));

        }catch (NumberFormatException e){

            exibirMensagemErro("Digite números válidos");

        }

    }

    public void peso(){

        try{
            double valor =Double.parseDouble(valorEditText.getText().toString());
            double resultado =model.peso(valor);

            resultadoTextView.setText(String.valueOf(resultado));

        }catch (NumberFormatException e){

            exibirMensagemErro("Digite números válidos");

        }

    }

    private void exibirMensagemErro(String mensagem) {
        Toast.makeText(valorEditText.getContext(), "ERRO", Toast.LENGTH_LONG).show();
    }


}

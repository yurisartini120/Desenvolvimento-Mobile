package devandroid.yuri.calculadora.controller;

import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import devandroid.yuri.calculadora.model.Pessoa;

public class PessoaController {

    private EditText numero1EditText;
    private EditText numero2EditText;
    private TextView resultadoTextView;
    private Pessoa calculadoraModel;

    public PessoaController(EditText numero1EditText, EditText numero2EditText, TextView resultadoTextView) {
        this.numero1EditText = numero1EditText;
        this.numero2EditText = numero2EditText;
        this.resultadoTextView = resultadoTextView;
        this.calculadoraModel = new Pessoa();
    }



    public void adicionar() {
        try {
            double numero1 = Double.parseDouble(numero1EditText.getText().toString());
            double numero2 = Double.parseDouble(numero2EditText.getText().toString());
            double resultado = calculadoraModel.adicionar(numero1, numero2);
            resultadoTextView.setText(String.valueOf(resultado));
        } catch (NumberFormatException e) {
            exibirMensagemErro("Digite números válidos");
        }
    }

    public void subtrair() {
        try {
            double numero1 = Double.parseDouble(numero1EditText.getText().toString());
            double numero2 = Double.parseDouble(numero2EditText.getText().toString());
            double resultado = calculadoraModel.subtrair(numero1, numero2);
            resultadoTextView.setText(String.valueOf(resultado));
        }catch (NumberFormatException e) {
                exibirMensagemErro("Digite números válidos");
            }

    }

    public void multiplicar() {
        try {
            double numero1 = Double.parseDouble(numero1EditText.getText().toString());
            double numero2 = Double.parseDouble(numero2EditText.getText().toString());
            double resultado = calculadoraModel.multiplicar(numero1, numero2);
            resultadoTextView.setText(String.valueOf(resultado));

        } catch (NumberFormatException e) {
            exibirMensagemErro("Digite números válidos");
        }
    }

    public void dividir() {
        try {
            double numero1 = Double.parseDouble(numero1EditText.getText().toString());
            double numero2 = Double.parseDouble(numero2EditText.getText().toString());
            double resultado = calculadoraModel.dividir(numero1, numero2);
            resultadoTextView.setText(String.valueOf(resultado));

        } catch (NumberFormatException e) {
            exibirMensagemErro("Digite números válidos");
        }
    }

    private void exibirMensagemErro(String mensagem) {
        Toast.makeText(numero1EditText.getContext(), "ERRO", Toast.LENGTH_LONG).show();
    }

}

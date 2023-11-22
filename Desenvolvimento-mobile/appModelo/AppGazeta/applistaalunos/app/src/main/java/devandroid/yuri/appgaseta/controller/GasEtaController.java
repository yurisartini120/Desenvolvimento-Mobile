package devandroid.yuri.appgaseta.controller;

import static devandroid.yuri.appgaseta.controller.pessoaController.new_preferences;

import android.content.SharedPreferences;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;

import devandroid.yuri.appgaseta.View.GasEtaActivity;
import devandroid.yuri.appgaseta.model.Combustivel;

public class GasEtaController {

    private EditText editGasolina;
    private EditText editEtanol;

    private TextView txtResultado;



    SharedPreferences preferences;
    SharedPreferences.Editor listaClientes;

    public GasEtaController(GasEtaActivity gasEtaActivity) {
        preferences = gasEtaActivity.getSharedPreferences(new_preferences, 0);
        listaClientes = preferences.edit();

    }

    @NonNull
    @Override
    public String toString() {
        Log.d("MVC_Controller", "Controller Iniciado");
        return super.toString();
    }

    public void limpar(){

        listaClientes.clear();
        listaClientes.apply();

    }

    public void salvar(Combustivel cliente){

        Log.d("MVC_Controller", "Dados Salvos " + toString() );


        listaClientes.putInt("Gasolina", (int) cliente.getGasolina());
        listaClientes.putInt("Etanol",(int) cliente.getEtanol());

        listaClientes.apply();

    }

    /*public void calcular(){


        try{

            double gasolina = Double.parseDouble(editGasolina.getText().toString());
            double etanol = Double.parseDouble(editEtanol.getText().toString());



            double valor = gasolina / etanol;

            if (valor <= 0.7){

                String resultado = "O melhor é abastecer com alcool";
                txtResultado.setText(String.valueOf(resultado));

            }else {

                String resultado = "O melhor é abastecer com Gasolina";
                txtResultado.setText(String.valueOf(resultado));

            }







        }catch (NumberFormatException e){
            exibirMensagemErro("Digite números válidos");


        }



    }

    private void exibirMensagemErro(String digite_números_válidos) {

        Toast.makeText(editGasolina.getContext(), "erro", Toast.LENGTH_SHORT).show();
        
    }*/

}

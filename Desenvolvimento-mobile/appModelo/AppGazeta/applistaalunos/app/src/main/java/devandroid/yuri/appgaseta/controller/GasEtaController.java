package devandroid.yuri.appgaseta.controller;

import android.content.ContentValues;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;


import devandroid.yuri.appgaseta.View.GasEtaActivity;
import devandroid.yuri.appgaseta.database.GasEtaDB;
import devandroid.yuri.appgaseta.model.Combustivel;
import devandroid.yuri.appgaseta.model.GasEta;

public class GasEtaController  extends GasEtaDB {


    public  static  final String new_preferences = "pref_lista";





    SharedPreferences preferences;
    SharedPreferences.Editor listaClientes;

    public GasEtaController(GasEtaActivity activity) {

        super(activity);

        preferences = activity.getSharedPreferences(new_preferences, 0);
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

    public void salvar(Combustivel combustivel){



        Log.d("MVC_Controller", "Dados Salvos " + toString() );


        ContentValues dados = new ContentValues();

        listaClientes.putString("combustivel", combustivel.getNomeCombustivel());
        listaClientes.putFloat("precoCombustivel", (float) combustivel.getPrecoCombustivel());
        listaClientes.putString("recomendacao",combustivel.getRecomendacao());
        listaClientes.apply();

        dados.put("nomeCombustivel", combustivel.getNomeCombustivel());
        dados.put("precoCombustivel", combustivel.getPrecoCombustivel());
        dados.put("recomendações", combustivel.getRecomendacao());

        salvarObejto("combustivel", dados);



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

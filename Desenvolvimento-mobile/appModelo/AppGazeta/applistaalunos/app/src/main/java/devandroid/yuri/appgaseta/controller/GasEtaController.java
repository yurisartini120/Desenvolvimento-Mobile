package devandroid.yuri.appgaseta.controller;

import static devandroid.yuri.appgaseta.controller.pessoaController.new_preferences;

import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;

import devandroid.yuri.appgaseta.View.GasEtaActivity;
import devandroid.yuri.appgaseta.model.Cliente;

public class GasEtaController {



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

    public void salvar(Cliente cliente){

        Log.d("MVC_Controller", "Dados Salvos " + toString() );


        listaClientes.putInt("Gasolina", (int) cliente.getGasolina());
        listaClientes.putInt("Etanol",(int) cliente.getEtanol());
        listaClientes.apply();

    }
}

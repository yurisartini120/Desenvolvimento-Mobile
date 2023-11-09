package devandroid.yuri.applistaalunos.controller;

import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;

import devandroid.yuri.applistaalunos.View.MainActivity;
import devandroid.yuri.applistaalunos.model.Pessoa;

public class pessoaController {

    SharedPreferences preferences;
    SharedPreferences.Editor listaAlunos;

    public  static  final String new_preferences = "pref_lista";

    public  pessoaController(MainActivity mainActivity){

        preferences = mainActivity.getSharedPreferences(new_preferences,0);
        listaAlunos = preferences.edit();

    }


    @NonNull
    @Override
    public String toString() {

        Log.d("MVC_Controller", "Controller Iniciado");
        return super.toString();
    }

    public void salvar(Pessoa pessoa){

        Log.d("MVC_Controller", "Dados Salvos " + toString() );

        listaAlunos.putString("primeiroNome", pessoa.getPrimeiroNome());
        listaAlunos.putString("sobrenome", pessoa.getSobrenome());
        listaAlunos.putString("matricula", pessoa.getMatricula());
        listaAlunos.putString("cpf", pessoa.getCpf());
        listaAlunos.apply();



    }

    public Pessoa buscar(Pessoa pessoa){

        pessoa.setPrimeiroNome(preferences.getString("primeiroNome", "NA"));
        pessoa.setSobrenome(preferences.getString("sobrenome", "NA"));
        pessoa.setMatricula(preferences.getString("matricula", "NA"));
        pessoa.setCpf(preferences.getString("cpf", "NA"));

        return pessoa;
    }

    public void limpar(){

        listaAlunos.clear();
        listaAlunos.apply();

    }
}

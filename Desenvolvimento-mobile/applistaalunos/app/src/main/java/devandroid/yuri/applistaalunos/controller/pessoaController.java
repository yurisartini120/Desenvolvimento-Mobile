package devandroid.yuri.applistaalunos.controller;

import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import devandroid.yuri.applistaalunos.View.MainActivity;
import devandroid.yuri.applistaalunos.model.Pessoa;

public class pessoaController {
    @NonNull
    @Override
    public String toString() {

        Log.d("MVC_Controller", "Controller Iniciado");
        return super.toString();
    }

    public void salvar(Pessoa pessoa){

        Log.d("MVC_Controller", "Dados Salvos " + toString() );



    }
}

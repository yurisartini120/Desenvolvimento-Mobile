package devandroid.yuri.conversordemoedas.controller;


import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;


import androidx.annotation.NonNull;

public class PessoaController {

    TextView resultadoTextView;
    EditText valorEditText;


    @NonNull
    @Override
    public String toString() {
        Log.d("MVC_Controller", "Controller Iniciado");
        return super.toString();

    }

    public void libra(){

        String valorString = valorEditText.getText().toString();

        double valor = Double.parseDouble(valorString);

        double resultado = 6.12 * valor;

        resultadoTextView.setText(String.valueOf(resultado));



    }

}

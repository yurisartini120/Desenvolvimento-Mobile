package devandroid.yuri.conversordemoedas.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import devandroid.yuri.conversordemoedas.R;
import devandroid.yuri.conversordemoedas.controller.PessoaController;

public class MainActivity extends AppCompatActivity {

    PessoaController controller;

    TextView resultadoTextView;
    EditText valorEditText;

    Button libraButton;
    Button pesoButton;
    Button euroButton;
    Button dolarButton;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vincularComponetes();
        listeners();

    }

    private void vincularComponetes(){

        valorEditText = findViewById(R.id.valorEditText);
        libraButton = findViewById(R.id.libraButton);
        pesoButton = findViewById(R.id.pesoButton);
        euroButton = findViewById(R.id.euroButton);
        dolarButton = findViewById(R.id.dolarButton);
        resultadoTextView = findViewById(R.id.resultadoTextView);

        controller = new PessoaController(valorEditText, resultadoTextView);

    }

    private  void listeners(){

        libraButton.setOnClickListener(evt -> controller.libra());
        pesoButton.setOnClickListener(evt -> controller.peso());
        euroButton.setOnClickListener(evt-> controller.euro());
        dolarButton.setOnClickListener(evt -> controller.dolar());

    }


    private void libra(){

        controller.libra();

    }

    private void peso(){
        controller.peso();

    }

    private void euro(){

      controller.euro();

    }

    private void dolar(){

        controller.dolar();

    }


}



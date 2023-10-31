package devandroid.yuri.conversordemoedas.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import devandroid.yuri.conversordemoedas.R;

public class MainActivity extends AppCompatActivity {

    EditText valorEditText;

    Button libraButton;
    Button pesoButton;
    Button euroButton;
    Button dolarButton;

    TextView resultadoTextView;


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

    }

    private  void listeners(){

        libraButton.setOnClickListener(evt -> libra());
        pesoButton.setOnClickListener(evt -> peso());
        euroButton.setOnClickListener(evt-> euro());
        dolarButton.setOnClickListener(evt -> dolar());

    }



    private void libra(){
        String valorString = valorEditText.getText().toString();

        double valor = Double.parseDouble(valorString);

        double resultado = 6.12 * valor;

        resultadoTextView.setText(String.valueOf(resultado));


    }

    private void peso(){

        String valorString = valorEditText.getText().toString();

        double valor = Double.parseDouble(valorString);

        double resultado = 69.41 * valor;

        resultadoTextView.setText(String.valueOf(resultado));

    }

    private void euro(){

        String valorString = valorEditText.getText().toString();

        double valor = Double.parseDouble(valorString);

        double resultado = 5.33 * valor;

        resultadoTextView.setText(String.valueOf(resultado));

    }

    private void dolar(){

        String valorString = valorEditText.getText().toString();

        double valor = Double.parseDouble(valorString);

        double resultado = 5.04 * valor;

        resultadoTextView.setText(String.valueOf(resultado));

    }


}



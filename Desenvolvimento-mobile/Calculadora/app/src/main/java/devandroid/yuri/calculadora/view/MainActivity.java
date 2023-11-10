package devandroid.yuri.calculadora.view;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import devandroid.yuri.calculadora.controller.PessoaController;
import devandroid.yuri.calculadora.R;

public class MainActivity extends AppCompatActivity {
    private EditText numero1EditText;
    private EditText numero2EditText;

    private Button adicaoButton;
    private Button subtracaoButton;
    private Button multiplicacaoButton;
    private Button divisaoButton;

    private TextView resultadoTextView;

    private PessoaController calculadoraController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vincularComponentes();
        criarListeners();
    }

    private void vincularComponentes() {
        numero1EditText = findViewById(R.id.numero1EditText);
        numero2EditText = findViewById(R.id.numero2EditText);
        adicaoButton = findViewById(R.id.adicaoButton);
        subtracaoButton = findViewById(R.id.subtracaoButton);
        multiplicacaoButton = findViewById(R.id.multiplicacaoButton);
        divisaoButton = findViewById(R.id.divisaoButton);
        resultadoTextView = findViewById(R.id.resultadoTextView);

        calculadoraController = new PessoaController(numero1EditText, numero2EditText, resultadoTextView);
    }

    private void criarListeners() {
        adicaoButton.setOnClickListener(evt -> calculadoraController.adicionar());
        subtracaoButton.setOnClickListener(evt -> calculadoraController.subtrair());
        multiplicacaoButton.setOnClickListener(evt -> calculadoraController.multiplicar());
        divisaoButton.setOnClickListener(evt -> calculadoraController.dividir());
    }
}
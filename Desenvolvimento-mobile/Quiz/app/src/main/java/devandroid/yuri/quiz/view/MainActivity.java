package devandroid.yuri.quiz.view;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import devandroid.yuri.quiz.R;

public class MainActivity extends AppCompatActivity {

    EditText resultadoTextView;

    Button btnBelgica;
    Button btnCazaquistao;
    Button btnBrasil;
    Button btnItalia;



    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        criarListerns();


        btnBelgica = findViewById(R.id.btnBelgica);
        btnBrasil = findViewById(R.id.btnBrasil);
        btnCazaquistao = findViewById(R.id.btnCazaquistao);
        btnItalia = findViewById(R.id.btnItalia);

        resultadoTextView = findViewById(R.id.resultadoTextView);


    }

    private void criarListerns(){

        btnItalia.setOnClickListener(evt -> correta());
        btnCazaquistao.setOnClickListener(evt -> errado());
        btnBrasil.setOnClickListener(evt -> errado());
        btnBelgica.setOnClickListener(evt -> errado());

    }

    private void correta(){

        String resultado = "Resposta correta!";

        resultadoTextView.setText(resultado);

    }

    private void errado(){

        String resultado = "Resposta incorreta!";

        resultadoTextView.setText(resultado);

    }
}
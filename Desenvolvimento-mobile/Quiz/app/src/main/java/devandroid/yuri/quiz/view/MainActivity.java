package devandroid.yuri.quiz.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import devandroid.yuri.quiz.R;

public class MainActivity extends AppCompatActivity {


    Button btnBelgica;
    Button btnCazaquistao;
    Button btnBrasil;
    Button btnItalia;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnBelgica = findViewById(R.id.btnBelgica);
        btnBrasil = findViewById(R.id.btnBrasil);
        btnCazaquistao = findViewById(R.id.btnCazaquistao);
        btnItalia = findViewById(R.id.btnItalia);


    }
}
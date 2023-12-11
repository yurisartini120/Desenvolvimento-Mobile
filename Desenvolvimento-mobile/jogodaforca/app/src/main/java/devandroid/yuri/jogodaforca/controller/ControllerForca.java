package devandroid.yuri.jogodaforca.controller;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import devandroid.yuri.jogodaforca.R;
import devandroid.yuri.jogodaforca.model.JogoForca;

public class ControllerForca extends AppCompatActivity {

    private JogoForca jogoForca;

    private TextView tvPalavraOculta;
    private EditText etLetra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jogoForca = new JogoForca();

        tvPalavraOculta = findViewById(R.id.tvPalavraOculta);
        etLetra = findViewById(R.id.etLetra);

        atualizarInterface();

        Button btnAdivinhar = findViewById(R.id.btnAdivinhar);
        btnAdivinhar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String letra = etLetra.getText().toString().toUpperCase();
                jogoForca.adivinharLetra(letra);
                atualizarInterface();

                if (jogoForca.isJogoTerminado()) {
                    // Lógica para o fim do jogo
                }
            }
        });
    }

    private void atualizarInterface() {
        tvPalavraOculta.setText("Palavra Oculta: " + jogoForca.getPalavraAdivinhada());
        // Atualizar outros elementos da interface, como tentativas restantes, se necessário
    }
}

package devandroid.yuri.jogodaforca.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import devandroid.yuri.jogodaforca.R;
import devandroid.yuri.jogodaforca.model.JogoForca;

public class MainActivity extends AppCompatActivity {

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
                    if (jogoForca.getTentativasRestantes() == 0) {
                        // O jogador perdeu, adicione lógica para exibir uma mensagem de derrota
                        // ou realizar outras ações necessárias quando o jogador perde.
                        exibirMensagem("Você perdeu! A palavra era: " + jogoForca.getPalavraAdivinhada());
                    } else {
                        // O jogador venceu, adicione lógica para exibir uma mensagem de vitória
                        // ou realizar outras ações necessárias quando o jogador vence.
                        exibirMensagem("Parabéns! Você adivinhou a palavra: " + jogoForca.getPalavraAdivinhada());
                    }
                }

            }
        });
    }

    private void atualizarInterface() {
        tvPalavraOculta.setText("Palavra Oculta: " + jogoForca.getPalavraAdivinhada());
        // Atualizar outros elementos da interface, como tentativas restantes, se necessário
    }

    private void exibirMensagem(String mensagem) {
        Toast.makeText(this, mensagem, Toast.LENGTH_LONG).show();
    }
}

// MainActivity.java
package devandroid.yuri.gerenciadordesenhas.View;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import devandroid.yuri.gerenciadordesenhas.Controller.SenhaController;
import devandroid.yuri.gerenciadordesenhas.R;

public class MainActivity extends AppCompatActivity {

    private EditText editTextCaracteres;
    private Button btnGerarSenha;
    private TextView resultado;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextCaracteres = findViewById(R.id.editTextCaracteres);
        resultado = findViewById(R.id.Resultado);
        btnGerarSenha = findViewById(R.id.btnGerarSenha);

        final SenhaController senhaController = new SenhaController();

        btnGerarSenha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String caracteres = editTextCaracteres.getText().toString();

                if (!caracteres.isEmpty() && caracteres.matches("\\d+")) {

                    int tamanho = Integer.parseInt(caracteres);
                    String senhaGerada = senhaController.gerarSenha(tamanho);
                    resultado.setText(senhaGerada);

                } else {

                    resultado.setText("Digite um número válido para os caracteres.");

                }
            }
        });
    }
}

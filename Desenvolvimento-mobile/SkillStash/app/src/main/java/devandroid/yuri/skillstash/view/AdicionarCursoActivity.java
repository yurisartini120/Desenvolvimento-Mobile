package devandroid.yuri.skillstash.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import devandroid.yuri.skillstash.R;
import devandroid.yuri.skillstash.model.Curso;

public class AdicionarCursoActivity extends AppCompatActivity {

    EditText editTextNome;
    EditText editTextDescricao;
    Button btnVoltar;
    Button btnSalvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_curso);

        editTextNome = findViewById(R.id.editTextNome);
        editTextDescricao = findViewById(R.id.editTextDescricao);
        btnVoltar = findViewById(R.id.btnVoltar);
        btnSalvar = findViewById(R.id.btnSalvar);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nome = editTextNome.getText().toString();
                String descricao = editTextDescricao.getText().toString();


                Curso curso = new Curso(nome, descricao);


                Intent intent = new Intent(AdicionarCursoActivity.this, DetalhesCursoActivity.class);
                intent.putExtra("curso", curso);
                startActivity(intent);

                finish();
            }
        });

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}

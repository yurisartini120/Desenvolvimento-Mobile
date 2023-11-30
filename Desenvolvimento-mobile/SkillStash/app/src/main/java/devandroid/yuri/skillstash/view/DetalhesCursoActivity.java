package devandroid.yuri.skillstash.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import devandroid.yuri.skillstash.R;
import devandroid.yuri.skillstash.model.Curso;

public class DetalhesCursoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_curso);

        if (getIntent().hasExtra("curso")){

            Curso curso = (Curso) getIntent().getSerializableExtra("curso");

            TextView textViewNome = findViewById(R.id.textViewNome);
            TextView textViewDescricao = findViewById(R.id.textViewDescricao);

            textViewNome.setText(curso.getNome());
            textViewDescricao.setText(curso.getDescricao());


        }


    }
}
package devandroid.yuri.skillstash.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import devandroid.yuri.skillstash.R;
import devandroid.yuri.skillstash.model.Curso;

public class DetalhesCursoActivity extends AppCompatActivity {

    Button btnVoltarDetalhes;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_curso);

        btnVoltarDetalhes = findViewById(R.id.btnVoltarDetalhes);

        btnVoltarDetalhes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });



        if (getIntent().hasExtra("curso")){

            Curso curso = (Curso) getIntent().getSerializableExtra("curso");

            TextView textViewNome = findViewById(R.id.textViewNome);
            TextView textViewDescricao = findViewById(R.id.textViewDescricao);

            textViewNome.setText(curso.getNome());
            textViewDescricao.setText(curso.getDescricao());


        }


    }
}
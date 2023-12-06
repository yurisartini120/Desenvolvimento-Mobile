package devandroid.yuri.skillstash.view;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import devandroid.yuri.skillstash.R;
import devandroid.yuri.skillstash.database.SkillDB;
import devandroid.yuri.skillstash.model.Curso;

public class MainActivity extends AppCompatActivity {

    LinearLayout linearLayout;

    Spinner spinner;

    Button btnAdicionar;
    Button btnDeletar;

    ImageButton imageButtonAcademico;
    ImageButton imageButtonEletrotecnica;
    ImageButton imageButtonPython;
    ImageButton imageButtonColinaria;

    SkillDB skillDB;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner);


        skillDB = new SkillDB(this);

        linearLayout = findViewById(R.id.linearLayout);

        imageButtonAcademico = findViewById(R.id.imageButtonAcademico);
        imageButtonEletrotecnica = findViewById(R.id.imageButtonEletrotecnica);
        imageButtonPython = findViewById(R.id.imageButtonPython);
        imageButtonColinaria = findViewById(R.id.imageButtonColinaria);

        btnAdicionar = findViewById(R.id.btnAdicionar);
        btnDeletar = findViewById(R.id.btnDeletar);



        btnAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AdicionarCursoActivity.class);
                startActivity(intent);
            }
        });

        carregarCursos();

        configurarSpinner();


        if (getIntent().hasExtra("curso")) {
            Curso curso = (Curso) getIntent().getSerializableExtra("curso");

            if (curso != null) {
                ImageButton newButton = new ImageButton(MainActivity.this);

                newButton.setLayoutParams(new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                ));

                newButton.setImageResource(R.drawable.ic_launcher_foreground); // Substitua pelo seu ícone
                newButton.setContentDescription(curso.getNome());

                newButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent detalhesIntent = new Intent(MainActivity.this, DetalhesCursoActivity.class);
                        detalhesIntent.putExtra("curso", curso);
                        startActivity(detalhesIntent);
                    }
                });

                linearLayout.addView(newButton);
            }
        }

        imageButtonAcademico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AcademicoActivity.class);
                startActivity(intent);
            }
        });

        imageButtonEletrotecnica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, EletricaActivity.class);
                startActivity(intent);
            }
        });

        imageButtonColinaria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CulinariaActivity.class);
                startActivity(intent);
            }
        });

        imageButtonPython.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PythonActivity.class);
                startActivity(intent);
            }
        });
    }
    private void carregarCursos(){

        linearLayout.removeAllViews();

        List<Curso> cursos = skillDB.obterCursos();

        for (Curso curso : cursos){
            criarBotao(curso);
        }

    }

    private void criarBotao(Curso curso){

        ImageButton newButton = new ImageButton(MainActivity.this);

        newButton.setLayoutParams(new LinearLayout.LayoutParams(

                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        ));

        newButton.setImageResource(R.drawable.ic_launcher_foreground);
        newButton.setContentDescription(curso.getNome());

        newButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent detalhesIntent = new Intent(MainActivity.this, DetalhesCursoActivity.class);
                detalhesIntent.putExtra("curso", curso);
                startActivity(detalhesIntent);


            }
        });


        linearLayout.addView(newButton);


        btnDeletar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                List<Curso> cursos = skillDB.obterCursos();

                if (!cursos.isEmpty()) {


                    Curso ultimoCurso = cursos.get(cursos.size() - 1);


                    skillDB.deletarCurso(ultimoCurso.getNome());


                    carregarCursos();

                } else {
                    // Adicione aqui a lógica para lidar com o caso em que não há cursos para deletar
                }



            }
        });



    }
    private void configurarSpinner(){

        List<Curso> cursos = skillDB.obterCursos();
        List<String> nomeCursos = new ArrayList<>();

        for (Curso curso : cursos){
            nomeCursos.add(curso.getNome());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, nomeCursos);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);

    }
}

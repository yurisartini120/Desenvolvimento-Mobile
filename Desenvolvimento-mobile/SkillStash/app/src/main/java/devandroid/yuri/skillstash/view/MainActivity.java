package devandroid.yuri.skillstash.view;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import devandroid.yuri.skillstash.R;
import devandroid.yuri.skillstash.model.Curso;

public class MainActivity extends AppCompatActivity {

    LinearLayout linearLayout;

    Button btnAdicionar;
    Button btnDeletar;

    ImageButton imageButtonAcademico;
    ImageButton imageButtonEletrotecnica;
    ImageButton imageButtonPython;
    ImageButton imageButtonColinaria;






    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

        if (getIntent().hasExtra("curso")){

            Curso curso = (Curso) getIntent().getSerializableExtra("curso");

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


}
package devandroid.yuri.skillstash.view;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import devandroid.yuri.skillstash.R;

public class MainActivity extends AppCompatActivity {

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



    }


}
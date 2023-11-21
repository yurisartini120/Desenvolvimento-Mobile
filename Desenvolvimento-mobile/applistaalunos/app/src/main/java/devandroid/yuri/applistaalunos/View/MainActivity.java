package devandroid.yuri.applistaalunos.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

import devandroid.yuri.applistaalunos.R;

import devandroid.yuri.applistaalunos.controller.cursoController;
import devandroid.yuri.applistaalunos.controller.pessoaController;
import devandroid.yuri.applistaalunos.model.Pessoa;

public class MainActivity extends AppCompatActivity {



    pessoaController controller;

    cursoController cursoController;

    Pessoa pessoa;

    List<String> nomeCurso;


    EditText editNome;
    EditText editSobrenome;
    EditText editMatricula;
    EditText editCpf;

    Button btnLimpar;
    Button btnSalvar;
    Button btnFinalizar;

    Spinner spinner;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        controller = new pessoaController(MainActivity.this);
        controller.toString();

        cursoController = new cursoController();

        cursoController.getListaCursos();

        nomeCurso = cursoController.dadosSpinner();

        pessoa = new Pessoa();

        controller.buscar(pessoa);


        editNome = findViewById(R.id.editNome);
        editSobrenome = findViewById(R.id.editSobrenome);
        editMatricula = findViewById(R.id.editMatricula);
        editCpf = findViewById(R.id.editCpf);
        spinner = findViewById(R.id.spinner);



        btnLimpar = findViewById(R.id.btnLimpar);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnFinalizar = findViewById(R.id.btnFinalizar);



        editNome.setText(pessoa.getPrimeiroNome());
        editSobrenome.setText(pessoa.getSobrenome());
        editMatricula.setText(pessoa.getMatricula());
        editCpf.setText(pessoa.getCpf());



        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,cursoController.dadosSpinner());

        adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
        spinner.setAdapter(adapter);



        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                editNome.setText("");
                editSobrenome.setText("");
                editMatricula.setText("");
                editCpf.setText("");

                controller.limpar();
            }
        });

        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText( MainActivity.this, "Aplicativo Finalizado", Toast.LENGTH_LONG).show();
                finish();
            }
        });

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pessoa.setPrimeiroNome(editNome.getText().toString());
                pessoa.setSobrenome(editSobrenome.getText().toString());
                pessoa.setMatricula(editMatricula.getText().toString());
                pessoa.setCpf(editCpf.getText().toString());


                Toast.makeText( MainActivity.this, "Dados Salvos", Toast.LENGTH_LONG).show();

                controller.salvar(pessoa);

            }
        });


        Log.i("POOAndroid",pessoa.toString());

    }
}
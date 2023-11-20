package devandroid.yuri.appgaseta.View;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import devandroid.yuri.appgaseta.R;
import devandroid.yuri.appgaseta.controller.cursoController;
import devandroid.yuri.appgaseta.controller.pessoaController;
import devandroid.yuri.appgaseta.model.Pessoa;


public class MainActivity extends AppCompatActivity {



    pessoaController controller;

    cursoController cursoController;

    Pessoa pessoa;

    List<String> nomeCurso;


    EditText editGasolina;
    EditText editEtanol;


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


        editGasolina = findViewById(R.id.editGasolina);
        editEtanol = findViewById(R.id.editEtanol);

        spinner = findViewById(R.id.spinner);



        btnLimpar = findViewById(R.id.btnLimpar);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnFinalizar = findViewById(R.id.btnFinalizar);


        editGasolina.setText(pessoa.getPrimeiroNome());
        editEtanol.setText(pessoa.getSobrenome());



        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,cursoController.dadosSpinner());

        adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
        spinner.setAdapter(adapter);



        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                editGasolina.setText("");
                editEtanol.setText("");


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

                pessoa.setPrimeiroNome(editGasolina.getText().toString());
                pessoa.setSobrenome(editEtanol.getText().toString());



                Toast.makeText( MainActivity.this, "Dados Salvos", Toast.LENGTH_LONG).show();

                controller.salvar(pessoa);

            }
        });


        Log.i("POOAndroid",pessoa.toString());

    }
}
package devandroid.yuri.applistaalunos.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import devandroid.yuri.applistaalunos.R;

import devandroid.yuri.applistaalunos.controller.pessoaController;
import devandroid.yuri.applistaalunos.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    SharedPreferences preferences;
    SharedPreferences.Editor listaAlunos;

    public static final String new_preferences = "pref_lista";

    pessoaController controller;

    Pessoa pessoa;


    EditText editNome;
    EditText editSobrenome;
    EditText editMatricula;
    EditText editCpf;

    Button btnLimpar;
    Button btnSalvar;
    Button btnFinalizar;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        preferences = getSharedPreferences(new_preferences, 0);
        listaAlunos = preferences.edit();


        controller = new pessoaController();
        controller.toString();


        //pessoa
        pessoa = new Pessoa();

        pessoa.setPrimeiroNome(preferences.getString("primeiroNome", "NA"));
        pessoa.setSobrenome(preferences.getString("sobrenome", "NA"));
        pessoa.setMatricula(preferences.getString("matricula", "NA"));
        pessoa.setCpf(preferences.getString("cpf", "NA"));





        //outraPessoa





        editNome = findViewById(R.id.editNome);
        editSobrenome = findViewById(R.id.editSobrenome);
        editMatricula = findViewById(R.id.editMatricula);
        editCpf = findViewById(R.id.editCpf);

        btnLimpar = findViewById(R.id.btnLimpar);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnFinalizar = findViewById(R.id.btnFinalizar);


        editNome.setText(pessoa.getPrimeiroNome());
        editSobrenome.setText(pessoa.getSobrenome());
        editMatricula.setText(pessoa.getMatricula());
        editCpf.setText(pessoa.getCpf());

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                editNome.setText("");
                editSobrenome.setText("");
                editMatricula.setText("");
                editCpf.setText("");

                listaAlunos.clear();
                listaAlunos.apply();


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

                listaAlunos.putString("primeiroNome", pessoa.getPrimeiroNome());
                listaAlunos.putString("sobrenome", pessoa.getSobrenome());
                listaAlunos.putString("matricula", pessoa.getMatricula());
                listaAlunos.putString("cpf", pessoa.getCpf());
                listaAlunos.apply();




                controller.salvar(pessoa);




            }

        });


        Log.i("POOAndroid",pessoa.toString());

    }
}
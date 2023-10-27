package devandroid.yuri.applistaalunos.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import devandroid.yuri.applistaalunos.R;

import devandroid.yuri.applistaalunos.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    Pessoa pessoa;
    Pessoa OutraPessoa;

    String dadosPessoa;
    String dadosOutraPessoa;

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

        //pessoa
        pessoa = new Pessoa();

        pessoa.setPrimeiroNome("Yuri");
        pessoa.setSobrenome("Sartini Coelho");
        pessoa.setMatricula("12345678");
        pessoa.setCpf("13685245689");

        //outraPessoa
        OutraPessoa = new Pessoa();
/*
        OutraPessoa.setPrimeiroNome("Ayla");
        OutraPessoa.setSobrenome("Sartini");
        OutraPessoa.setMatricula("45878965");
        OutraPessoa.setCpf("1368524487");*/


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

                OutraPessoa.setPrimeiroNome(editNome.getText().toString());
                OutraPessoa.setSobrenome(editSobrenome.getText().toString());
                OutraPessoa.setMatricula(editMatricula.getText().toString());
                OutraPessoa.setCpf(editCpf.getText().toString());


                Toast.makeText( MainActivity.this, "Dados Salvos", Toast.LENGTH_LONG).show();
            }
        });

/*
        //dadosPessoa
        dadosPessoa = "Primeiro nome: ";
        dadosPessoa += pessoa.getPrimeiroNome();
        dadosPessoa += "Sobrenome: ";
        dadosPessoa += pessoa.getSobrenome();
        dadosPessoa += "Matricula: ";
        dadosPessoa += pessoa.getMatricula();
        dadosPessoa += "Cpf: ";
        dadosPessoa += pessoa.getCpf();


        //dadosOutraPessoa
        dadosOutraPessoa = "Primeiro nome: ";
        dadosOutraPessoa += OutraPessoa.getPrimeiroNome();
        dadosOutraPessoa += "Sobrenome: ";
        dadosOutraPessoa += OutraPessoa.getSobrenome();
        dadosOutraPessoa += "Matricula: ";
        dadosOutraPessoa += OutraPessoa.getMatricula();
        dadosOutraPessoa += "cpf: ";
        dadosOutraPessoa += OutraPessoa.getCpf();
*/
        Log.i("POOAndroid",pessoa.toString());
        Log.i("POOAndroid",OutraPessoa.toString());
    }
}
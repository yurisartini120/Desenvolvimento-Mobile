package devandroid.yuri.applistaalunos.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import devandroid.yuri.applistaalunos.R;

import devandroid.yuri.applistaalunos.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    Pessoa pessoa;
    Pessoa OutraPessoa;

    String dadosPessoa;
    String dadosOutraPessoa;




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

        OutraPessoa.setPrimeiroNome("Ayla");
        OutraPessoa.setSobrenome("Sartini");
        OutraPessoa.setMatricula("45878965");
        OutraPessoa.setCpf("1368524487");

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
        dadosOutraPessoa += "Matricula";
        dadosOutraPessoa += OutraPessoa.getMatricula();
        dadosOutraPessoa += "cpf: ";
        dadosOutraPessoa += OutraPessoa.getCpf();

        int parada = 0;
    }
}
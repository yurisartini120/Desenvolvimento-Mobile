package devandroid.yuri.calculadoraimc.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import devandroid.yuri.calculadoraimc.R;

import devandroid.yuri.calculadoraimc.model.pessoa;

public class MainActivity extends AppCompatActivity {
    pessoa pessoa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pessoa = new pessoa();

        pessoa.setIdade("18");
        pessoa.setPeso("77.8");
        pessoa.setAltura("1.80");


       int parada = 0;

    }
}
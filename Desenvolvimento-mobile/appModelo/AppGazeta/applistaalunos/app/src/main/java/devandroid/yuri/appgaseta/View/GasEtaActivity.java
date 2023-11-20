package devandroid.yuri.appgaseta.View;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import devandroid.yuri.appgaseta.R;
import devandroid.yuri.appgaseta.util.utilGasEta;

public class GasEtaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //utilGasEta.metodoNaoEstatico();

        //utilGasEta.metodoEstatico();

        Toast.makeText(GasEtaActivity.this, utilGasEta.mensagem(), Toast.LENGTH_SHORT).show();


       // Toast.makeText(GasEtaActivity.this, utilGasEta.calcularmelhorOpcao(5.12,3.19), Toast.LENGTH_SHORT).show();


    }
}

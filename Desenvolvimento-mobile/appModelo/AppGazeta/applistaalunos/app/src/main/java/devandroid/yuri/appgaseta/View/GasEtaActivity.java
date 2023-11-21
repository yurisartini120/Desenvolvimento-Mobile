package devandroid.yuri.appgaseta.View;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import devandroid.yuri.appgaseta.R;
import devandroid.yuri.appgaseta.controller.GasEtaController;
import devandroid.yuri.appgaseta.model.Cliente;
import devandroid.yuri.appgaseta.util.utilGasEta;

public class GasEtaActivity extends AppCompatActivity {



    GasEtaController controller;

    Cliente cliente;

    EditText editGasolina;
    EditText editEtanol;

    TextView txtResultado;



    Button btnCalcular;
    Button btnLimpar;
    Button btnSalvar;
    Button btnFinalizar;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //utilGasEta.metodoNaoEstatico();

        //utilGasEta.metodoEstatico();

        Toast.makeText(GasEtaActivity.this, utilGasEta.mensagem(), Toast.LENGTH_SHORT).show();


       // Toast.makeText(GasEtaActivity.this, utilGasEta.calcularmelhorOpcao(5.12,3.19), Toast.LENGTH_SHORT).show();

        controller = new GasEtaController(GasEtaActivity.this);

        cliente = new Cliente();


        txtResultado = findViewById(R.id.txtResultado);

        editGasolina = findViewById(R.id.editGasolina);
        editEtanol = findViewById(R.id.editEtanol);

        btnCalcular = findViewById(R.id.btnCalcular);
        btnFinalizar = findViewById(R.id.btnFinalizar);
        btnLimpar = findViewById(R.id.btnLimpar);
        btnSalvar = findViewById(R.id.btnSalvar);




        //editEtanol.setText(cliente.getEtanol());
        //editGasolina.setText(cliente.getGasolina());





        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });



        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
                controller.limpar();

                editGasolina.setText("");
                editEtanol.setText("");
            }
        });

        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText( GasEtaActivity.this, "Aplicativo Finalizado", Toast.LENGTH_LONG).show();
                finish();

            }
        });

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



            cliente.setEtanol(Double.valueOf(editEtanol.getText().toString()));
            cliente.setGasolina(Double.valueOf(editGasolina.getText().toString()));

                Toast.makeText(GasEtaActivity.this, "DADOS SALVOS", Toast.LENGTH_SHORT).show();

            controller.salvar(cliente);



            }
        });

    }
}

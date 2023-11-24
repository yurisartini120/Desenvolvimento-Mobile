package devandroid.yuri.appgaseta.View;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import devandroid.yuri.appgaseta.R;
import devandroid.yuri.appgaseta.controller.GasEtaController;
import devandroid.yuri.appgaseta.model.Combustivel;
import devandroid.yuri.appgaseta.model.GasEta;
import devandroid.yuri.appgaseta.util.utilGasEta;

public class GasEtaActivity extends AppCompatActivity {


    GasEtaController controller;

    GasEta cliente;

    Combustivel combustivelGasolina;
    Combustivel combustivelEtanol;


    EditText editGasolina;
    EditText editEtanol;

    TextView txtResultado;

    Button btnCalcular;
    Button btnLimpar;
    Button btnSalvar;
    Button btnFinalizar;

    double precoEtanol;
    double precoGasolina;
    String resultado;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //utilGasEta.metodoNaoEstatico();

        //utilGasEta.metodoEstatico();

        Toast.makeText(GasEtaActivity.this, utilGasEta.mensagem(), Toast.LENGTH_SHORT).show();


       // Toast.makeText(GasEtaActivity.this, utilGasEta.calcularmelhorOpcao(5.12,3.19), Toast.LENGTH_SHORT).show();

        controller = new GasEtaController(GasEtaActivity.this);

        cliente = new GasEta();


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


                boolean isDadosOk = true;

                if (TextUtils.isEmpty(editEtanol.getText())){
                    editEtanol.setError("Obrigatorio");
                    editEtanol.requestFocus();
                    isDadosOk = false;
                }
                if (TextUtils.isEmpty(editGasolina.getText())){
                    editGasolina.setError("Obrigatorio");
                    editGasolina.requestFocus();
                    isDadosOk = false;
                }
                if (isDadosOk){
                    precoGasolina = Double.parseDouble(editGasolina.getText().toString());
                    precoEtanol = Double.parseDouble(editEtanol.getText().toString());

                    resultado = utilGasEta.calcularmelhorOpcao(precoGasolina, precoEtanol);

                    txtResultado.setText(String.valueOf(resultado));


                    btnSalvar.setEnabled(true);
                }else{
                    Toast.makeText(GasEtaActivity.this, "Dados Obrigatorios", Toast.LENGTH_SHORT).show();

                    btnSalvar.setEnabled(false);
                }


                /*double gasolina = Double.parseDouble(editGasolina.getText().toString());
                double etanol = Double.parseDouble(editEtanol.getText().toString());



                double valor = etanol / gasolina;


                if (valor < 0.7){

                    String resultado = "Abastecer com alcool";
                    txtResultado.setText(String.valueOf(resultado));

                }else {

                    String resultado = "Abastecer com Gasolina";
                    txtResultado.setText(String.valueOf(resultado));

                }


                //controller.calcular();*/


            }
        });


        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
                controller.limpar();

                editGasolina.setText("");
                editEtanol.setText("");
                txtResultado.setText("");
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

                combustivelGasolina = new Combustivel();
                combustivelEtanol = new Combustivel();

                combustivelGasolina.setNomeCombustivel("Gasolina");
                combustivelGasolina.setPrecoCombustivel(precoGasolina);

                combustivelEtanol.setNomeCombustivel("Etanol");
                combustivelEtanol.setPrecoCombustivel(precoEtanol);

                combustivelGasolina.setRecomendacao(utilGasEta.calcularmelhorOpcao(precoGasolina,precoEtanol));
                combustivelEtanol.setRecomendacao(utilGasEta.calcularmelhorOpcao(precoGasolina,precoEtanol));





                Toast.makeText(GasEtaActivity.this, "DADOS SALVOS", Toast.LENGTH_SHORT).show();

            controller.salvar(combustivelGasolina);
                controller.salvar(combustivelEtanol);



            }
        });

    }

}

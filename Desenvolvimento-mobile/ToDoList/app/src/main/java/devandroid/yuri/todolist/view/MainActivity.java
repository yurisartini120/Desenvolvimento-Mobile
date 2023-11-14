package devandroid.yuri.todolist.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import devandroid.yuri.todolist.R;
import devandroid.yuri.todolist.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    Pessoa pessoa;



    EditText editTarefa;

    Button btnVerTarefas;
    Button btnDeletar;
    Button btnAdicionar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        pessoa = new Pessoa();

        editTarefa = findViewById(R.id.editTarefa);

        btnAdicionar = findViewById(R.id.btnAdicionar);
        btnDeletar = findViewById(R.id.btnDeletar);
        btnVerTarefas = findViewById(R.id.btnVerTarefas);




    }
}
package devandroid.yuri.todolist.view;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import devandroid.yuri.todolist.R;
import devandroid.yuri.todolist.controller.PessoaController;
import devandroid.yuri.todolist.model.Pessoa;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ListView listViewPessoas;
    private ArrayAdapter<Pessoa> adapter;

    private PessoaController pessoaController;

    private EditText editTarefa;
    private Button btnAdicionar;
    private Button btnDeletar;
    private Button btnVerTarefas;
    private TextView textView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pessoaController = new PessoaController();

        editTarefa = findViewById(R.id.editTarefa);
        btnAdicionar = findViewById(R.id.btnAdicionar);
        btnDeletar = findViewById(R.id.btnDeletar);
        btnVerTarefas = findViewById(R.id.btnVerTarefas);
        textView = findViewById(R.id.textView);
        listViewPessoas = findViewById(R.id.listViewPessoas);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, pessoaController.getListaPessoas());
        listViewPessoas.setAdapter(adapter);

        btnAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = editTarefa.getText().toString();
                pessoaController.adicionarPessoa(nome);
                atualizarListaPessoas();
            }
        });

        btnDeletar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deletarPessoaSelecionada();
            }
        });
        btnVerTarefas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lógica para exibir a lista de pessoas
                atualizarListaPessoas();
            }
        });
    }

    private void deletarPessoaSelecionada() {
        int position = listViewPessoas.getCheckedItemPosition();

        if (position != ListView.INVALID_POSITION) {
            pessoaController.deletarPessoa(position);
            // Remova a seleção após a exclusão para evitar problemas
            listViewPessoas.setItemChecked(position, false);
            atualizarListaPessoas();
        } else {
            Toast.makeText(MainActivity.this, "Selecione uma pessoa para deletar", Toast.LENGTH_SHORT).show();
        }
    }



    private void atualizarListaPessoas() {
        StringBuilder sb = new StringBuilder();
        for (Pessoa pessoa : pessoaController.getListaPessoas()) {
            sb.append(pessoa.getNome()).append("\n");
        }
        textView.setText(sb.toString());
    }
}

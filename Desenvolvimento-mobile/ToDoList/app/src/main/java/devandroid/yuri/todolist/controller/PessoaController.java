package devandroid.yuri.todolist.controller;

import java.util.ArrayList;
import java.util.List;

import devandroid.yuri.todolist.model.Pessoa;

public class PessoaController {
    private List<Pessoa> pessoas;

    public PessoaController() {
        this.pessoas = new ArrayList<>();
    }

    public void adicionarPessoa(String nome) {
        Pessoa pessoa = new Pessoa(nome);
        pessoas.add(pessoa);
    }

    public void deletarPessoa(int index) {

        if (index >= 0 && index < pessoas.size()) {
            pessoas.remove(index);
        }
    }

    public List<Pessoa> getListaPessoas() {
        return pessoas;
    }


}

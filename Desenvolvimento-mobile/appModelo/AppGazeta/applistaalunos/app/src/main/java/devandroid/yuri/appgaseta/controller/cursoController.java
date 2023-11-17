package devandroid.yuri.appgaseta.controller;

import java.util.ArrayList;
import java.util.List;

import devandroid.yuri.appgaseta.model.curso;

public class cursoController {

    private List listaCursos;

    public List getListaCursos(){

        listaCursos = new ArrayList<>();

        listaCursos.add(new curso("JAVA"));
        listaCursos.add(new curso("PYTHON"));
        listaCursos.add(new curso("PHP"));
        listaCursos.add(new curso("C#"));
        listaCursos.add(new curso("C++"));


        return listaCursos;

    }

    public ArrayList<String> dadosSpinner(){

        ArrayList<String> dados = new ArrayList<>();
        for (int i = 0; i < getListaCursos().size(); i++){

            curso objeto = (curso) getListaCursos().get(i);

            dados.add(objeto.getCursoDesejado());



        }
        return dados;

    }


}

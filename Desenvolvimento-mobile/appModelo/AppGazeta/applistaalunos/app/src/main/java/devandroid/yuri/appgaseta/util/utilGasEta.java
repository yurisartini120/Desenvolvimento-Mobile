package devandroid.yuri.appgaseta.util;

public class utilGasEta {

    public void metodoNaoEstatico(){

    }

    public void metodoEstatico(){

    }

    public static String mensagem(){

        return "Seja bem Vindo";
    }

    public static String calcularmelhorOpcao(double gasolina, double etanol){

        double precoIdeal = gasolina * 0.70;
        String mensagemRetorno;

        if (etanol <= precoIdeal){
            mensagemRetorno = "Abastecer com etanol";
        }else{
            mensagemRetorno = "Abastecer com gasolina";
        }
        return mensagemRetorno;

    }



}

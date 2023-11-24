package devandroid.yuri.appgaseta.model;

public class GasEta {



    private Double Gasolina;
    private Double Etanol;
    private String resultado;




    public GasEta(){}

    public double getGasolina() {
        return Gasolina;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public void setGasolina(Double gasolina) {
        this.Gasolina = gasolina;
    }

    public double getEtanol() {
        return Etanol;
    }

    public void setEtanol(Double etanol) {
        this.Etanol = etanol;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "Gasolina=" + Gasolina +
                ", Etanol=" + Etanol +
                '}';
    }




}

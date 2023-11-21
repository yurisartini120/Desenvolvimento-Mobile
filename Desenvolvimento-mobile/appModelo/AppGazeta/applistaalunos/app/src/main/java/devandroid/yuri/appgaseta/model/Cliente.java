package devandroid.yuri.appgaseta.model;

public class Cliente {

    private Double Gasolina;
    private Double Etanol;


    public Cliente(){}

    public double getGasolina() {
        return Gasolina;
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

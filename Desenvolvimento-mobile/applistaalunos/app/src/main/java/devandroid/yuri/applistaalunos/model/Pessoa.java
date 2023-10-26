package devandroid.yuri.applistaalunos.model;

public class Pessoa {

    private String PrimeiroNome;
    private String Sobrenome;
    private String Matricula;
    private String Cpf;




    public Pessoa(){}

    public String getPrimeiroNome() {
        return PrimeiroNome;
    }

    public void setPrimeiroNome(String primeiroNome) {
        this.PrimeiroNome = primeiroNome;
    }

    public String getSobrenome() {
        return Sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.Sobrenome = sobrenome;
    }

    public String getMatricula() {
        return Matricula;
    }

    public void setMatricula(String matricula) {
        this.Matricula = matricula;
    }

    public String getCpf() {
        return Cpf;
    }

    public void setCpf(String cpf) {
        this.Cpf = cpf;
    }
}

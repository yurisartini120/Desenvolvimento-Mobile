// SenhaController.java
package devandroid.yuri.gerenciadordesenhas.Controller;

import devandroid.yuri.gerenciadordesenhas.Model.Senha;

public class SenhaController {

    public String gerarSenha(int tamanho) {
        return Senha.gerarSenha(tamanho);
    }
}

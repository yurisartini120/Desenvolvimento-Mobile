// Senha.java
package devandroid.yuri.gerenciadordesenhas.Model;

import java.security.SecureRandom;

public class Senha {

    private static final String CARACTERES =
            "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-_=+";

    public static String gerarSenha(int tamanho) {
        int tamanhoReal = Math.min(tamanho, 8);  // Garante que a senha tenha no máximo 8 caracteres
        StringBuilder senha = new StringBuilder(tamanhoReal);
        SecureRandom random = new SecureRandom();

        for (int i = 0; i < tamanhoReal; i++) {
            int index = random.nextInt(CARACTERES.length());
            senha.append(CARACTERES.charAt(index));
        }

        return senha.toString();
    }
}

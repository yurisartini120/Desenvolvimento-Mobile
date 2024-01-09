package devandroid.yuri.jogodaforca.model;

import java.util.Random;

public class JogoForca {

    private String[] palavras = {"ANDROID", "DESENVOLVIMENTO", "ESTUDIO", "JOGO", "PROGRAMACAO"};
    private String palavraSecreta;
    private StringBuilder palavraAdivinhada;
    private int tentativasRestantes;

    public JogoForca() {
        // Inicializa o jogo
        palavraSecreta = selecionarPalavraAleatoria();

        palavraAdivinhada = new StringBuilder();
        for (int i = 0; i < palavraSecreta.length(); i++) {
            palavraAdivinhada.append("_");
        }


        tentativasRestantes = 6;
    }

    private String selecionarPalavraAleatoria() {
        // Seleciona aleatoriamente uma palavra do array
        Random random = new Random();
        return palavras[random.nextInt(palavras.length)];
    }

    public void adivinharLetra(String letra) {
        letra = letra.toUpperCase(); // Converte a letra para maiúscula para garantir correspondência correta

        if (!letra.matches("[A-Z]")) {
            // Apenas aceita letras de A a Z
            return;
        }

        if (palavraSecreta.contains(letra)) {
            // A letra está presente na palavra
            for (int i = 0; i < palavraSecreta.length(); i++) {
                if (palavraSecreta.charAt(i) == letra.charAt(0)) {
                    // Substitui o underscore na posição correspondente pela letra correta
                    palavraAdivinhada.setCharAt(i, letra.charAt(0));
                }
            }
        } else {
            // A letra não está presente na palavra
            tentativasRestantes--;

            // Adicione lógica adicional se desejar, como verificar se o jogador perdeu
        }
    }


    public boolean isJogoTerminado() {
        // Verifica se o jogo terminou (ganhou ou perdeu)
        // Retorna true se o jogo terminou, false caso contrário
        return false;
    }

    public String getPalavraAdivinhada() {
        return palavraAdivinhada.toString();
    }

    public int getTentativasRestantes() {
        return tentativasRestantes;
    }

    // Métodos adicionais conforme necessário
}


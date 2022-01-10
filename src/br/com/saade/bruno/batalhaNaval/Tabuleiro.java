package br.com.saade.bruno.batalhaNaval;

import java.util.Random;

public class Tabuleiro {

    private String[][] tabuleiroPlayer1 = new String[10][10];
    private String[][] tabuleiroBot = new String[10][10];
    private String[] letras = {"A","B","C","D","E","F","G","H","I","J"};
    private int vidaBot = 10;
    private int vidaPlayer = 10;
    Player player1 = new Player();


    public void montaTabuleiro(){
        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 10; j++){
                this.tabuleiroPlayer1[i][j] = "_";
                this.tabuleiroBot[i][j] = "_";
            }
        }
    }
    public void mostraTabuleiro(String tipoTabuleiro){

        if (tipoTabuleiro.equals("player")) {
            System.out.println("_|0|1|2|3|4|5|6|7|8|9|");
            for (int i = 0; i < 10; i++){
                System.out.printf("%s|", this.letras[i]);
                for (int j = 0; j < 10; j++){
                    System.out.printf(this.tabuleiroPlayer1[i][j]);
                    System.out.printf("|");
                }
                System.out.println("");
            }
        } else if (tipoTabuleiro.equals("bot")) {
            System.out.println("_|0|1|2|3|4|5|6|7|8|9|");
            for (int i = 0; i < 10; i++){
                System.out.printf("%s|", this.letras[i]);
                for (int j = 0; j < 10; j++){
                    System.out.printf(this.tabuleiroBot[i][j]);
                    System.out.printf("|");
                }
                System.out.println("");
            }
        }
    }
    public void preencheTabuleiroPlayer(String linha, int coluna){
        int linhaEscolhida = this.comparaLetraComLinha(linha);
        if (this.tabuleiroPlayer1[linhaEscolhida][coluna] != "N") {
            this.tabuleiroPlayer1[linhaEscolhida][coluna] = "N";
        } else {
            System.out.println("Posição já escolhida!");
        }

    }
    public void preencheTabuleiroBot(){
        Random gerador = new Random();
        int linhaEscolhida = 0;
        int colunaEscolhida = 0;
        for (int i = 0; i < 10; i++){
            linhaEscolhida = gerador.nextInt(10);
            colunaEscolhida = gerador.nextInt(10);
            this.tabuleiroBot[linhaEscolhida][colunaEscolhida] = "N";
        }
    }
    public void marcaJogadasPlayer(String linha, int coluna) {
        int linhaEscolhida = this.comparaLetraComLinha(linha);

        if ((this.tabuleiroBot[linhaEscolhida][coluna].equalsIgnoreCase("N") ||
                this.tabuleiroBot[linhaEscolhida][coluna].equals("X")) && this.tabuleiroPlayer1[linhaEscolhida][coluna].equals("N")) {
            this.tabuleiroPlayer1[linhaEscolhida][coluna] = "X";
            this.vidaBot--;
        } else if ((this.tabuleiroBot[linhaEscolhida][coluna].equalsIgnoreCase("N") ||
                this.tabuleiroBot[linhaEscolhida][coluna].equals("X")) && this.tabuleiroPlayer1[linhaEscolhida][coluna].equals("_")) {
            this.tabuleiroPlayer1[linhaEscolhida][coluna] = "*";
            this.vidaBot--;
        } else if ((this.tabuleiroBot[linhaEscolhida][coluna].equals("_") || this.tabuleiroBot[linhaEscolhida][coluna].equals("-") ||
                this.tabuleiroBot[linhaEscolhida][coluna].equals("*")) && this.tabuleiroPlayer1[linhaEscolhida][coluna].equals("N") ||
                this.tabuleiroPlayer1[linhaEscolhida][coluna].equals("X")) {
            this.tabuleiroPlayer1[linhaEscolhida][coluna] = "n";
        } else {
            this.tabuleiroPlayer1[linhaEscolhida][coluna] = "-";
        }
    }

    public void marcaJogadasBot() {
        Random gerador = new Random();
        int linhaGerada = gerador.nextInt(10);
        int colunaGerada = gerador.nextInt(10);

        if ((this.tabuleiroPlayer1[linhaGerada][colunaGerada].equalsIgnoreCase("N") ||
                this.tabuleiroPlayer1[linhaGerada][colunaGerada].equals("X")) && this.tabuleiroBot[linhaGerada][colunaGerada].equals("N")) {
            this.tabuleiroBot[linhaGerada][colunaGerada] = "X";
            this.vidaPlayer--;
        } else if ((this.tabuleiroPlayer1[linhaGerada][colunaGerada].equalsIgnoreCase("N") ||
                this.tabuleiroPlayer1[linhaGerada][colunaGerada].equals("X")) && this.tabuleiroBot[linhaGerada][colunaGerada].equals("n")) {
            this.tabuleiroBot[linhaGerada][colunaGerada] = "*";
            this.vidaPlayer--;
        } else if ((this.tabuleiroPlayer1[linhaGerada][colunaGerada].equals("_") || this.tabuleiroPlayer1[linhaGerada][colunaGerada].equals("-") ||
                this.tabuleiroPlayer1[linhaGerada][colunaGerada].equals("*")) && this.tabuleiroBot[linhaGerada][colunaGerada].equals("N") ||
                this.tabuleiroBot[linhaGerada][colunaGerada].equals("X")) {
            this.tabuleiroBot[linhaGerada][colunaGerada] = "n";
        } else {
            this.tabuleiroBot[linhaGerada][colunaGerada] = "-";
        }
    }

    public int comparaLetraComLinha(String linha){
        int linhaEscolhida = 0;
        switch (linha) {
            case "A":
                linhaEscolhida = 0;
                break;
            case "B":
                linhaEscolhida = 1;
                break;
            case "C":
                linhaEscolhida = 2;
                break;
            case "D":
                linhaEscolhida = 3;
                break;
            case "E":
                linhaEscolhida = 4;
                break;
            case "F":
                linhaEscolhida = 5;
                break;
            case "G":
                linhaEscolhida = 6;
                break;
            case "H":
                linhaEscolhida = 7;
                break;
            case "I":
                linhaEscolhida = 8;
                break;
            case "J":
                linhaEscolhida = 9;
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }
        return linhaEscolhida;
    }
    public boolean verificaVencedor() {
        if (this.vidaBot == 0){
            System.out.printf("Parabéns %s, você venceu!!!!", player1.getNome());
            return false;
        } else if (this.vidaPlayer == 0) {
            System.out.printf("%s, você perdeu!", player1.getNome());
            System.out.println("Tabuleiro do oponente:");
            mostraTabuleiro("bot");
            return false;
        }
        return true;
    }
}

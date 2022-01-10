
package br.com.saade.bruno.batalhaNaval;
import java.util.Scanner;

public class Main {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String flag = "s";

            while(flag.equals("s")) {
                try{
                    Player player1 = new Player();
                    Tabuleiro tabuleiro = new Tabuleiro();
                    String linha;
                    int coluna;
                    String linhaTiro;
                    int colunaTiro;

                    System.out.println("<=========== Batalha Naval ===========>");
                    System.out.println("Digite seu nome:");
                    player1.setNome(sc.next());
                    System.out.println("Player 1 = " + player1.getNome());

                    tabuleiro.montaTabuleiro();
                    tabuleiro.preencheTabuleiroBot();
                    System.out.println("Coloque seus navios no tabuleiro:");
                    tabuleiro.mostraTabuleiro("player");

                    for (int i = 0; i < 10; i++) {
                        System.out.printf("\nDigite a coordenada do %dº navio: \n", i + 1);
                        System.out.println("Linha: ");
                        linha = sc.next();
                        System.out.println("Coluna: ");
                        coluna = sc.nextInt();
                        tabuleiro.preencheTabuleiroPlayer(linha.toUpperCase(), coluna);
                        tabuleiro.mostraTabuleiro("player");
                    }

                    while(tabuleiro.verificaVencedor()) {
                        System.out.println("Digite a coordenada do seu tiro:");
                        System.out.printf("Digite a linha:");
                        linhaTiro = sc.next();
                        System.out.printf("Digite a coluna:");
                        colunaTiro = sc.nextInt();
                        tabuleiro.marcaJogadasPlayer(linhaTiro.toUpperCase(), colunaTiro);
                        tabuleiro.mostraTabuleiro("player");
                        tabuleiro.marcaJogadasBot();
                    }
                    System.out.println("Quer jogar novamente? <s/n>");
                    flag = sc.next();

                }
                catch(Exception e) {
                    System.out.println(e);
                }
            }




        }
}

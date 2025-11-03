package br.senai.sp.jandira.tabuada.model;

import java.util.Scanner;

public class Usuario {

      public int multiplicando;
       public int multiplicadorInicial;
        public int multiplicadorFinal;
        public int tamanho;
        public String[] tabuada;

        public void obterDados(){
            Scanner leitor = new Scanner(System.in);

            System.out.print("Qual é o valor do multiplicando?: ");
            multiplicando = leitor.nextInt();

            System.out.print("Qual o valor do multiplicadorInicial?: ");
            multiplicadorInicial = leitor.nextInt();

            System.out.print("Qual o valor do multiplicadorFinal?: ");
            multiplicadorFinal = leitor.nextInt();

            calcularTabuada();
        }
        public void calcularTabuada(){
            int apoio = 0;
            if (multiplicadorFinal < multiplicadorInicial){ // se o usuário colocar um multiplicador final colocar um valor maior que o inicial (que é impossível de calcular)
                apoio = multiplicadorFinal; //A variavel apoio vai pegar o número do multiplicador final
                multiplicadorFinal = multiplicadorInicial; //O número do multiplicador Final vai virar o multiplicador Inicial
                multiplicadorInicial = apoio; //O multiplicador final Ficando com o número do multiplicador inical, ele recepera o numero guardado da variavel apoio, assim, invertendo
            }
            int tamanho = multiplicadorFinal - multiplicadorInicial + 1;
            tabuada = new String [tamanho];

            int i = 0;
            while (i < tamanho){
                int produto =  multiplicando * multiplicadorInicial;
                tabuada[i] = multiplicando + " X "  + multiplicadorInicial + " = " + produto;
                multiplicadorInicial = multiplicadorInicial + 1;
                i =  i + 1;
            }
        exibirDados();
    }
    public void exibirDados(){
        System.out.print("Resultado da sua tabuada: ");

        int i = 0;
        while (i < tabuada.length){
            System.out.println(tabuada[i]);
            i++; //i = i = 1
        }
    }
}

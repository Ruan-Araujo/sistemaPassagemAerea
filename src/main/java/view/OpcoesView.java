package view;

import java.util.Scanner;

public class OpcoesView {
    public void listaOpcoes() {
        System.out.println("------------------------------");
        System.out.println("| O que você deseja fazer?   |");
        System.out.println("------------------------------");
        System.out.println("| 1 - Login                  |");
        System.out.println("| 2 - Registrar              |");
        System.out.println("| 3 - Deletar conta          |");
        System.out.println("| 4 - Listar Rotas           |");
        System.out.println("| 5 - Realizar Reserva       |");
        System.out.println("| 6 - Cancelar Reserva       |");
        System.out.println("| 7 - Visualizar Reserva     |");
        System.out.println("| 8 - Desconectar            |");
        System.out.println("| 0 - Sair                   |");
        System.out.println("------------------------------\n");
        try{
            Scanner sc = new Scanner(System.in);
            int opcao = sc.nextInt();
            aplicaOpcoes(opcao);
        }catch (Exception e){
            System.out.println("\nOpção escolhida não foi encontrada, tente novamente!");
            listaOpcoes();
        }
    }

    public void aplicaOpcoes(int opcao) {
        if (opcao == 0) {
            System.out.println("Finalizando!");
        }else{
            Invoker.invoke(opcao);
            System.out.println();
            listaOpcoes();
        }
    }
}

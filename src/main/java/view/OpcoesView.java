package view;

import java.util.Scanner;

public class OpcoesView {
    private Scanner sc = new Scanner(System.in);

    public void listaOpcoes() {
        System.out.println("1 - Login");
        System.out.println("2 - Registrar");
        System.out.println("3 - Listar Rotas");
        System.out.println("4 - Realizar Reserva");
        System.out.println("5 - Cancelar Reserva");
        System.out.println("0 - Cancelar");
        int opcao = sc.nextInt();
        aplicaOpcoes(opcao);
    }

    public void aplicaOpcoes(int opcao) {
        if (opcao == 0) {
            System.out.println("Finalizando!");
        }else{
            Invoker.invoke(opcao);
            listaOpcoes();
        }
    }


}

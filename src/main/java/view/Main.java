package view;

public class Main {

    public static void main(String[] args) {
        OpcoesView opcoes = new OpcoesView();

        System.out.println("Bem vindo a AeroFive pacotes de viagens!!");
        System.out.println();
        System.out.println("         _\\ _~-\\___\n" +
                "    =  = ==(____AA____D\n" +
                "                \\_____\\___________________,-~~~~~~~`-.._\n" +
                "                /     o O o o o o O O o o o o o o O o  |\\_\n" +
                "                `~-.__        ___..----..                  )\n" +
                "                      `---~~\\___________/------------`````\n" +
                "                      =  ===(_________D");
        System.out.println();
        System.out.println("O que você deseja fazer? ");
        opcoes.listaOpcoes();
    }
}

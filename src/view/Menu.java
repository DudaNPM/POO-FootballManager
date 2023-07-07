package view;

import java.util.*;

//  VIEW  //

public class Menu {

    public static int MenuInicial() {
        StringBuilder sb = new StringBuilder("\n\n|-------------------------------------------|\n");
        sb.append("|-----------FOOTBALL MANAGER MENU-----------|\n");
        sb.append("|-------------------------------------------|\n\n");
        sb.append(" 1) Criar jogador.\n");
        sb.append(" 2) Criar equipa.\n");
        sb.append(" 3) Associar jogador a uma equipa.\n");
        sb.append(" 4) Mudar jogador de equipa.\n");
        sb.append(" 5) Consultar jogador.\n");
        sb.append(" 6) Consultar equipa.\n");
        sb.append(" 7) Calcular habilidade de um jogador.\n");
        sb.append(" 8) Calcular habilidade global de uma equipa.\n");
        sb.append(" 9) Guardar estado atual do jogo.\n");
        sb.append("10) Carregar estado de um ficheiro.\n");
        sb.append(" 0) Sair.\n\n");
        sb.append("Selecione uma opção: ");
        System.out.print(sb);
        Scanner scanner = new Scanner(System.in);
        int param = scanner.nextInt();
        while(param < 0 || param > 10) {
            ErrorMsg(1);
            param = MenuInicial();
        }
        return param;
    }

    public static void MenuCriaJogador() {
        System.out.println("\n\n|-------------------------------------------|");
        System.out.println("|-------------BUILD PLAYER MENU-------------|\n");
    }

    public static void MenuCriaEquipa() {
        System.out.println("\n\n|-------------------------------------------|");
        System.out.println("|--------------BUILD TEAM MENU--------------|\n");
    }

    public static int AskTipoJogador(){
        StringBuilder sb = new StringBuilder();
        sb.append("1) Guarda-Redes.\n");
        sb.append("2) Defesa.\n");
        sb.append("3) Médio.\n");
        sb.append("4) Lateral.\n");
        sb.append("5) Avançado.\n\n");
        sb.append("Escolha um tipo de jogador: ");
        System.out.print(sb);
        Scanner scanner = new Scanner(System.in);
        int param = scanner.nextInt();
        while(param < 1 || param > 5) {
            ErrorMsg(1);
            param = AskTipoJogador();
        }
        return param;
    }

    public static String AskNomeJogador(){
        System.out.print("Nome do jogador: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static String AskNomeEquipa(){
        System.out.print("Nome da equipa: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static int AskNumJogador(){
        System.out.print("Número da camisola do jogador: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static int AskParamJogador(String caracteristica){
        System.out.print("Parâmetro " + caracteristica + " do jogador (1-100): ");
        Scanner scanner = new Scanner(System.in);
        int param = scanner.nextInt();
        while(param < 1 || param > 100) {
            ErrorMsg(1);
            param = AskParamJogador(caracteristica);
        }
        return param;
    }

    public static int AskHabEspJogador(int tipoJogador){
        switch (tipoJogador){
            case 1 -> System.out.print("Parâmetro elasticidade do jogador (1-100): ");
            case 2 -> System.out.print("Parâmetro capacidade de corte do jogador (1-100): ");
            case 3 -> System.out.print("Parâmetro recuperação de bola do jogador (1-100): ");
            case 4 -> System.out.print("Parâmetro capacidade de cruzamento do jogador (1-100): ");
            case 5 -> System.out.print("Parâmetro precisão do jogador (1-100): ");
        }
        Scanner scanner = new Scanner(System.in);
        int param = scanner.nextInt();
        while(param < 1 || param > 100) {
            ErrorMsg(1);
            param = AskHabEspJogador(tipoJogador);
        }
        return param;
    }

    public static void SuccessMsg(String nome, int msg){
        switch (msg){
            case 1 -> System.out.println("Jogador " + nome + " criado com sucesso.\n");
            case 2 -> System.out.println("Equipa " + nome + " criada com sucesso.\n");
            case 3 -> System.out.println("model.Estado guardado com sucesso para o ficheiro " + nome + ".\n");
            case 4 -> System.out.println("model.Estado carregado com sucesso do ficheiro " + nome + ".\n");
            case 5 -> System.out.println("Jogador adicionado com sucesso.\n");
            case 6 -> System.out.println("Mudança executada com sucesso.\n");
        }
    }

    public static void ExitMsg(){
        System.out.println("Até à próxima jogador !!!");
    }

    public static void ErrorMsg(int error){
        switch (error) {
            case 1 -> System.out.println("Opção indisponível, tente novamente.\n");
            case 2 -> System.out.println("Jogador inexistente, tente novamente.\n");
            case 3 -> System.out.println("Não existem jogadores.\n");
            case 4 -> System.out.println("Não existem equipas.\n");
            case 5 -> System.out.println("Equipa inexistente, tente novamente.\n");
            case 7 -> System.out.println("Equipas insuficientes para realizar a mudança.\n");
            case 8 -> System.out.println("Todas as equipas estão cheias.\n");
            case 9 -> System.out.println("Ficheiro inexistente.\n");
        }
    }

    public static String AskFileName(){
        System.out.print("Insira o nome do ficheiro: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static int AskFileMode(){
        StringBuilder sb = new StringBuilder();
        sb.append("1) Modo binário.\n");
        sb.append("2) Modo texto.\n");
        sb.append("Escolha uma opção: ");
        System.out.print(sb);
        Scanner scanner = new Scanner(System.in);
        int param = scanner.nextInt();
        while(param < 1 || param > 2) {
            ErrorMsg(1);
            param = AskFileMode();
        }
        return param;
    }

    public static void displayPlayers(Set<String> nomes){
        System.out.println("\nLista de jogadores:");
        for (String nome : nomes) System.out.println(nome);
        System.out.println();
    }

    public static void displayTeams(Set<String> nomes){
        System.out.println("\nLista de equipas:");
        for (String nome : nomes) System.out.println(nome);
        System.out.println();
    }
}

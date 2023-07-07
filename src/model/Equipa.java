package model;

import view.Menu;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//  MODEL  //

public class Equipa implements Serializable {

/* VARIAVEIS DE INSTANCIA */

    private String nome;
    private List<Jogador> jogadores;
    private int ocupacao;   // Numero atual de jogadores na equipa



/* CONSTRUTORES */

    /**
     * Construtor por omissão do tipo Equipa.
     */
    public Equipa(){
        this.nome = "";
        this.ocupacao = 0;
        this.jogadores = new ArrayList<>();
    }

    /**
     * Construtor parametrizado do tipo Equipa.
     * @param nome Nome da Equipa
     * @param jogadores Lista de Jogadores
     */
    public Equipa(String nome, int ocupacao, List<Jogador> jogadores){
        this.nome = nome;
        this.ocupacao = ocupacao;
        this.jogadores = jogadores.stream()
                                  .map(Jogador::clone)
                                  .collect(Collectors.toList());
    }

    /**
     * Construtor de cópia do tipo Equipa.
     * @param e Equipa a ser copiada
     */
    public Equipa(Equipa e){
        this.nome = e.getNome();
        this.ocupacao = e.getOcupacao();
        this.jogadores = e.getJogadores();
    }



/* GETS E SETS */

    /**
     * Método que atualiza o nome de uma Equipa.
     * @param nome Novo nome
     */
    public void setNome(String nome) { this.nome = nome; }

    /**
     * Método que devolve o nome de uma Equipa.
     * @return Nome
     */
    public String getNome() { return this.nome; }

    /**
     * Método que atualiza a ocupacao de uma Equipa.
     * @param ocupacao Nova ocupacao
     */
    public void setOcupacao(int ocupacao){
        this.ocupacao = ocupacao;
    }

    /**
     * Método que devolve a ocupacao de uma Equipa.
     * @return Ocupacao
     */
    public int getOcupacao(){
        return this.ocupacao;
    }

    /**
     * Método que atualiza a lista de Jogadores de uma Equipa.
     * @param jogadores Nova lista
     */
    public void setJogadores(List<Jogador> jogadores) {
        this.jogadores = jogadores.stream()
                                  .map(Jogador::clone)
                                  .collect(Collectors.toList());
    }

    /**
     * Método que devolve a lista de Jogadores de uma Equipa.
     * @return Lista de Jogadores
     */
    public List<Jogador> getJogadores() {
        return this.jogadores.stream()
                             .map(Jogador::clone)
                             .collect(Collectors.toList());
    }

    /**
     * Método que devolve a informação de uma Equipa em formato String.
     * @return String com info textual
     */
    public String toString() {
        StringBuilder sb = new StringBuilder("| Equipa ");
        sb.append(this.getNome()).append(" |");
        sb.append("\n Habilidade Global = ").append(this.calculaHabilidadeGlobal());
        sb.append("\n Ocupação = ").append(this.getOcupacao());
        sb.append("\n Lista de jogadores: ");
        sb.append(this.jogadores.stream().map(Jogador::getNome).collect(Collectors.toList())).append("\n");
        return sb.toString();
    }

    /**
     * Método de igualdade entre duas Equipas.
     * Redefinição do método equals de Object.
     * @param obj Objeto a ser comparado
     * @return true, caso sejam iguais, false caso contrário
     */
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        Equipa e = (Equipa) obj;
        return  this.nome.equals(e.getNome()) &&
                this.ocupacao == e.getOcupacao() &&
                this.jogadores.equals(e.getJogadores());
    }

    /**
     * Método de clonagem de uma Equipa.
     * @return Objeto do tipo Equipa
     */
    public Equipa clone(){ return new Equipa(this); }



/* METODOS */

    /**
     * Método que "tranforma" uma string num objeto do tipo Equipa.
     * @param input String
     * @return Equipa com os parametros apresentados na string
     */
    public static Equipa parse(String input){
        Equipa e = new Equipa();
        String[] campos = input.split(",");
        e.setNome(campos[0]);
        return e;
    }

    /**
     * Método que calcula a habilidade global de uma Equipa fazendo o somatório
     * das habilidades de todos os jogadores dessa mesma equipa.
     * @return Habilidade global
     */
    public int calculaHabilidadeGlobal(){
        if (this.jogadores.size() == 0) return 0;
        int sum = 0;
        for(Jogador j : this.jogadores) {
            sum += j.calculaHabilidade();
        }
        return sum/this.ocupacao;
    }

    /**
     * Método que permite adicionar um Jogador a uma Equipa.
     * @param j Jogador a adicionar
     */
    public void addJogador(Jogador j){
        this.jogadores.add(j.clone());
        this.ocupacao++;
    }

    /**
     * Método que permite adicionar um Jogador a uma Equipa.
     * @param j Jogador a remover
     */
    public void removeJogador(Jogador j){
        this.jogadores.remove(j);
        this.ocupacao--;
    }

    /**
     * Método que permite a mudança de um Jogador de uma Equipa para outra.
     * @param e Nova equipa
     * @param j Jogador
     */
    public void mudaJogador(Equipa e, Jogador j){
        this.removeJogador(j);
        e.addJogador(j);
        j.atualizaHistorial(this.getNome());
    }

    /**
     * Método que devolve uma string com informação textual sobre uma Equipa
     * para depois esta ser guardada num ficheiro com o restante estado do jogo.
     * @return String
     */
    public String toFile(){
        return "Equipa:" + this.nome;
    }

    /**
     * Método que trata da criação e devolução de uma equipa a partir dos dados
     * obtidos do utilizador.
     * @return Equipa
     */
    public static Equipa criaEquipa(){
        Menu.MenuCriaEquipa();
        String name =Menu.AskNomeEquipa();
        ArrayList<Jogador> jogadores = new ArrayList<>();
        Menu.SuccessMsg(name, 2);
        return new Equipa(name,0,jogadores);
    }

    /**
     * Método que verifica se o um Jogador faz parte da equipa.
     * @param jogador Jogador a procurar
     * @return True se pertencer, false caso contrário
     */
    public boolean hasPlayer(Jogador jogador){
        return this.jogadores.contains(jogador);
    }
}

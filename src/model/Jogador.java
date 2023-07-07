package model;

import view.Menu;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//  MODEL  //

public abstract class Jogador implements Serializable {

/* VARIAVEIS DE INSTANCIA */

    // Características
    private String nome;
    private int num; // Numero da camisola
    private int velocidade, resistencia, destreza, impulsao, cabeca, remate, passe;

    // Historial
    private List<String> equipas; // Equipas por onde já passou



/* CONSTRUTORES */

    /**
     * Construtor por omissão do tipo Jogador, todos os campos são inicializados a 1, à
     * exceção do campo num, que é gerado aleatorimente, e o campo nome que é inicializado a null.
     */
    public Jogador(){
        this.nome = null;
        this.num = new Random().nextInt();
        this.velocidade = 1;
        this.resistencia = 1;
        this.destreza = 1;
        this.impulsao = 1;
        this.cabeca = 1;
        this.remate = 1;
        this.passe = 1;
        this.equipas = new ArrayList<>();
    }

    /**
     * Construtor parametrizado do tipo Jogador
     * @param nome Nome do Jogador
     * @param num Identificador/Número do Jogador
     * @param vel Velocidade do Jogador
     * @param res Resistência do Jogador
     * @param des Destreza do Jogador
     * @param imp Impulsão do Jogador
     * @param cab Jogo de cabeça do Jogador
     * @param rem Remate de um Jogador
     * @param passe Capacidade de passe do Jogador
     * @param equipas Lista de Equipas
     */
    public Jogador(String nome, int num, int vel, int res, int des,
                   int imp, int cab, int rem, int passe,
                   List<String> equipas){
        this.nome = nome;
        this.num = num;
        this.velocidade = vel;
        this.resistencia = res;
        this.destreza = des;
        this.impulsao = imp;
        this.cabeca = cab;
        this.remate = rem;
        this.passe = passe;
        this.equipas = new ArrayList<>(equipas);
    }

    /**
     * Construtor de cópia do tipo Jogador.
     * @param player Jogador a ser copiado
     */
    public Jogador(Jogador player){
        this.nome = player.getNome();
        this.num = player.getNum();
        this.velocidade = player.getVelocidade();
        this.resistencia = player.getResistencia();
        this.destreza = player.getDestreza();
        this.impulsao = player.getImpulsao();
        this.cabeca = player.getCabeca();
        this.remate = player.getRemate();
        this.passe = player.getPasse();
        this.equipas = player.getEquipas();
    }



/* GETS E SETS */

    /**
     * Método que atualiza o nome de um Jogador.
     * @param nome Novo nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Método que devolve o nome de um Jogador.
     * @return Nome
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Método que atualiza o número de um Jogador.
     * @param num Novo número
     */
    public void setNum(int num) {
        this.num = num;
    }

    /**
     * Método que devolve o número de um Jogador.
     * @return Número
     */
    public int getNum() {
        return this.num;
    }

    /**
     * Método que atualiza o valor da velocidade de um Jogador.
     * @param velocidade Novo valor da velocidade
     */
    public void setVelocidade(int velocidade){
        this.velocidade = velocidade;
    }

    /**
     * Método que devolve o valor da velocidade de um Jogador.
     * @return Valor da velocidade
     */
    public int getVelocidade(){
        return this.velocidade;
    }

    /**
     * Método que atualiza o valor da resistência de um Jogador.
     * @param resistencia Novo valor da resistência
     */
    public void setResistencia(int resistencia) {
        this.resistencia = resistencia;
    }

    /**
     * Método que devolve o valor da resistência de um Jogador.
     * @return Valor da resistência
     */
    public int getResistencia() {
        return this.resistencia;
    }

    /**
     * Método que atualiza o valor da destreza de um Jogador.
     * @param destreza Novo valor da destreza
     */
    public void setDestreza(int destreza) {
        this.destreza = destreza;
    }

    /**
     * Método que devolve o valor da destreza de um Jogador.
     * @return Valor da destreza
     */
    public int getDestreza() {
        return this.destreza;
    }

    /**
     * Método que atualiza o valor da impulsão de um Jogador.
     * @param impulsao Novo valor da impulsão
     */
    public void setImpulsao(int impulsao) {
        this.impulsao = impulsao;
    }

    /**
     * Método que devolve o valor da impulsão de um Jogador.
     * @return Valor da impulsão
     */
    public int getImpulsao() {
        return this.impulsao;
    }

    /**
     * Método que atualiza o valor do jogo de cabeça de um Jogador.
     * @param cabeca Novo valor do jogo de cabeça
     */
    public void setCabeca(int cabeca) {
        this.cabeca = cabeca;
    }

    /**
     * Método que devolve o valor do jogo de cabeça de um Jogador.
     * @return Valor do jogo de cabeça
     */
    public int getCabeca() {
        return this.cabeca;
    }

    /**
     * Método que atualiza o valor de remate de um Jogador.
     * @param remate Novo valor de remate
     */
    public void setRemate(int remate) {
        this.remate = remate;
    }

    /**
     * Método que devolve o valor de remate de um Jogador.
     * @return Valor de remate
     */
    public int getRemate() {
        return this.remate;
    }

    /**
     * Método que atualiza o valor da capacidade de passe de um Jogador.
     * @param passe Novo valor da capacidade de passe
     */
    public void setPasse(int passe) {
        this.passe = passe;
    }

    /**
     * Método que devolve o valor da capacidade de passe de um Jogador.
     * @return Valor da capacidade de passe
     */
    public int getPasse() {
        return this.passe;
    }

    /**
     * Método que atualiza o historial de equipas de um Jogador.
     * @param equipas Novo historial
     */
    public void setEquipas(List<String> equipas) {
        this.equipas = new ArrayList<>(equipas);
    }

    /**
     * Método que devolve o historial de equipas de um Jogador.
     * @return Historial de equipas
     */
    public List<String> getEquipas() {
        return new ArrayList<>(this.equipas);
    }

    /**
     * Método que devolve a informação de um Jogador em formato String.
     * @return String com info textual
     */
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(" NºCamisola = ").append(this.num);
        sb.append("; Nome = ").append(this.nome);
        sb.append("; Habilidade = ").append(this.calculaHabilidade());
        // sb.append("; Velocidade = ").append(this.velocidade);
        // sb.append("; Resistência = ").append(this.resistencia);
        // sb.append("; Destreza = ").append(this.destreza);
        // sb.append("; Impulsão = ").append(this.impulsao);
        // sb.append("; Jogo de cabeça = ").append(this.cabeca);
        // sb.append("; Remate = ").append(this.remate);
        // sb.append("; Capacidade de passe = ").append(this.passe);
        sb.append("; Historial de equipas: ").append(this.equipas);
        return sb.toString();
    }

    /**
     * Método de igualdade entre dois Jogadores.
     * Redefinição do método equals de Object.
     * @param obj Objeto a ser comparado
     * @return true, caso sejam iguais, false caso contrário
     */
    public boolean equals(Object obj){
        if(this == obj) return true;
        if(obj == null || this.getClass() != obj.getClass()) return false;
        Jogador j = (Jogador) obj;
        return  this.nome.equals(j.getNome()) &&
                this.num == j.getNum() &&
                this.velocidade == j.getVelocidade() &&
                this.resistencia == j.getResistencia() &&
                this.destreza == j.getDestreza() &&
                this.impulsao == j.getImpulsao() &&
                this.cabeca == j.getCabeca() &&
                this.remate == j.getRemate() &&
                this.passe == j.getPasse();
    }



/* METODOS */

    public abstract Jogador clone();
    public abstract int calculaHabilidade();
    public abstract String toFile();

    /**
     * Método que adiciona uma equipa ao historial de um Jogador.
     * @param equipa Equipa
     */
    public void atualizaHistorial(String equipa){
        this.equipas.add(equipa);
    }

    /**
     * Método que trata da criação e devolução de um jogador a partir dos dados
     * obtidos do utilizador.
     * @return Jogador
     */
    public static Jogador criaJogador(){
        Menu.MenuCriaJogador();
        int tipoJogador = Menu.AskTipoJogador();
        String nome = Menu.AskNomeJogador();
        int numero = Menu.AskNumJogador();
        int vel = Menu.AskParamJogador("velocidade");
        int res = Menu.AskParamJogador("resistência");
        int des = Menu.AskParamJogador("destreza");
        int imp = Menu.AskParamJogador("impulsão");
        int cab = Menu.AskParamJogador("jogo de cabeça");
        int rem = Menu.AskParamJogador("remate");
        int passe = Menu.AskParamJogador("capacidade de passe");
        int hab = Menu.AskHabEspJogador(tipoJogador);
        Jogador j = null;
        List<String> historial = new ArrayList<>();
        switch (tipoJogador){
            case 1 -> j = new GuardaRedes(nome, numero, vel, res, des, imp, cab, rem, passe, historial, hab);
            case 2 -> j = new Defesa(nome, numero, vel, res, des, imp, cab, rem, passe, historial, hab);
            case 3 -> j = new Medio(nome, numero, vel, res, des, imp, cab, rem, passe, historial, hab);
            case 4 -> j = new Lateral(nome, numero, vel, res, des, imp, cab, rem, passe, historial, hab);
            case 5 -> j = new Avancado(nome, numero, vel, res, des, imp, cab, rem, passe, historial, hab);
        }
        Menu.SuccessMsg(nome, 1);
        return j;
    }
}












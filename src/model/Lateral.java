package model;

import java.util.ArrayList;
import java.util.List;

public class Lateral extends Jogador {

    // Fatores que influenciam a habilidade de um jogador (lateral)
    private static final double velFactor = 1.9;
    private static final double resFactor = 0.8;
    private static final double desFactor = 0.7;
    private static final double impFactor = 1.8;
    private static final double cabecaFactor = 0.5;
    private static final double remateFactor = 0.6;
    private static final double passeFactor = 0.7;

    // Característica única dos laterais
    private int cruzamento;



/* CONSTRUTORES */

    /**
     * Construtor por omissão do tipo Lateral.
     */
    public Lateral(){
        super();
        this.cruzamento = 1;
    }

    /**
     * Construtor parametrizado do tipo Lateral
     * @param cruzamento Cruzamento de um Lateral
     */
    public Lateral(String nome, int id, int velocidade,
                   int resistencia, int destreza,
                   int impulsao, int jogo_de_cabeca,
                   int remate, int capacidade_de_passe,
                   List<String> equipas, int cruzamento){
        super(nome,id,velocidade,resistencia,destreza,impulsao,jogo_de_cabeca,remate,capacidade_de_passe, equipas);
        this.cruzamento = cruzamento;
    }

    /**
     * Construtor de cópia do tipo Lateral.
     * @param l Jogador a ser copiado
     */
    public Lateral(Lateral l){
        super(l);
        this.cruzamento = l.getCruzamento();
    }



/* GETS E SETS */

    /**
     * Método que devolve a capacidade de cruzamento de um Lateral.
     * @return Valor do cruzamento
     */
    public int getCruzamento(){
        return this.cruzamento;
    }

    /**
     * Método que atualiza a capacidade de cruzamento de um Lateral.
     * @param cruzamento Novo valor do cruzamento
     */
    public void setCruzamento(int cruzamento){
        this.cruzamento = cruzamento;
    }

    /**
     * Método que devolve a informação de um Lateral em formato String.
     * @return String com info textual
     */
    public String toString(){
        StringBuilder sb = new StringBuilder(super.toString());
        // sb.append(" Habilidade de cruzamento = ").append(this.cruzamento);
        return sb.toString();
    }

    /**
     * Método de igualdade entre dois Laterais.
     * Redefinição do método equals de Object.
     * @param obj Objeto a ser comparado
     * @return true, caso sejam iguais, false caso contrário
     */
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        Lateral l = (Lateral) obj;
        return super.equals(l) && this.cruzamento == l.getCruzamento();
    }

    /**
     * Método de clonagem de um Lateral.
     * @return Objeto do tipo Lateral
     */
    public Lateral clone(){
        return new Lateral(this);
    }



/* METODOS */

    /**
     * Método que "tranforma" uma string num objeto do tipo Jogador Lateral.
     * @param input String
     * @return Lateral com os parametros apresentados na string
     */
    public static Jogador parse(String input){
        String[] campos = input.split(",");
        if (campos.length != 10) return null;
        return new Lateral(campos[0],                      // nome
                           Integer.parseInt(campos[1]),    // num camisola
                           Integer.parseInt(campos[2]),    // velociade
                           Integer.parseInt(campos[3]),    // resistencia
                           Integer.parseInt(campos[4]),    // destreza
                           Integer.parseInt(campos[5]),    // impulsao
                           Integer.parseInt(campos[6]),    // jogo de cabeca
                           Integer.parseInt(campos[7]),    // remate
                           Integer.parseInt(campos[8]),    // passe
                           new ArrayList<>(),              // historial de equipas
                           Integer.parseInt(campos[9]));   // cruzamento
    }

    /**
     * Método que calcula a habilidade de um Jogador do tipo Lateral
     * @return Habilidade
     */
    public int calculaHabilidade(){
        return (int) (super.getVelocidade() * velFactor +
                        super.getResistencia() * resFactor +
                        super.getDestreza() * desFactor +
                        super.getImpulsao() * impFactor +
                        super.getCabeca() * cabecaFactor +
                        super.getRemate() * remateFactor +
                        super.getPasse() * passeFactor +
                        this.getCruzamento()) / 8;
    }

    /**
     * Método que devolve uma string com informação textual sobre um Lateral
     * para depois esta ser guardada num ficheiro com o restante estado do jogo.
     * @return String
     */
    public String toFile(){
        StringBuilder sb = new StringBuilder("Lateral:");
        sb.append(super.getNome()).append(',');
        sb.append(super.getNum()).append(',');
        sb.append(super.getVelocidade()).append(',');
        sb.append(super.getResistencia()).append(',');
        sb.append(super.getDestreza()).append(',');
        sb.append(super.getImpulsao()).append(',');
        sb.append(super.getCabeca()).append(',');
        sb.append(super.getRemate()).append(',');
        sb.append(super.getPasse()).append(',');
        sb.append(this.cruzamento);
        return sb.toString();
    }
}

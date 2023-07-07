package model;

import java.util.ArrayList;
import java.util.List;

public class Medio extends Jogador {

    // Fatores que influenciam a habilidade de um jogador (médio)
    private static final double velFactor = 1.7;
    private static final double resFactor = 0.7;
    private static final double desFactor = 0.9;
    private static final double impFactor = 1.1;
    private static final double cabecaFactor = 0.3;
    private static final double remateFactor = 0.5;
    private static final double passeFactor = 1.8;

    // Característica única dos médios
    private int recuperacao;



/* CONSTRUTORES */

    /**
     * Construtor por omissão do tipo Medio.
     */
    public Medio(){
        super();
        this.recuperacao = 1;
    }

    /**
     * Construtor parametrizado do tipo Medio
     * @param recuperacao Recuperacao de um Medio
     */
    public Medio(String nome, int id, int velocidade,
                 int resistencia, int destreza,
                 int impulsao, int jogo_de_cabeca,
                 int remate, int capacidade_de_passe,
                 List<String> equipas, int recuperacao){
        super(nome,id,velocidade,resistencia,destreza,impulsao,jogo_de_cabeca,remate,capacidade_de_passe, equipas);
        this.recuperacao = recuperacao;
    }

    /**
     * Construtor de cópia do tipo Medio.
     * @param m Jogador a ser copiado
     */
    public Medio(Medio m){
        super(m);
        this.recuperacao = m.getRecuperacao();
    }



/* GETS E SETS */

    /**
     * Método que devolve a capacidade de recuperacao de um Medio.
     * @return Valor da recuperacao
     */
    public int getRecuperacao(){
        return this.recuperacao;
    }

    /**
     * Método que atualiza a capacidade de recuperacao de um Medio.
     * @param recuperacao Novo valor da recuperacao
     */
    public void setRecuperacao(int recuperacao){
        this.recuperacao = recuperacao;
    }

    /**
     * Método que devolve a informação de um Medio em formato String.
     * @return String com info textual
     */
    public String toString(){
        StringBuilder sb = new StringBuilder(super.toString());
        // sb.append(" Capacidade de recuperação de bola = ").append(this.recuperacao);
        return sb.toString();
    }

    /**
     * Método de igualdade entre dois Medios.
     * Redefinição do método equals de Object.
     * @param obj Objeto a ser comparado
     * @return true, caso sejam iguais, false caso contrário
     */
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        Medio m = (Medio) obj;
        return super.equals(m) && this.recuperacao == m.getRecuperacao();
    }

    /**
     * Método de clonagem de um Medio.
     * @return Objeto do tipo Medio
     */
    public Medio clone(){
        return new Medio(this);
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
        return new Medio(campos[0],                      // nome
                         Integer.parseInt(campos[1]),    // num camisola
                         Integer.parseInt(campos[2]),    // velociade
                         Integer.parseInt(campos[3]),    // resistencia
                         Integer.parseInt(campos[4]),    // destreza
                         Integer.parseInt(campos[5]),    // impulsao
                         Integer.parseInt(campos[6]),    // jogo de cabeca
                         Integer.parseInt(campos[7]),    // remate
                         Integer.parseInt(campos[8]),    // passe
                         new ArrayList<>(),              // historial de equipas
                         Integer.parseInt(campos[9]));   // recuperacao
    }

    /**
     * Método que calcula a habilidade de um Jogador do tipo Medio
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
                        this.getRecuperacao()) / 8;
    }

    /**
     * Método que devolve uma string com informação textual sobre um Medio
     * para depois esta ser guardada num ficheiro com o restante estado do jogo.
     * @return String
     */
    public String toFile(){
        StringBuilder sb = new StringBuilder("Medio:");
        sb.append(super.getNome()).append(',');
        sb.append(super.getNum()).append(',');
        sb.append(super.getVelocidade()).append(',');
        sb.append(super.getResistencia()).append(',');
        sb.append(super.getDestreza()).append(',');
        sb.append(super.getImpulsao()).append(',');
        sb.append(super.getCabeca()).append(',');
        sb.append(super.getRemate()).append(',');
        sb.append(super.getPasse()).append(',');
        sb.append(this.recuperacao);
        return sb.toString();
    }
}

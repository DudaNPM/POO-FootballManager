package model;

import java.util.ArrayList;
import java.util.List;

public class Avancado extends Jogador {

    // Fatores que influenciam a habilidade de um jogador (avançado)
    private static final double velFactor = 0.6;
    private static final double resFactor = 0.8;
    private static final double desFactor = 0.6;
    private static final double impFactor = 0.5;
    private static final double cabecaFactor = 1.4;
    private static final double remateFactor = 2.4;
    private static final double passeFactor = 0.7;

    // Característica única dos avançados
    private int precisao;



/* CONSTRUTORES */

    /**
     * Construtor por omissão do tipo Avancado.
     */
    public Avancado(){
        super();
        this.precisao = 1;
    }

    /**
     * Construtor parametrizado do tipo Avancado
     * @param precisao Precisao de um Avancado
     */
    public Avancado(String nome, int id, int velocidade,
                    int resistencia, int destreza,
                    int impulsao, int jogo_de_cabeca,
                    int remate, int capacidade_de_passe,
                    List<String> equipas, int precisao){
        super(nome, id,velocidade,resistencia,destreza,impulsao,jogo_de_cabeca,remate,capacidade_de_passe, equipas);
        this.precisao = precisao;
    }

    /**
     * Construtor de cópia do tipo Avancado.
     * @param a Jogador a ser copiado
     */
    public Avancado(Avancado a){
        super(a);
        this.precisao = a.getPrecisao();
    }



/* GETS E SETS */

    /**
     * Método que devolve a capacidade de precisão de um Avancado.
     * @return Valor da precisão
     */
    public int getPrecisao(){
        return this.precisao;
    }

    /**
     * Método que atualiza a precisão de um Avancado.
     * @param precisao Novo valor da precisão
     */
    public void setPrecisao(int precisao){
        this.precisao = precisao;
    }

    /**
     * Método que devolve a informação de um Avancado em formato String.
     * @return String com info textual
     */
    public String toString(){
        StringBuilder sb = new StringBuilder(super.toString());
        // sb.append(" Precisão de remate = ").append(this.precisao);
        return sb.toString();
    }

    /**
     * Método de igualdade entre dois Avancados.
     * Redefinição do método equals de Object.
     * @param obj Objeto a ser comparado
     * @return true, caso sejam iguais, false caso contrário
     */
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        Avancado a = (Avancado) obj;
        return super.equals(a) && this.precisao == a.getPrecisao();
    }

    /**
     * Método de clonagem de um Avancado.
     * @return Objeto do tipo Avancado
     */
    public Avancado clone(){
        return new Avancado(this);
    }



/* METODOS */

    /**
     * Método que "tranforma" uma string num objeto do tipo Jogador Avancado.
     * @param input String
     * @return Avancado com os parametros apresentados na string
     */
    public static Jogador parse(String input){
        String[] campos = input.split(",");
        if (campos.length != 10) return null;
        return new Avancado(campos[0],                      // nome
                            Integer.parseInt(campos[1]),    // num camisola
                            Integer.parseInt(campos[2]),    // velociade
                            Integer.parseInt(campos[3]),    // resistencia
                            Integer.parseInt(campos[4]),    // destreza
                            Integer.parseInt(campos[5]),    // impulsao
                            Integer.parseInt(campos[6]),    // jogo de cabeca
                            Integer.parseInt(campos[7]),    // remate
                            Integer.parseInt(campos[8]),    // passe
                            new ArrayList<>(),              // historial de equipas
                            Integer.parseInt(campos[9]));   // precisao
    }

    /**
     * Método que calcula a habilidade de um Jogador do tipo Avancado
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
                        this.getPrecisao()) / 8;
    }

    /**
     * Método que devolve uma string com informação textual sobre um Avançado
     * para depois esta ser guardada num ficheiro com o restante estado do jogo.
     * @return String
     */
    public String toFile(){
        StringBuilder sb = new StringBuilder("Avancado:");
        sb.append(super.getNome()).append(',');
        sb.append(super.getNum()).append(',');
        sb.append(super.getVelocidade()).append(',');
        sb.append(super.getResistencia()).append(',');
        sb.append(super.getDestreza()).append(',');
        sb.append(super.getImpulsao()).append(',');
        sb.append(super.getCabeca()).append(',');
        sb.append(super.getRemate()).append(',');
        sb.append(super.getPasse()).append(',');
        sb.append(this.precisao);
        return sb.toString();
    }
}

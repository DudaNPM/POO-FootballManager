package model;

import java.util.ArrayList;
import java.util.List;

public class GuardaRedes extends Jogador {

    // Fatores que influenciam a habilidade de um jogador (guarda-redes)
    private static final double velFactor = 0.4;
    private static final double resFactor = 0.7;
    private static final double desFactor = 0.5;
    private static final double impFactor = 0.6;
    private static final double cabecaFactor = 0.3;
    private static final double remateFactor = 2.9;
    private static final double passeFactor = 1.6;

    // Característica única dos guarda-redes
    private int elasticidade;



/* CONSTRUTORES */

    /**
     * Construtor por omissão do tipo GuardaRedes.
     */
    public GuardaRedes(){
        super();
        this.elasticidade = 1;
    }

    /**
     * Construtor parametrizado do tipo GuardaRedes
     * @param elasticidade Elasticidade de um GuardaRedes
     */
    public GuardaRedes(String nome, int id, int velocidade,
                       int resistencia, int destreza,
                       int impulsao, int jogo_de_cabeca,
                       int remate, int capacidade_de_passe,
                       List<String> equipas, int elasticidade){
        super(nome, id,velocidade,resistencia,destreza,impulsao,jogo_de_cabeca,remate,capacidade_de_passe, equipas);
        this.elasticidade = elasticidade;
    }

    /**
     * Construtor de cópia do tipo GuardaRedes.
     * @param gr Jogador a ser copiado
     */
    public GuardaRedes(GuardaRedes gr){
        super(gr);
        this.elasticidade = gr.getElasticidade();
    }



/* GETS E SETS */

    /**
     * Método que devolve a capacidade de elasticidade de um GuardaRedes.
     * @return Valor da elasticidade
     */
    public int getElasticidade(){
        return this.elasticidade;
    }

    /**
     * Método que atualiza a capacidade de elasticidade de um GuardaRedes.
     * @param elasticidade Novo valor da elasticidade
     */
    public void setElasticidade(int elasticidade){
        this.elasticidade = elasticidade;
    }

    /**
     * Método que devolve a informação de um GuardaRedes em formato String.
     * @return String com info textual
     */
    public String toString(){
        StringBuilder sb = new StringBuilder(super.toString());
        // sb.append(" Elasticidade = ").append(this.elasticidade);
        return sb.toString();
    }

    /**
     * Método de igualdade entre dois GuardaRedes.
     * Redefinição do método equals de Object.
     * @param obj Objeto a ser comparado
     * @return true, caso sejam iguais, false caso contrário
     */
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        GuardaRedes gr = (GuardaRedes) obj;
        return super.equals(gr) && this.elasticidade == gr.getElasticidade();
    }

    /**
     * Método de clonagem de um GuardaRedes.
     * @return Objeto do tipo GuardaRedes
     */
    public GuardaRedes clone(){
        return new GuardaRedes(this);
    }



/* METODOS */

    /**
     * Método que "tranforma" uma string num objeto do tipo Jogador GuardaRedes.
     * @param input String
     * @return GuardaRedes com os parametros apresentados na string
     */
    public static Jogador parse(String input){
        String[] campos = input.split(",");
        if (campos.length != 10) return null;
        return new GuardaRedes(campos[0],                      // nome
                               Integer.parseInt(campos[1]),    // num camisola
                               Integer.parseInt(campos[2]),    // velociade
                               Integer.parseInt(campos[3]),    // resistencia
                               Integer.parseInt(campos[4]),    // destreza
                               Integer.parseInt(campos[5]),    // impulsao
                               Integer.parseInt(campos[6]),    // jogo de cabeca
                               Integer.parseInt(campos[7]),    // remate
                               Integer.parseInt(campos[8]),    // passe
                               new ArrayList<>(),              // historial de equipas
                               Integer.parseInt(campos[9]));   // elasticidade
    }

    /**
     * Método que calcula a habilidade de um Jogador do tipo GuardaRedes
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
                        this.getElasticidade()) / 8;
    }

    /**
     * Método que devolve uma string com informação textual sobre um Guarda-Redes
     * para depois esta ser guardada num ficheiro com o restante estado do jogo.
     * @return String
     */
    public String toFile(){
        StringBuilder sb = new StringBuilder("Guarda-Redes:");
        sb.append(super.getNome()).append(',');
        sb.append(super.getNum()).append(',');
        sb.append(super.getVelocidade()).append(',');
        sb.append(super.getResistencia()).append(',');
        sb.append(super.getDestreza()).append(',');
        sb.append(super.getImpulsao()).append(',');
        sb.append(super.getCabeca()).append(',');
        sb.append(super.getRemate()).append(',');
        sb.append(super.getPasse()).append(',');
        sb.append(this.elasticidade);
        return sb.toString();
    }
}

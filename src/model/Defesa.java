package model;

import java.util.ArrayList;
import java.util.List;

public class Defesa extends Jogador {

    // Fatores que influenciam a habilidade de um jogador (defesa)
    private static final double velFactor = 0.7;
    private static final double resFactor = 1.2;
    private static final double desFactor = 0.9;
    private static final double impFactor = 0.4;
    private static final double cabecaFactor = 0.5;
    private static final double remateFactor = 0.3;
    private static final double passeFactor = 3;

    // Característica única dos defesas
    private int corte;



/* CONSTRUTORES */

    /**
     * Construtor por omissão do tipo Defesa.
     */
    public Defesa(){
        super();
        this.corte = 1;
    }

    /**
     * Construtor parametrizado do tipo Defesa
     * @param corte Corte de um Defesa
     */
    public Defesa(String nome, int id, int velocidade,
                  int resistencia, int destreza,
                  int impulsao, int jogo_de_cabeca,
                  int remate, int capacidade_de_passe,
                  List<String> equipas, int corte){
        super(nome, id,velocidade,resistencia,destreza,impulsao,jogo_de_cabeca,remate,capacidade_de_passe, equipas);
        this.corte = corte;
    }

    /**
     * Construtor de cópia do tipo Defesa.
     * @param d Jogador a ser copiado
     */
    public Defesa(Defesa d){
        super(d);
        this.corte = d.getCorte();
    }



/* GETS E SETS */

    /**
     * Método que devolve a capacidade de corte de um Defesa.
     * @return Valor do corte
     */
    public int getCorte(){
        return this.corte;
    }

    /**
     * Método que atualiza a capacidade de corte de um Defesa.
     * @param corte Novo valor do corte
     */
    public void setCorte(int corte){
        this.corte = corte;
    }

    /**
     * Método que devolve a informação de um Defesa em formato String.
     * @return String com info textual
     */
    public String toString(){
        StringBuilder sb = new StringBuilder(super.toString());
        // sb.append(" Capacidade de corte = ").append(this.corte);
        return sb.toString();
    }

    /**
     * Método de igualdade entre dois Defesas.
     * Redefinição do método equals de Object.
     * @param obj Objeto a ser comparado
     * @return true, caso sejam iguais, false caso contrário
     */
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        Defesa d = (Defesa) obj;
        return super.equals(d) && this.corte == d.getCorte();
    }

    /**
     * Método de clonagem de um Defesa.
     * @return Objeto do tipo Defesa
     */
    public Defesa clone(){
        return new Defesa(this);
    }



/* METODOS */

    /**
     * Método que "tranforma" uma string num objeto do tipo Jogador Defesa.
     * @param input String
     * @return Defesa com os parametros apresentados na string
     */
    public static Jogador parse(String input){
        String[] campos = input.split(",");
        if (campos.length != 10) return null;
        return new Defesa(campos[0],                      // nome
                          Integer.parseInt(campos[1]),    // num camisola
                          Integer.parseInt(campos[2]),    // velociade
                          Integer.parseInt(campos[3]),    // resistencia
                          Integer.parseInt(campos[4]),    // destreza
                          Integer.parseInt(campos[5]),    // impulsao
                          Integer.parseInt(campos[6]),    // jogo de cabeca
                          Integer.parseInt(campos[7]),    // remate
                          Integer.parseInt(campos[8]),    // passe
                          new ArrayList<>(),              // historial de equipas
                          Integer.parseInt(campos[9]));   // corte
    }

    /**
     * Método que calcula a habilidade de um Jogador do tipo Defesa
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
                        this.getCorte()) / 8;
    }

    /**
     * Método que devolve uma string com informação textual sobre um Defesa
     * para depois esta ser guardada num ficheiro com o restante estado do jogo.
     * @return String
     */
    public String toFile(){
        StringBuilder sb = new StringBuilder("Defesa:");
        sb.append(super.getNome()).append(',');
        sb.append(super.getNum()).append(',');
        sb.append(super.getVelocidade()).append(',');
        sb.append(super.getResistencia()).append(',');
        sb.append(super.getDestreza()).append(',');
        sb.append(super.getImpulsao()).append(',');
        sb.append(super.getCabeca()).append(',');
        sb.append(super.getRemate()).append(',');
        sb.append(super.getPasse()).append(',');
        sb.append(this.corte);
        return sb.toString();
    }
}

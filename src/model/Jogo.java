package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//  MODEL  //

public class Jogo implements Serializable {

/* VARIAVEIS DE INSTANCIA */

    private String equipaCasa;
    private String equipaFora;
    private int golosCasa;
    private int golosFora;
    private LocalDate date;
    private List<Integer> jogadoresCasa;
    private List<Integer> jogadoresFora;
    private Map<Integer, Integer> substituicoesCasa;
    private Map<Integer, Integer> substituicoesFora;



/* CONSTRUTORES */

    /**
     * Construtor por omissão do tipo Jogo.
     */
    public Jogo(){
        this.equipaCasa = "";
        this.equipaFora = "";
        this.golosCasa = 0;
        this.golosFora = 0;
        this.date = null;
        this.jogadoresCasa = new ArrayList<>();
        this.jogadoresFora = new ArrayList<>();
        this.substituicoesCasa = new HashMap<>();
        this.substituicoesFora = new HashMap<>();
    }

    /**
     * Construtor parametrizado do tipo Jogo.
     * @param ec Nome da equipa da casa
     * @param ef Nome da equipa de fora
     * @param gc Golos da casa
     * @param gf Golos de fora
     * @param d Data do Jogo
     * @param jc Lista de jogadores da casa
     * @param sc Substituições da casa
     * @param jf Lista de jogadores de fora
     * @param sf Substituições de fora
     */
    public Jogo (String ec, String ef, int gc, int gf, LocalDate d,
                 List<Integer> jc, Map<Integer,Integer> sc,
                 List<Integer> jf, Map<Integer,Integer> sf){
        this.equipaCasa = ec;
        this.equipaFora = ef;
        this.golosCasa = gc;
        this.golosFora = gf;
        this.date = d;
        this.jogadoresCasa = new ArrayList<>(jc);
        this.jogadoresFora = new ArrayList<>(jf);
        this.substituicoesCasa = new HashMap<>(sc);
        this.substituicoesFora = new HashMap<>(sf);
    }

    /**
     * Construtor de cópia do tipo Jogo.
     * @param j Jogo a ser copiada
     */
    public Jogo (Jogo j){
        this.equipaCasa = j.getEquipaCasa();
        this.equipaFora = j.getEquipaFora();
        this.golosCasa = j.getGolosCasa();
        this.golosFora = j.getGolosFora();
        this.date = j.getData();
        this.jogadoresCasa = j.getJogadoresCasa();
        this.jogadoresFora = j.getJogadoresFora();
        this.substituicoesCasa = j.getSubstituicoesCasa();
        this.substituicoesFora = j.getSubstituicoesFora();
    }



/* GETS E SETS */

    /**
     * Método que atualiza a equipa da casa de um Jogo.
     * @param equipa Novo nome da equipa
     */
    public void setEquipaCasa(String equipa) { this.equipaCasa = equipa; }

    /**
     * Método que devolve o nome da equipa da casa.
     * @return Nome
     */
    public String getEquipaCasa() { return this.equipaCasa; }

    /**
     * Método que atualiza a equipa de fora de um Jogo.
     * @param equipa Novo nome da equipa
     */
    public void setEquipaFora(String equipa) { this.equipaFora = equipa; }

    /**
     * Método que devolve o nome da equipa de fora.
     * @return Nome
     */
    public String getEquipaFora() { return this.equipaFora; }

    /**
     * Método que atualiza os golos da equipa da casa de um Jogo.
     * @param golos Novo número de golos
     */
    public void setGolosCasa(int golos) { this.golosCasa = golos; }

    /**
     * Método que devolve os golos da equipa da casa.
     * @return Número de golos da casa
     */
    public int getGolosCasa() { return this.golosCasa; }

    /**
     * Método que atualiza os golos da equipa visitante de um Jogo.
     * @param golos Novo número de golos
     */
    public void setGolosFora(int golos) { this.golosFora = golos; }

    /**
     * Método que devolve o nome da equipa de fora.
     * @return Nome
     */
    public int getGolosFora() { return this.golosFora; }

    /**
     * Método que atualiza a data de um Jogo.
     * @param date Nova data
     */
    public void setDate(LocalDate date){ this.date = date; }

    /**
     * Método que devolve a data de um Jogo
     * @return Data do Jogo
     */
    public LocalDate getData(){ return this.date; }

    /**
     * Método que atualiza a lista de jogadores da casa.
     * @param jogadores Nova lista
     */
    public void setJogadoresCasa(List<Integer> jogadores) {
        this.jogadoresCasa = new ArrayList<>(jogadores);
    }

    /**
     * Método que devolve a lista de Jogadores da casa.
     * @return Lista de Jogadores
     */
    public List<Integer> getJogadoresCasa() {
        return new ArrayList<>(this.jogadoresCasa);
    }

    /**
     * Método que atualiza a lista de jogadores visitantes.
     * @param jogadores Nova lista
     */
    public void setJogadoresFora(List<Integer> jogadores) {
        this.jogadoresFora = new ArrayList<>(jogadores);
    }

    /**
     * Método que devolve a lista de Jogadores visitantes.
     * @return Lista de Jogadores
     */
    public List<Integer> getJogadoresFora() {
        return new ArrayList<>(this.jogadoresFora);
    }

    /**
     * Método que atualiza as substituições da casa
     * @param subs Novas substituições
     */
    public void setSubstituicoesCasa(Map<Integer,Integer> subs){
        this.substituicoesCasa = new HashMap<>(subs);
    }

    /**
     * Método que devolve as substituições da casa
     * @return Substituições
     */
    public Map<Integer,Integer> getSubstituicoesCasa(){
        return new HashMap<>(this.substituicoesCasa);
    }

    /**
     * Método que atualiza as substituições do visitante
     * @param subs Novas substituições
     */
    public void setSubstituicoesFora(Map<Integer,Integer> subs){
        this.substituicoesFora = new HashMap<>(subs);
    }

    /**
     * Método que devolve as substituições do visitante
     * @return Substituições
     */
    public Map<Integer,Integer> getSubstituicoesFora(){
        return new HashMap<>(this.substituicoesFora);
    }

    /**
     * Método que devolve a informação de um Jogo em formato String.
     * @return String com info textual
     */
    public String toString() {
        StringBuilder sb = new StringBuilder("Jogo | ");
        sb.append(this.equipaCasa);
        sb.append("(").append(this.golosCasa).append(")");
        sb.append(" vs ");
        sb.append(this.equipaFora);
        sb.append("(").append(this.golosFora).append(")");
        return sb.toString();
    }

    /**
     * Método de igualdade entre dois Jogos.
     * Redefinição do método equals de Object.
     * @param obj Objeto a ser comparado
     * @return true, caso sejam iguais, false caso contrário
     */
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        Jogo j = (Jogo) obj;
        return  this.equipaCasa.equals(j.getEquipaCasa()) &&
                this.equipaFora.equals(j.getEquipaFora()) &&
                this.golosCasa == j.getGolosCasa() &&
                this.golosFora == j.getGolosFora() &&
                this.jogadoresCasa.equals(j.getJogadoresCasa()) &&
                this.jogadoresFora.equals(j.getJogadoresFora()) &&
                this.substituicoesCasa.equals(j.getSubstituicoesCasa()) &&
                this.substituicoesFora.equals(j.getSubstituicoesFora());
    }

    /**
     * Método de clonagem de uma Jogo.
     * @return Objeto do tipo Jogo
     */
    public Jogo clone(){ return new Jogo(this); }



/* METODOS */

    /**
     * Método que "tranforma" uma string num objeto do tipo Jogo.
     * @param input String
     * @return Jogo com os parametros apresentados na string
     */
    public static Jogo parse(String input) {
        String[] campos = input.split(",");
        String[] data = campos[4].split("-");
        List<Integer> jc = new ArrayList<>();
        List<Integer> jf = new ArrayList<>();
        Map<Integer, Integer> subsC = new HashMap<>();
        Map<Integer, Integer> subsF = new HashMap<>();
        for (int i = 5; i < 16; i++) {
            jc.add(Integer.parseInt(campos[i]));
        }
        for (int i = 16; i < 19; i++) {
            String[] sub = campos[i].split("->");
            subsC.put(Integer.parseInt(sub[0]), Integer.parseInt(sub[1]));
        }
        for (int i = 19; i < 30; i++) {
            jf.add(Integer.parseInt(campos[i]));
        }
        for (int i = 30; i < 33; i++) {
            String[] sub = campos[i].split("->");
            subsF.put(Integer.parseInt(sub[0]), Integer.parseInt(sub[1]));
        }
        return new Jogo(campos[0], campos[1], Integer.parseInt(campos[2]), Integer.parseInt(campos[3]),
                LocalDate.of(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2])),
                jc, subsC, jf, subsF);
    }

    /**
     * Método que devolve uma string com informação textual sobre um Jogo
     * para depois esta ser guardada num ficheiro com o restante estado do jogo.
     * @return String
     */
    public String toFile(){
        StringBuilder sb = new StringBuilder("Jogo:");
        sb.append(this.equipaCasa).append(',');
        sb.append(this.equipaFora).append(',');
        sb.append(this.golosCasa).append(',');
        sb.append(this.golosFora).append(',');
        sb.append(this.date).append(',');
        sb.append(toFileTitulares("casa"));
        sb.append(toFileSubs("casa"));
        sb.append(toFileTitulares("fora"));
        sb.append(toFileSubs("fora"));
        return sb.toString();
    }

    /**
     * Método auxiliar que devolve uma string com informação textual sobre
     * os jogadores titulares de uma Equipa para depois esta ser guardada
     * num ficheiro com o restante estado do jogo.
     * @return String
     */
    private String toFileTitulares(String equipa){
        StringBuilder sb = new StringBuilder();
        if (equipa.equals("casa"))
            for (Integer numero : this.jogadoresCasa) sb.append(numero).append(',');
        else
            for (Integer numero : this.jogadoresFora) sb.append(numero).append(',');
        return sb.toString();
    }

    /**
     * Método auxiliar que devolve uma string com informação textual sobre
     * as substituições de uma Equipa para depois esta ser guardada
     * num ficheiro com o restante estado do jogo.
     * @return String
     */
    private String toFileSubs(String equipa){
        StringBuilder sb = new StringBuilder();
        if (equipa.equals("casa"))
            for (Integer numero : this.substituicoesCasa.keySet()) {
                sb.append(numero).append("->");
                sb.append(this.substituicoesCasa.get(numero)).append(',');
            }
        else {
            for (Integer numero : this.substituicoesFora.keySet()) {
                sb.append(numero).append("->");
                sb.append(this.substituicoesFora.get(numero)).append(',');
            }
            sb.deleteCharAt(sb.lastIndexOf(","));
        }
        return sb.toString();
    }
}

package model;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

//  CONTROLLER  //

public class Estado implements Serializable {

/* VARIAVEIS DE INSTANCIA */

    private List<Jogo> jogos;
    private Map<String, Equipa> equipas; // nome, equipa
    private Map<String, Jogador> jogadores; // nome, jogador



/* CONSTRUTORES */

    /**
     * Construtor por omissão do tipo model.Estado.
     */
    public Estado(){
        this.jogos = new ArrayList<>();
        this.equipas = new HashMap<>();
        this.jogadores = new HashMap<>();
    }

    /**
     * Construtor parametrizado do tipo model.Estado
     * @param jogos Lista de Jogos
     * @param equipas Map das Equipas
     * @param jogadores Map dos Jogadores
     */
    public Estado(List<Jogo> jogos, Map<String, Equipa> equipas, Map<String, Jogador> jogadores){
        this.jogos = jogos.stream()
                          .map(Jogo::clone)
                          .collect(Collectors.toList());
        this.equipas = equipas.entrySet()
                              .stream()
                              .collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().clone()));
        this.jogadores = jogadores.entrySet()
                                  .stream()
                                  .collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().clone()));
    }

    /**
     * Construtor de cópia do tipo model.Estado.
     * @param e model.Estado a ser copiado
     */
    public Estado(Estado e){
        this.jogos = e.getJogos();
        this.equipas = e.getEquipas();
        this.jogadores = e.getJogadores();
    }



/* SETS E GETS */

    /**
     * Método que atualiza a lista de jogos.
     * @param jogos Nova lista de jogos
     */
    public void setJogos(List<Jogo> jogos){
        this.jogos = jogos.stream()
                          .map(Jogo::clone)
                          .collect(Collectors.toList());
    }

    /**
     * Método que devolve a lista de jogos.
     * @return Lista de jogos
     */
    public List<Jogo> getJogos(){
        return this.jogos.stream()
                         .map(Jogo::clone)
                         .collect(Collectors.toList());
    }

    /**
     * Método que atualiza o conjunto de equipas.
     * @param equipas Novas equipas
     */
    public void setEquipas(Map<String, Equipa> equipas){
        this.equipas = equipas.entrySet()
                              .stream()
                              .collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().clone()));
    }

    /**
     * Método que devolve o conjunto de equipas.
     * @return Conjunto de equipas
     */
    public Map<String, Equipa> getEquipas(){
        return this.equipas.entrySet()
                           .stream()
                           .collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().clone()));
    }

    /**
     * Método que atualiza o conjunto de jogadores.
     * @param jogadores Novos jogadores
     */
    public void setJogadores(Map<String, Jogador> jogadores){
        this.jogadores = jogadores.entrySet()
                                  .stream()
                                  .collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().clone()));
    }

    /**
     * Método que devolve o conjunto de jogadores.
     * @return Conjunto de jogadores
     */
    public Map<String, Jogador> getJogadores(){
        return this.jogadores.entrySet()
                             .stream()
                             .collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().clone()));
    }

    /**
     * Método de igualdade entre dois Estados.
     * Redefinição do método equals de Object.
     * @param obj Objeto a ser comparado
     * @return true, caso sejam iguais, false caso contrário
     */
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        Estado e = (Estado) obj;
        return  this.jogos.equals(e.getJogos()) &&
                this.equipas.equals(e.getEquipas()) &&
                this.jogadores.equals(e.getJogadores());
    }

    /**
     * Método que devolve a informação de um model.Estado em formato String.
     * @return String com info textual
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Jogador j : this.jogadores.values()) sb.append(j.toString());
        for (Equipa e : this.equipas.values()) sb.append(e.toString());
        for (Jogo j : this.jogos) sb.append(j.toString());
        return sb.toString();
    }

    /**
     * Método de clonagem de um model.Estado.
     * @return Objeto do tipo model.Estado
     */
    public Estado clone(){
        return new Estado(this);
    }



/* METODOS */

    /**
     * Método que permite adicionar um Jogo ao estado atual.
     * @param j Jogo a ser adicionado
     */
    public void addJogo(Jogo j){ this.jogos.add(j.clone()); }

    /**
     * Método que permite adicionar uma Equipa ao estado atual.
     * @param e Equipa a ser adicionada
     */
    public void addEquipa(Equipa e){ this.equipas.put(e.getNome(), e.clone()); }

    /**
     * Método que permite adicionar um Jogador ao estado atual.
     * @param j Jogador a ser adicionado
     */
    public void addJogador(Jogador j){ this.jogadores.put(j.getNome(), j.clone()); }

    /**
     * Método que guarda em ficheiro de objetos o objeto que recebe a mensagem.
     * @param filename Ficheiro
     */
    public void saveEstadoBin(String filename) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("db/" + filename));
        oos.writeObject(this);
        oos.close();
    }

    /**
     * Método que recupera uma instância de model.Estado de um ficheiro de objetos.
     * @param filename Ficheiro
     * @return e model.Estado inicializado
     */
    public static Estado loadEstadoBin(String filename) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("db/" + filename));
        Estado e = (Estado) ois.readObject();
        ois.close();
        return e;
    }

    /**
     * Método que guarda em ficheiro de texto o objeto que recebe a mensagem.
     * @param filename Ficheiro
     */
    public void saveEstadoTxt(String filename) throws IOException {
        PrintWriter pw = new PrintWriter("db/" + filename + ".txt");
        for (Equipa e : this.equipas.values()) {
            pw.println(e.toFile());
            for (Jogador j : e.getJogadores())
                pw.println(j.toFile());
        }
        for (Jogo j : this.jogos) pw.println(j.toFile());
        pw.flush();
        pw.close();
    }

    /**
     * Método que recupera uma instância de model.Estado de um ficheiro de texto.
     * @param filename Ficheiro
     */
    public void loadEstadoTxt(String filename) throws LinhaIncorretaException, IOException {
        this.jogos.clear(); this.equipas.clear(); this.jogadores.clear();
        List<String> lines = lerFicheiro("db/" + filename + ".txt");
        parse(lines);
    }

    /**
     * Método que lê um ficheiro e devolve uma lista com todas as linhas lidas do mesmo.
     * @param filename Ficheiro
     * @return Lista de linhas
     */
    public List<String> lerFicheiro(String filename) throws IOException {
        List<String> lines;
        lines = Files.readAllLines(Paths.get(filename), StandardCharsets.UTF_8);
        return lines;
    }

    /**
     * Método que trata da correta divisão de entidades recebidas em formato string. Estas são
     * também adicionadas ao model.Estado.
     * @param linhas Lista de strings
     */
    public void parse(List<String> linhas) throws LinhaIncorretaException {
        Equipa ultima = null;
        Jogador j;
        String[] linhaPartida;
        for (String linha : linhas) {
            linhaPartida = linha.split(":", 2);
            switch (linhaPartida[0]) {
                case "Equipa" -> {
                    Equipa e = Equipa.parse(linhaPartida[1]);
                    this.equipas.put(e.getNome(), e.clone());
                    ultima = e;
                }
                case "Guarda-Redes" -> {
                    j = GuardaRedes.parse(linhaPartida[1]);
                    if (j == null) throw new LinhaIncorretaException("File is not well-formed.");
                    this.jogadores.put(j.getNome(), j.clone());
                    if (ultima == null) throw new LinhaIncorretaException("File is not well-formed."); //we need to insert the player into the team
                    this.equipas.get(ultima.getNome()).addJogador(j); //if no team was parsed previously, file is not well-formed
                }
                case "Defesa" -> {
                    j = Defesa.parse(linhaPartida[1]);
                    if (j == null) throw new LinhaIncorretaException("File is not well-formed.");
                    this.jogadores.put(j.getNome(), j.clone());
                    if (ultima == null) throw new LinhaIncorretaException("File is not well-formed."); //we need to insert the player into the team
                    this.equipas.get(ultima.getNome()).addJogador(j); //if no team was parsed previously, file is not well-formed
                }
                case "Medio" -> {
                    j = Medio.parse(linhaPartida[1]);
                    if (j == null) throw new LinhaIncorretaException("File is not well-formed.");
                    this.jogadores.put(j.getNome(), j.clone());
                    if (ultima == null) throw new LinhaIncorretaException("File is not well-formed."); //we need to insert the player into the team
                    this.equipas.get(ultima.getNome()).addJogador(j); //if no team was parsed previously, file is not well-formed
                }
                case "Lateral" -> {
                    j = Lateral.parse(linhaPartida[1]);
                    if (j == null) throw new LinhaIncorretaException("File is not well-formed.");
                    this.jogadores.put(j.getNome(), j.clone());
                    if (ultima == null) throw new LinhaIncorretaException("File is not well-formed."); //we need to insert the player into the team
                    this.equipas.get(ultima.getNome()).addJogador(j); //if no team was parsed previously, file is not well-formed
                }
                case "Avancado" -> {
                    j = Avancado.parse(linhaPartida[1]);
                    if (j == null) throw new LinhaIncorretaException("File is not well-formed.");
                    this.jogadores.put(j.getNome(), j.clone());
                    if (ultima == null) throw new LinhaIncorretaException("File is not well-formed."); //we need to insert the player into the team
                    this.equipas.get(ultima.getNome()).addJogador(j); //if no team was parsed previously, file is not well-formed
                }
                case "Jogo" -> {
                    Jogo jo = Jogo.parse(linhaPartida[1]);
                    this.jogos.add(jo.clone());
                }
                default -> throw new LinhaIncorretaException("File is not well-formed.");
            }
        }
    }

    /**
     * Método que devolve a habilidade de um Jogador.
     * @param nome Nome do Jogador
     * @return Habilidade do Jogador, -1 caso contrário
     */
    public int habJogador(String nome){
        if (this.jogadores.containsKey(nome))
            return this.jogadores.get(nome).calculaHabilidade();
        else return -1;
    }

    /**
     * Método que devolve a habilidade global de uma Equipa.
     * @param nome Nome da Equipa
     * @return Habilidade da Equipa, -1 caso contrário
     */
    public int habEquipa(String nome){
        if (this.equipas.containsKey(nome))
            return this.equipas.get(nome).calculaHabilidadeGlobal();
        else return -1;
    }

    /**
     * Método que devolve o conjunto de nomes dos jogadores que não estão
     * associados a uma equipa.
     * @return Jogadores livres
     */
    public Set<String> jogadoresLivres(){
        Set<String> jogadores = new TreeSet<>();
        int aux = 0;
        for (Jogador j : this.jogadores.values()){
            for (Equipa e : this.equipas.values())
                if (e.hasPlayer(j)) { aux = 1; break; }
            if (aux == 0) jogadores.add(j.getNome());
            else aux = 0;
        }
        return jogadores;
    }

    /**
     * Método que devolve o conjunto de nomes dos jogadores que estão
     * associados a uma equipa.
     * @return Jogadores ocupados
     */
    public Set<String> jogadoresOcupados(){
        Set<String> jogadores = new TreeSet<>();
        for (Equipa e : this.equipas.values()){
            for (Jogador j : e.getJogadores())
                jogadores.add(j.getNome());
        }
        return jogadores;
    }

    /**
     * Método que devolve o conjunto de nomes das equipas que não
     * têm a capacidade máxima de jogadores
     * @return Equipas livres
     */
    public Set<String> equipasLivres(){
        Set<String> equipas = new TreeSet<>();
        for (Equipa e : this.equipas.values())
            if (e.getOcupacao() < 20) // supondo que 20 é o limite max de jogadores que uma equipa pode ter
                equipas.add(e.getNome());
        return equipas;
    }

    /**
     * Método que conta quantas equipas atingiram a
     * capacidade máxima de jogadores.
     * @return Número de equipas
     */
    public int equipasCheias(){
        int count = 0;
        for (Equipa e : this.equipas.values())
            if (e.getOcupacao() == 20) count++;
        return count;
    }

    /**
     * Método que devolve a Equipa a que um Jogador pertence.
     * @param j Jogador
     * @return Equipa do jogador, null caso não tenha equipa
     */
    public Equipa playerTeam(Jogador j){
        for (Equipa e : this.equipas.values())
            if (e.hasPlayer(j)) return e;
        return null;
    }

    /**
     * Método que trata da transferência de um Jogador de
     * uma Equipa para outra.
     * @param pre Equipa anterior
     * @param pos Equipa posterior
     * @param jog Jogador
     */
    public void makeContract(String pre, String pos, String jog){
        Equipa e1 = this.equipas.get(pre);
        Equipa e2 = this.equipas.get(pos);
        Jogador j = this.jogadores.get(jog);
        e1.mudaJogador(e2, j);
    }
}

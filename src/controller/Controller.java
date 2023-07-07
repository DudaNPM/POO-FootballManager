package controller;

import model.Equipa;
import model.Estado;
import model.Jogador;
import model.LinhaIncorretaException;
import view.Menu;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

//  CONTROLLER  //

public class Controller {
    public static void run(){
        Estado estado = new Estado();
        boolean exit = false;
        while (!exit) {
            int option = Menu.MenuInicial();
            switch (option) {
                case  0 -> {
                    exit = true; Menu.ExitMsg();
                } // leave
                case  1 -> {
                    Jogador jog = Jogador.criaJogador();
                    estado.addJogador(jog.clone());
                } // create player
                case  2 -> {
                    Equipa equipa = Equipa.criaEquipa();
                    estado.addEquipa(equipa.clone());
                } // create team
                case  3 -> {
                    if (!estado.getJogadores().isEmpty() && !estado.jogadoresLivres().isEmpty()) {
                        if (!estado.getEquipas().isEmpty() && !estado.equipasLivres().isEmpty()) {
                            Menu.displayPlayers(estado.jogadoresLivres());
                            String nomeJog = Menu.AskNomeJogador();
                            while (!estado.jogadoresLivres().contains(nomeJog)) {
                                Menu.ErrorMsg(2);
                                nomeJog = Menu.AskNomeJogador();
                            }

                            Menu.displayTeams(estado.equipasLivres());
                            String nomeEquipa = Menu.AskNomeEquipa();
                            while (!estado.equipasLivres().contains(nomeEquipa)) {
                                Menu.ErrorMsg(5);
                                nomeEquipa = Menu.AskNomeEquipa();
                            }

                            Map<String, Equipa> aux = estado.getEquipas();
                            aux.get(nomeEquipa).addJogador(estado.getJogadores().get(nomeJog));
                            estado.setEquipas(aux);
                            Menu.SuccessMsg("", 5);
                        } else Menu.ErrorMsg(4);
                    }
                    else Menu.ErrorMsg(3);
                } // joins player to a team
                case  4 -> {
                    // para haver mudança de equipa são precisas pelo menos
                    // 2 equipas e não podem estar todas cheias.
                    if (estado.getEquipas().size() >= 2) {
                        if (estado.equipasCheias() != estado.getEquipas().size()) {
                            Menu.displayPlayers(estado.jogadoresOcupados());
                            String nomeJog = Menu.AskNomeJogador();
                            while (!estado.jogadoresOcupados().contains(nomeJog)) {
                                Menu.ErrorMsg(2);
                                nomeJog = Menu.AskNomeJogador();
                            }

                            Jogador j = estado.getJogadores().get(nomeJog);
                            Equipa pre = estado.playerTeam(j);
                            Set<String> equipasLivres = estado.equipasLivres();
                            equipasLivres.remove(pre.getNome());

                            Menu.displayTeams(equipasLivres);
                            String nomeEquipa = Menu.AskNomeEquipa();
                            while (!equipasLivres.contains(nomeEquipa)) {
                                Menu.ErrorMsg(5);
                                nomeEquipa = Menu.AskNomeEquipa();
                            }

                            String pos = estado.getEquipas().get(nomeEquipa).getNome();
                            estado.makeContract(pre.getNome(), pos, j.getNome());
                            Menu.SuccessMsg("", 6);
                        } else Menu.ErrorMsg(8);
                    }
                    else Menu.ErrorMsg(7);
                } // change player team
                case  5 -> {
                    if (!estado.getJogadores().isEmpty()){
                        Menu.displayPlayers(estado.getJogadores().keySet());
                        String nomeJog = Menu.AskNomeJogador();
                        while (!estado.getJogadores().containsKey(nomeJog)){
                            Menu.ErrorMsg(2);
                            nomeJog = Menu.AskNomeJogador();
                        }
                        System.out.print(estado.getJogadores().get(nomeJog).toString());
                    }
                    else Menu.ErrorMsg(3);
                } // consult player
                case  6 -> {
                    if (!estado.getEquipas().isEmpty()){
                        Menu.displayTeams(estado.getEquipas().keySet());
                        String nomeEquipa = Menu.AskNomeEquipa();
                        while (!estado.getEquipas().containsKey(nomeEquipa)){
                            Menu.ErrorMsg(5);
                            nomeEquipa = Menu.AskNomeEquipa();
                        }
                        System.out.print(estado.getEquipas().get(nomeEquipa).toString());
                    }
                    else Menu.ErrorMsg(4);
                } // consult team
                case  7 -> {
                    if (!estado.getJogadores().isEmpty()){
                        Menu.displayPlayers(estado.getJogadores().keySet());
                        String nomeJog = Menu.AskNomeJogador();
                        int habilidade = estado.habJogador(nomeJog);
                        while (habilidade == -1){
                            Menu.ErrorMsg(2);
                            nomeJog = Menu.AskNomeJogador();
                            habilidade = estado.habJogador(nomeJog);
                        }
                        System.out.print(nomeJog + " tem uma habilidade de " + habilidade);
                    }
                    else Menu.ErrorMsg(3);
                } // calc player hab
                case  8 -> {
                    if (!estado.getEquipas().isEmpty()){
                        Menu.displayTeams(estado.getEquipas().keySet());
                        String nomeEquipa = Menu.AskNomeEquipa();
                        int habilidade = estado.habEquipa(nomeEquipa);
                        while (habilidade == -1){
                            Menu.ErrorMsg(5);
                            nomeEquipa = Menu.AskNomeEquipa();
                            habilidade = estado.habEquipa(nomeEquipa);
                        }
                        System.out.print(nomeEquipa + " tem uma habilidade global de " + habilidade);
                    }
                    else Menu.ErrorMsg(4);
                } // calc team hab
                case  9 -> {
                    int modo = Menu.AskFileMode();
                    String filename = Menu.AskFileName();
                    if (modo == 1){
                        try { estado.saveEstadoBin(filename); Menu.SuccessMsg(filename, 3); }
                        catch (IOException e) { e.printStackTrace(); }
                    } else {
                        try { estado.saveEstadoTxt(filename); Menu.SuccessMsg(filename, 3);}
                        catch (IOException e) { e.printStackTrace(); }
                    }
                } // save
                case 10 -> {
                    int modo = Menu.AskFileMode();
                    String filename = Menu.AskFileName();
                    if (modo == 1){
                        try { estado = Estado.loadEstadoBin(filename); Menu.SuccessMsg(filename, 4); }
                        catch (IOException | ClassNotFoundException exc) { exc.printStackTrace(); }
                    } else {
                        try { estado.loadEstadoTxt(filename); Menu.SuccessMsg(filename, 4); }
                        catch (IOException | LinhaIncorretaException e){ e.printStackTrace(); }
                    }
                } // load
            }
        }
    }
}

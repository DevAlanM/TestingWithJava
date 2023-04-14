package tech.ada.adamon.service;

import tech.ada.adamon.model.Adamon;
import tech.ada.adamon.model.Inventario;
import tech.ada.adamon.model.Jogador;

import java.util.ArrayList;
import java.util.List;

public class InventarioService {


    public void depositarAdamon(Inventario inventario, Adamon adamon) {
        Jogador jogador = inventario.getJogador();
        List<Adamon> adamons = jogador.getAdamons();

        boolean possuiAdamon = adamons.contains(adamon);
        boolean isEquipeMaiorQueUm = adamons.size() > 1;

        if (possuiAdamon && isEquipeMaiorQueUm) {
            inventario.getAdamons().add(adamon);
            List<Adamon> adamonsJogador = new ArrayList<>(jogador.getAdamons());
            adamonsJogador.remove(adamon);
            jogador.setAdamons(adamonsJogador);
        }

    }

    public void recuperarAdamon(Inventario inventario, Adamon adamon) {
        Jogador jogador = inventario.getJogador();

        boolean temEspacoNaEquipe = jogador.getAdamons().size() < 6;

        if (temEspacoNaEquipe) {
            List<Adamon> adamonsInventario = new ArrayList<>(inventario.getAdamons());
            adamonsInventario.remove(adamon);
            inventario.setAdamons(adamonsInventario);

            List<Adamon> equipeJogador = new ArrayList<>(jogador.getAdamons());
            equipeJogador.add(adamon);
            jogador.setAdamons(equipeJogador);
        }
    }
}

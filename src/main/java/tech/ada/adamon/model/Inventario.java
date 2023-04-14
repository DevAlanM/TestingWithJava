package tech.ada.adamon.model;

import java.util.ArrayList;
import java.util.List;

public class Inventario {


    private Jogador jogador;

    private List<Adamon> adamons;

    public Inventario() {
        adamons = new ArrayList<>();
    }

    public Jogador getJogador() {
        return jogador;
    }

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }

    public List<Adamon> getAdamons() {
        return adamons;
    }

    public void setAdamons(List<Adamon> adamons) {
        this.adamons = adamons;
    }
}

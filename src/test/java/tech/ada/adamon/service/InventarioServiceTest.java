package tech.ada.adamon.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tech.ada.adamon.model.Adamon;
import tech.ada.adamon.model.Inventario;
import tech.ada.adamon.model.Jogador;
import tech.ada.adamon.util.TestUtils;

import java.util.Collections;

public class InventarioServiceTest {


    @Test
    void deveDepositarAdamonNoInventario() {
        //cenário
        Jogador jogador = new Jogador();
        jogador.setAdamons(TestUtils.obterAdamons());
        InventarioService inventarioService = new InventarioService();

        Inventario inventario = new Inventario();
        inventario.setJogador(jogador);

        //execucao
        inventarioService.depositarAdamon(inventario, jogador.getAdamons().get(0));

        //verificação
        Assertions.assertTrue(jogador.getAdamons().size() < TestUtils.obterAdamons().size());
    }

    @Test
    void deveConseguirRecuperarAdamon() {
        Jogador jogador = new Jogador();
        jogador.setAdamons(Collections.singletonList(TestUtils.obterAdamon()));

        Inventario inventario = new Inventario();
        inventario.setAdamons(Collections.singletonList(new Adamon()));
        inventario.setJogador(jogador);

        InventarioService inventarioService = new InventarioService();

        inventarioService.recuperarAdamon(inventario, inventario.getAdamons().get(0));

        Assertions.assertTrue(jogador.getAdamons().size() > 1);
    }
}

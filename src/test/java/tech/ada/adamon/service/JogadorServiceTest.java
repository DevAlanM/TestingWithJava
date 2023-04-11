package tech.ada.adamon.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import tech.ada.adamon.model.Adamon;
import tech.ada.adamon.model.Jogador;
import tech.ada.adamon.repository.JogadorRepository;
import tech.ada.adamon.util.TestUtils;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static tech.ada.adamon.util.TestUtils.obterAdamon;
import static tech.ada.adamon.util.TestUtils.obterJogador;

@ExtendWith(MockitoExtension.class)
class JogadorServiceTest {

    @InjectMocks
    JogadorService jogadorService;

    @Mock
    private JogadorRepository repository;


    @Test
    void deveConseguirComprarAdamon() {
        //cenário
        Jogador jogador = obterJogador();
        Adamon adamon = obterAdamon();
        Mockito.when(repository.findById(jogador.getId())).thenReturn(Optional.of(jogador));
        //acao
        jogadorService.comprarAdamon(jogador, adamon);

        //verificação
        assertFalse(jogador.getAdamons().isEmpty());
        Mockito.verify(repository).save(jogador);
    }

    @Test
    void naoDeveConseguirComprarAdamonNaoPossuiSaldo() {
        //cenário
        Jogador jogador = obterJogador();
        jogador.setSaldo(BigDecimal.valueOf(0)); //saldo 0
        Adamon adamon = obterAdamon();

        //acao e verificação
        Assertions.assertThrows(RuntimeException.class, () -> { jogadorService.comprarAdamon(jogador, adamon); });
    }

    @Test
    void naoDeveConseguirComprarAdamonPoisEquipeEstaCheia() {
        //cenário
        Jogador jogador = obterJogador();
        jogador.setAdamons(TestUtils.obterAdamons()); //equipe cheia
        Adamon adamon = obterAdamon();

        //acao
        Assertions.assertThrows(RuntimeException.class, () -> { jogadorService.comprarAdamon(jogador, adamon); });
    }

}
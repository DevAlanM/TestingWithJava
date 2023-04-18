package tech.ada.adamon.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.ada.adamon.dto.SalvarJogadorDTO;
import tech.ada.adamon.dto.converter.JogadorDtoConverter;
import tech.ada.adamon.model.Adamon;
import tech.ada.adamon.model.Jogador;
import tech.ada.adamon.repository.JogadorRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class JogadorService {

    @Autowired
    private JogadorRepository jogadorRepository;


    /*
    Criar um método batalhar que recebe dois jogadores, e este método será responsável pela
    lógica de uma batalha entre duas equipes de Adamons. A lógica da batalha fica a sua escolha,
    um jogador será vitorioso o adversário não possuir mais adamons vivos (vida > 0);
     */
    public void batalhar(Jogador jogador1, Jogador jogador2) {
        List<Adamon> equipe1 = jogador1.getAdamons();
        List<Adamon> equipe2 = jogador2.getAdamons();

        while (true) {

            for (Adamon adamon1 : equipe1) {
                for (Adamon adamon2 : equipe2) {
                    adamon2.receberDano(adamon1.getAtaque());
                        equipe2.removeIf(a -> a.getVida() <= 0);
                        System.err.println("O Adamon " + adamon1.getNome() + " ganhou");


                    adamon1.receberDano(adamon2.getAtaque());
                        equipe1.removeIf(a -> a.getVida() <= 0);
                        System.err.println("O Adamon " + adamon2.getNome() + " ganhou");

                }
            }

            boolean equipe1Viva = !equipe1.isEmpty();
            boolean equipe2Viva = !equipe2.isEmpty();


            if (!equipe1Viva || !equipe2Viva) {
                break;
            }
        }

        boolean equipe1Viva = !equipe1.isEmpty();
        boolean equipe2Viva = !equipe2.isEmpty();

        if (equipe1Viva && !equipe2Viva) {
            System.out.println("Jogador 1 venceu a batalha!");
        } else if (!equipe1Viva && equipe2Viva) {
            System.out.println("Jogador 2 venceu a batalha!");
        } else {
            System.out.println("A batalha terminou em empate!");
        }
    }

    /*
        1 - Implementar preços na classe 'Adamon'
        2 - Implementar método de compra do 'Adamon'
        3 - Um jogador só pode ter no máximo 6 adamons em sua equipe
        4 - Escrever testes para este método
        5 - Pesquisar como testar um método void com 'Mockito'
     */
    public void comprarAdamon(Jogador jogador, Adamon adamon) {
        List<Adamon> equipeAdamonJogador = jogador.getAdamons();
        BigDecimal saldoAtual = jogador.getSaldo();
        BigDecimal precoAdamon = adamon.obterPreco();

        boolean possuiSaldoSuficiente = saldoAtual.compareTo(precoAdamon) > 0;
        boolean possuiEspacoNaEquipe = equipeAdamonJogador.size() < 6;

        if (possuiEspacoNaEquipe && possuiSaldoSuficiente) {
            equipeAdamonJogador.add(adamon);
            jogador.setSaldo(saldoAtual.subtract(precoAdamon));
            atualizarJogador(jogador, jogador.getId());
        } else if (!possuiSaldoSuficiente) {
            throw new RuntimeException("Não possui saldo suficiente");
        } else if (!possuiEspacoNaEquipe) {
            throw new RuntimeException("Não possui espaço na equipe");
        }
    }

    public void venderAdamon(Jogador comprador, Adamon adamon) {

    }

    public void atualizarJogador(Jogador jogador, Long idJogador) {
        encontrarJogadorPorId(idJogador);
        jogador.setId(idJogador);
        jogadorRepository.save(jogador);
    }

    public Jogador encontrarJogadorPorId(Long idJogador) {
        Optional<Jogador> optionalJogador = jogadorRepository.findById(idJogador);
        return optionalJogador
                .orElseThrow(() -> new RuntimeException("Não encontrado jogador com ID: " + idJogador));
    }

    public Jogador salvarJogador(SalvarJogadorDTO dto) {
        return jogadorRepository.save(JogadorDtoConverter.converterDto(dto));
    }


}

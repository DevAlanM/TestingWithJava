package tech.ada.adamon.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.ada.adamon.dto.SalvarJogadorDTO;
import tech.ada.adamon.dto.converter.JogadorDtoConverter;
import tech.ada.adamon.model.Adamon;
import tech.ada.adamon.model.Jogador;
import tech.ada.adamon.repository.JogadorRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
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
    public void batalhar(Jogador player1, Jogador player2) {
        List<Adamon> team1 = new ArrayList<>(player1.getAdamons());
        List<Adamon> team2 = new ArrayList<>(player2.getAdamons());

        while (!team1.isEmpty() && !team2.isEmpty()) {
            for (Iterator<Adamon> it1 = team1.iterator(); it1.hasNext();) {
                Adamon adamon1 = it1.next();
                Adamon adamon2 = team2.get((int) (Math.random() * team2.size()));

                adamon2.receberDano(adamon1.getAtaque());

                if (adamon2.getVida() <= 0) {
                    System.out.printf("%s derrotou %s\n", adamon1.getNome(), adamon2.getNome());
                    team2.remove(adamon2);
                }

                if (team2.isEmpty()) {
                    break;
                }

                adamon1.receberDano(adamon2.getAtaque());

                if (adamon1.getVida() <= 0) {
                    System.out.printf("%s derrotou %s\n", adamon2.getNome(), adamon1.getNome());
                    it1.remove();
                }

                if (team1.isEmpty()) {
                    break;
                }
            }
        }

        if (team1.isEmpty() && team2.isEmpty()) {
            System.out.println("A batalha terminou em empate!");
        } else if (team1.isEmpty()) {
            System.out.printf("Jogador %d venceu a batalha!\n", player2.getId());
        } else {
            System.out.printf("Jogador %d venceu a batalha!\n", player1.getId());
        }
    }

    /*
        1 - Implementar preços na classe 'Adamon'
        2 - Implementar método de compra do 'Adamon'
        3 - Um jogador só pode ter no máximo 6 adamons em sua equipe
        4 - Escrever testes para este método
        5 - Pesquisar como testar um método void com 'Mockito'
     */
            public void comprarAdamon (Jogador jogador, Adamon adamon){
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

            public void venderAdamon (Jogador comprador, Adamon adamon){

            }

            public void atualizarJogador (Jogador jogador, Long idJogador){
                encontrarJogadorPorId(idJogador);
                jogador.setId(idJogador);
                jogadorRepository.save(jogador);
            }

            public Jogador encontrarJogadorPorId (Long idJogador){
                Optional<Jogador> optionalJogador = jogadorRepository.findById(idJogador);
                return optionalJogador
                        .orElseThrow(() -> new RuntimeException("Não encontrado jogador com ID: " + idJogador));
            }

            public Jogador salvarJogador (SalvarJogadorDTO dto){
                return jogadorRepository.save(JogadorDtoConverter.converterDto(dto));
            }


        }

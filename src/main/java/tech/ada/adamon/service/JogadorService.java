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
        1 - Implementar preços na classe 'Adamon'
        2 - Implementar método de compra do 'Adamon'
        3 - Um jogador só pode ter no máximo 6 adamons em sua equipe
        4 - Escrever testes para este método
        5 - Pesquisar como testar um método void com 'Mockito'
     */
    public void comprarAdamon(Jogador jogador, Adamon adamon) {
        List<Adamon> equipeAdamonJogador = jogador.getAdamons();
        BigDecimal saldoAtual = jogador.getSaldo();
        BigDecimal precoAdamon = adamon.getPreco();

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

package tech.ada.adamon.dto.converter;

import tech.ada.adamon.dto.SalvarJogadorDTO;
import tech.ada.adamon.model.Jogador;

public class JogadorDtoConverter {

    public static Jogador converterDto(SalvarJogadorDTO dto) {
        Jogador jogador = new Jogador();
        jogador.setNickname(dto.getNickname());
        jogador.setPassword(dto.getPassword());
        return jogador;
    }
}

package tech.ada.adamon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.ada.adamon.dto.SalvarJogadorDTO;
import tech.ada.adamon.model.Adamon;
import tech.ada.adamon.model.Jogador;
import tech.ada.adamon.service.AdamonService;
import tech.ada.adamon.service.JogadorService;

@RestController
@RequestMapping("/jogador")
public class JogadorController {

    @Autowired
    private JogadorService jogadorService;

    @Autowired
    private AdamonService adamonService;

    //GET, POST, PUT, DELETE
    @PutMapping("/comprar-adamon")
    public void comprarAdamon(@RequestParam("idAdamon") Long idAdamon, @RequestParam("idJogador") Long idJogador) {
        Jogador jogador = jogadorService.encontrarJogadorPorId(idJogador);
        Adamon adamon = adamonService.encontrarAdamonPorId(idAdamon);
        jogadorService.comprarAdamon(jogador, adamon);
    }

    @PostMapping
    public Jogador criarNovoJogador(@RequestBody SalvarJogadorDTO dto) {
        return jogadorService.salvarJogador(dto);
    }
}

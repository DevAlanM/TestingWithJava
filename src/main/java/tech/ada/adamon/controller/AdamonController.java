package tech.ada.adamon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.ada.adamon.model.Adamon;
import tech.ada.adamon.service.AdamonService;

import java.util.List;

@RestController
@RequestMapping("/adamon")
public class AdamonController {

    @Autowired
    private AdamonService adamonService;

    @GetMapping
    public List<Adamon> recuperarTodosAdamons() {
        return adamonService.recuperarTodosAdamons();
    }

    @PostMapping
    public Adamon criarNovoAdamon(@RequestBody Adamon adamon) {
        return adamonService.criarNovoAdamon(adamon);
    }

}

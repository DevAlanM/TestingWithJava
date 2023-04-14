package tech.ada.adamon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.ada.adamon.model.Adamon;
import tech.ada.adamon.service.AdamonService;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/adamon")
public class AdamonController {

    @Autowired
    private AdamonService adamonService;

    @GetMapping
    public ResponseEntity<List<Adamon>> recuperarTodosAdamons() {
        return new ResponseEntity<>(adamonService.recuperarTodosAdamons(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Adamon> criarNovoAdamon(@RequestBody Adamon adamon) {
        return new ResponseEntity(adamonService.criarNovoAdamon(adamon), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Adamon> encontraAdamonPorId(@PathVariable("id") Long id) {
        return new ResponseEntity<>(adamonService.encontrarAdamonPorId(id), HttpStatus.OK);
    }

}
package tech.ada.adamon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.ada.adamon.model.Adamon;
import tech.ada.adamon.repository.AdamonRepository;

import java.util.List;

@Service
public class AdamonService {

    @Autowired
    private AdamonRepository adamonRepository;

    public List<Adamon> recuperarTodosAdamons() {
        return adamonRepository.findAll();
    }

    public Adamon criarNovoAdamon(Adamon adamon) {
       return adamonRepository.save(adamon);
    }

}

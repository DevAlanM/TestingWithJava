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
import tech.ada.adamon.repository.AdamonRepository;
import tech.ada.adamon.util.TestUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AdamonServiceTest {

    @InjectMocks
    AdamonService adamonService;

    @Mock
    AdamonRepository repository;

    @BeforeEach
    public void setUp() {
    }

    @Test
    void deveSucessoAoBuscarAdamons() {
        when(repository.findAll()).thenReturn(TestUtils.obterAdamons());
        //execução
        List<Adamon> adamons = adamonService.recuperarTodosAdamons();
        //verificação
        Assertions.assertFalse(adamons.isEmpty());
    }

    @Test
    void deveSucessoAoBuscarAdamonsListaVazia() {
        when(repository.findAll()).thenReturn(new ArrayList<>());
        //execução
        List<Adamon> adamons = adamonService.recuperarTodosAdamons();
        //verificação
        assertTrue(adamons.isEmpty());
    }

    @Test
    void deveSucessoAoSalvarNovoAdamon() {
        //cenário
        Adamon adamonASerSalvo = new Adamon();
        adamonASerSalvo.setNome("Alexamon");

        Adamon adamonSalvo = new Adamon();
        adamonSalvo.setId(1l);

        when(repository.save(Mockito.any(Adamon.class))).thenReturn(adamonSalvo);

        Adamon adamon = adamonService.criarNovoAdamon(adamonASerSalvo);

        Assertions.assertNotNull(adamon);
        Assertions.assertEquals(adamonSalvo.getId(), adamon.getId());
    }
}

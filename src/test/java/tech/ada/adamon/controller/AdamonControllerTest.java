package tech.ada.adamon.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import tech.ada.adamon.model.Adamon;
import tech.ada.adamon.service.AdamonService;
import tech.ada.adamon.util.TestUtils;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class AdamonControllerTest {

    @InjectMocks
    AdamonController adamonController;

    MockMvc mockMvc;

    @Mock
    AdamonService adamonService;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(adamonController).build();
    }

    @Test
    void deveBuscarAdamons() throws Exception {
        Adamon adamon = TestUtils.obterAdamon();
        Mockito.when(adamonService.recuperarTodosAdamons()).thenReturn(Collections.singletonList(adamon));

        mockMvc.perform(get("/adamon")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void deveCriarAdamon() throws Exception {
        Adamon adamon = TestUtils.obterAdamon();
        String adamonAsString = jsonAsString(adamon);

        mockMvc.perform(post("/adamon")
                .contentType(MediaType.APPLICATION_JSON)
                .content(adamonAsString).characterEncoding("utf-8"))
                .andDo(print())
                .andExpect(status().isCreated());

        Mockito.verify(adamonService).criarNovoAdamon(Mockito.any(Adamon.class));
    }

    private String jsonAsString(Object obj) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException("Não foi possível converter o objeto");
        }
    }

    private Object objectToJson(String json)  {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(json, Adamon.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Não foi possível converter");
        }
    }

    @Test
    public void deveConverterParaString() {
        final String adamonAsString = "{\n" +
                "    \"id\": null,\n" +
                "    \"nome\": \"Adachu\",\n" +
                "    \"vida\": 80,\n" +
                "    \"ataque\": 50,\n" +
                "    \"defesa\": 30,\n" +
                "    \"inteligencia\": 40,\n" +
                "    \"poder\": 20,\n" +
                "    \"velocidade\": null,\n" +
                "    \"urlFoto\": null\n" +
                "}";

        Adamon adamon = (Adamon) objectToJson(adamonAsString);

        Assertions.assertEquals("Adachu", adamon.getNome());
    }





}
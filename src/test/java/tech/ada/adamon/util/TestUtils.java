package tech.ada.adamon.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import tech.ada.adamon.model.Adamon;
import tech.ada.adamon.model.Jogador;

import java.util.Arrays;
import java.util.List;

public class TestUtils {

    private TestUtils() {}
    public static List<Adamon> obterAdamons() {
        Adamon adamon = new Adamon();
        Adamon adamon1 = new Adamon();
        Adamon adamon2 = new Adamon();
        Adamon adamon3 = new Adamon();
        Adamon adamon4 = new Adamon();
        Adamon adamon5 = new Adamon();
        return Arrays.asList(adamon, adamon1, adamon2, adamon3, adamon4, adamon5);
    }

    public static List<Adamon> obterAdamonsFracos() {
        Adamon adamon = new Adamon();

        adamon.setDefesa(5);
        adamon.setAtaque(0);
        adamon.setVelocidade(0);
        adamon.setInteligencia(0);
        adamon.setPoder(20);
        adamon.setVida(50);
        adamon.setNome("Keldson");
        adamon.setUrlFoto("www.foto.com.br/Keldson");

        Adamon adamon1 = new Adamon();

        adamon1.setDefesa(10);
        adamon1.setAtaque(0);
        adamon1.setVelocidade(30);
        adamon1.setInteligencia(0);
        adamon1.setPoder(20);
        adamon1.setVida(30);
        adamon1.setNome("Wescley");
        adamon1.setUrlFoto("www.foto.com.br/Wescley");

        Adamon adamon2 = new Adamon();

        adamon2.setDefesa(10);
        adamon2.setAtaque(0);
        adamon2.setVelocidade(30);
        adamon2.setInteligencia(0);
        adamon2.setPoder(20);
        adamon2.setVida(30);
        adamon2.setNome("Ternisio");
        adamon2.setUrlFoto("www.foto.com.br/Ternisio");

        Adamon adamon3 = new Adamon();

        adamon3.setDefesa(10);
        adamon3.setAtaque(0);
        adamon3.setVelocidade(30);
        adamon3.setInteligencia(0);
        adamon3.setPoder(20);
        adamon3.setVida(30);
        adamon3.setNome("Valterh");
        adamon3.setUrlFoto("www.foto.com.br/Valterh");

        Adamon adamon4 = new Adamon();

        adamon4.setDefesa(10);
        adamon4.setAtaque(0);
        adamon4.setVelocidade(30);
        adamon4.setInteligencia(0);
        adamon4.setPoder(20);
        adamon4.setVida(30);
        adamon4.setNome("Cleyton");
        adamon4.setUrlFoto("www.foto.com.br/Cleyton");

        Adamon adamon5 = new Adamon();

        adamon5.setDefesa(10);
        adamon5.setAtaque(0);
        adamon5.setVelocidade(30);
        adamon5.setInteligencia(0);
        adamon5.setPoder(20);
        adamon5.setVida(30);
        adamon5.setNome("EletricAda");
        adamon5.setUrlFoto("www.foto.com.br/EletricAda");

        return Arrays.asList(adamon, adamon1, adamon2, adamon3, adamon4, adamon5);
    }

    public static List<Adamon> obterAdamonsFortes() {
        Adamon adamon = new Adamon();

        adamon.setDefesa(50);
        adamon.setAtaque(100);
        adamon.setVelocidade(20);
        adamon.setInteligencia(30);
        adamon.setPoder(20);
        adamon.setVida(50);
        adamon.setNome("ChuAda");
        adamon.setUrlFoto("www.foto.com.br/ChuAda");

        Adamon adamon1 = new Adamon();

        adamon1.setDefesa(90);
        adamon1.setAtaque(70);
        adamon1.setVelocidade(60);
        adamon1.setInteligencia(0);
        adamon1.setPoder(35);
        adamon1.setVida(100);
        adamon1.setNome("PicAda");
        adamon1.setUrlFoto("www.foto.com.br/PicAda");

        Adamon adamon2 = new Adamon();

        adamon2.setDefesa(60);
        adamon2.setAtaque(60);
        adamon2.setVelocidade(60);
        adamon2.setInteligencia(30);
        adamon2.setPoder(10);
        adamon2.setVida(40);
        adamon2.setNome("RayquAda");
        adamon2.setUrlFoto("www.foto.com.br/RayquAda");

        Adamon adamon3 = new Adamon();

        adamon3.setDefesa(10);
        adamon3.setAtaque(100);
        adamon3.setVelocidade(20);
        adamon3.setInteligencia(40);
        adamon3.setPoder(60);
        adamon3.setVida(80);
        adamon3.setNome("KAdabra");
        adamon3.setUrlFoto("www.foto.com.br/KAdabra");

        Adamon adamon4 = new Adamon();

        adamon4.setDefesa(100);
        adamon4.setAtaque(50);
        adamon4.setVelocidade(20);
        adamon4.setInteligencia(10);
        adamon4.setPoder(50);
        adamon4.setVida(60);
        adamon4.setNome("CharizAda");
        adamon4.setUrlFoto("www.foto.com.br/CharizAda");

        Adamon adamon5 = new Adamon();

        adamon5.setDefesa(10);
        adamon5.setAtaque(0);
        adamon5.setVelocidade(30);
        adamon5.setInteligencia(0);
        adamon5.setPoder(20);
        adamon5.setVida(30);
        adamon5.setNome("IvysAda");
        adamon5.setUrlFoto("www.foto.com.br/IvysAda");

        return Arrays.asList(adamon, adamon1, adamon2, adamon3, adamon4, adamon5);
    }
    public static Adamon obterAdamon() {
        Adamon adamon = new Adamon();
        adamon.setDefesa(30);
        adamon.setAtaque(50);
        adamon.setVelocidade(30);
        adamon.setInteligencia(40);
        adamon.setPoder(20);
        adamon.setVida(80);
        adamon.setNome("Adachu");
        adamon.setUrlFoto("www.foto.com.br/adachu");
        return adamon;
    }

    public static Jogador obterJogador() {
        Jogador jogador = new Jogador();
        jogador.setId(1L);
        jogador.setNickname("Rodolfo");
        jogador.setPassword("12345678");
        return jogador;
    }

    public static Jogador obterJogador2() {
        Jogador jogador = new Jogador();
        jogador.setId(2L);
        jogador.setNickname("Bruno");
        jogador.setPassword("87654321");
        return jogador;
    }

    public static String jsonAsString(Object obj) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            return mapper.writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException("Não foi possível converter o objeto");
        }
    }
}

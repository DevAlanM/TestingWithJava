package tech.ada.adamon.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "tb_adamon")
public class Adamon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private Integer vida;

    @Column(nullable = false)
    private Integer ataque;

    @Column(nullable = false)
    private Integer defesa;

    @Column(nullable = false)
    private Integer inteligencia;

    @Column(nullable = false)
    private Integer poder;

    @Column(nullable = false)
    private Integer velocidade;

    @Column(nullable = false)
    private String urlFoto;

    public Adamon() {
    }

    public Adamon(Long id, String nome, Integer vida, Integer ataque, Integer defesa, Integer inteligencia, Integer poder, Integer velocidade, String urlFoto) {
        this.id = id;
        this.nome = nome;
        this.vida = vida;
        this.ataque = ataque;
        this.defesa = defesa;
        this.inteligencia = inteligencia;
        this.poder = poder;
        this.velocidade = velocidade;
        this.urlFoto = urlFoto;
    }

    public Long getId() {
        return id;
    }
    public BigDecimal obterPreco() {
        return BigDecimal.valueOf((ataque + defesa + poder) / 3);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getVida() {
        return vida;
    }

    public void setVida(Integer vida) {
        this.vida = vida;
    }

    public Integer getAtaque() {
        return ataque;
    }

    public void setAtaque(Integer ataque) {
        this.ataque = ataque;
    }

    public Integer getDefesa() {
        return defesa;
    }

    public void setDefesa(Integer defesa) {
        this.defesa = defesa;
    }

    public Integer getInteligencia() {
        return inteligencia;
    }

    public void setInteligencia(Integer inteligencia) {
        this.inteligencia = inteligencia;
    }

    public Integer getPoder() {
        return poder;
    }

    public void setPoder(Integer poder) {
        this.poder = poder;
    }

    public Integer getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(Integer velocidade) {
        this.velocidade = velocidade;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public void receberDano(int dano) {
        int novaVida = this.vida - dano;
        if (novaVida < 0) {
            novaVida = 0;
        }
        this.vida = novaVida;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Adamon adamon = (Adamon) o;
        return Objects.equals(id, adamon.id) && Objects.equals(nome, adamon.nome) && Objects.equals(vida, adamon.vida) && Objects.equals(ataque, adamon.ataque) && Objects.equals(defesa, adamon.defesa) && Objects.equals(inteligencia, adamon.inteligencia) && Objects.equals(poder, adamon.poder) && Objects.equals(velocidade, adamon.velocidade) && Objects.equals(urlFoto, adamon.urlFoto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, vida, ataque, defesa, inteligencia, poder, velocidade, urlFoto);
    }
}

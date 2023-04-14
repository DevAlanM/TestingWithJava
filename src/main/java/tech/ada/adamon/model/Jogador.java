package tech.ada.adamon.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Table(name = "tb_jogador")
@Entity
public class Jogador {

    @Id
    @Column(name = "id_jogador")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String nickname;

    @Column
    private String password;

    @Column
    private BigDecimal saldo;

    @ManyToMany
    @JoinTable(name = "Jogador_Adamons",
            joinColumns = {@JoinColumn(name = "IdJogador")},
            inverseJoinColumns = {@JoinColumn(name = "IdAdamons")})
    private List<Adamon> adamons = new ArrayList<>();

    public Jogador() {
        saldo = new BigDecimal(100);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public List<Adamon> getAdamons() {
        return adamons;
    }

    public void adicionarAdamons(Adamon adamon) {
        adamons.add(adamon);
    }

    public void removerAdamons(Adamon adamon) {
        adamons.remove(adamon);
    }

    public void setAdamons(List<Adamon> adamons) {
        this.adamons = adamons;
    }
}

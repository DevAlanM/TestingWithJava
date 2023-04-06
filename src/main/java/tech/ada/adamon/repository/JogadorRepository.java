package tech.ada.adamon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.ada.adamon.model.Jogador;

@Repository
public interface JogadorRepository extends JpaRepository<Jogador, Long> {
}

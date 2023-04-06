package tech.ada.adamon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.ada.adamon.model.Adamon;

@Repository
public interface AdamonRepository extends JpaRepository<Adamon, Long> {
}

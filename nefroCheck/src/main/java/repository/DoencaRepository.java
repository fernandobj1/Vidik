package repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import domain.Doenca;
@Repository
public interface DoencaRepository extends JpaRepository<Doenca, UUID>{

}

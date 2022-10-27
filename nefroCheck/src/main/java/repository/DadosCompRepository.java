package repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import domain.DadosComp;
@Repository
public interface DadosCompRepository extends JpaRepository<DadosComp, UUID>{

}

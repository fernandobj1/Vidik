package repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import domain.Cuidados;
@Repository
public interface CuidadosRepository extends JpaRepository<Cuidados, UUID>{

}

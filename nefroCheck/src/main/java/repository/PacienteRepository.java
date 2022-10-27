package repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import domain.Paciente;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, UUID>{

}

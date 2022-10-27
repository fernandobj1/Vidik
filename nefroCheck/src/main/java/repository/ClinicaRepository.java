package repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import domain.Clinica;

@Repository
public interface ClinicaRepository extends JpaRepository<Clinica, UUID>{

}

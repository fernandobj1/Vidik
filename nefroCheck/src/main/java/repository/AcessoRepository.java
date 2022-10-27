package repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import domain.Acesso;

@Repository
public interface AcessoRepository extends JpaRepository<Acesso, UUID>{

}

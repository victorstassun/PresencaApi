package br.com.senai.domain.repositories;

import br.com.senai.domain.entities.Chamada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ChamadaRepository extends JpaRepository<Chamada, Long> {

    @Query("SELECT f FROM Chamada f WHERE f.matricula_aluno = ?1")
    Optional<Chamada> findByAlunoMatricula(long matricula);

}

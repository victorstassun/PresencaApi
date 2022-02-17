package br.com.senai.domain.services;

import br.com.senai.domain.entities.Aluno;
import br.com.senai.domain.exceptions.ExceptionTratement;
import br.com.senai.domain.repositories.AlunoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class AlunoService {

    private AlunoRepository alunoRepository;

    public Aluno cadastrar(Aluno aluno) throws Exception {
        try {
            return alunoRepository.save(aluno);
        } catch (Exception ex) {
            throw new ExceptionTratement("Não foi possível cadastrar o aluno!");
        }
    }

    public Optional<Aluno> buscar(long matricula) throws Exception {
        try {
            return alunoRepository.findById(matricula);
        } catch (Exception ex) {
            throw new ExceptionTratement("Não foi possível buscar o aluno!");
        }
    }

    public Optional<Aluno> buscarPorNome(String nome) throws Exception {
        try {
            return alunoRepository.findByNome(nome);
        } catch (Exception ex) {
            throw new ExceptionTratement("Não foi possível buscar aluno!");
        }
    }

    public List<Aluno> listar() throws Exception {
        try {
            return alunoRepository.findAll();
        } catch (Exception ex) {
            throw new ExceptionTratement("Não foi possível listar os alunos!");
        }
    }

    public Aluno editar(long matricula, Aluno aluno) throws Exception {
        try {
            aluno.setMatricula(matricula);

            return alunoRepository.save(aluno);
        } catch (Exception ex) {
            throw new ExceptionTratement("Não foi possível editar o aluno!");
        }
    }

    public void deletar(long matricula) throws Exception {
        try {
            alunoRepository.deleteById(matricula);
        } catch (Exception ex) {
            throw new ExceptionTratement("Não foi possível remover o aluno!");
        }
    }

}
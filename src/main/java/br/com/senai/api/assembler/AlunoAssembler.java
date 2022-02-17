package br.com.senai.api.assembler;

import br.com.senai.api.model.input.AlunoInputDTO;
import br.com.senai.api.model.output.AlunoOutputDTO;
import br.com.senai.domain.entities.Aluno;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class AlunoAssembler {
    private ModelMapper modelMapper;

    public Aluno toEntity(AlunoInputDTO alunoInputDTO) {
        return modelMapper.map(alunoInputDTO, Aluno.class);
    }

    public AlunoOutputDTO toModel(Aluno aluno) {
        return modelMapper.map(aluno, AlunoOutputDTO.class);
    }

    public List<AlunoOutputDTO> toCollectionModel(List<Aluno> alunos) {
        return alunos.stream().map(this::toModel).collect(Collectors.toList());
    }
}

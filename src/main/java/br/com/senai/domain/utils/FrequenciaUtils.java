package br.com.senai.domain.utils;

import br.com.senai.api.model.input.FrequenciaInputDTO;
import br.com.senai.api.model.output.FrequenciaOutputDTO;
import br.com.senai.domain.entities.Frequencia;
import br.com.senai.domain.services.AlunoService;
import br.com.senai.domain.services.FrequenciaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class FrequenciaUtils {
    private FrequenciaService frequenciaService;
    private AlunoService alunoService;

    private Frequencia editar(
            FrequenciaInputDTO frequenciaInputDTO
    ) throws Exception {

        Frequencia novaFrequencia = frequenciaService.buscarPorAluno(
                alunoService.buscarPorNome(frequenciaInputDTO.getNome()).get().getMatricula()
        ).get();

        novaFrequencia.setStatus(frequenciaInputDTO.isStatus());

        return frequenciaService.editar(novaFrequencia.getId(), novaFrequencia);
    }

    public List<FrequenciaOutputDTO> chamada(
            List<FrequenciaInputDTO> frequenciaInputDTOS
    ) throws Exception {
        List<FrequenciaOutputDTO> frequenciaOutputDTOS = new ArrayList<>();

        for (FrequenciaInputDTO frequenciaInputDTO : frequenciaInputDTOS) {
            Frequencia frequencia = editar(frequenciaInputDTO);

            FrequenciaOutputDTO frequenciaOutputDTO = new FrequenciaOutputDTO();

            frequenciaOutputDTO.setNome(
                    alunoService.buscar(frequencia.getMatricula_aluno()).get().getNome()
            );

            frequenciaOutputDTO.setStatus(frequenciaInputDTO.isStatus());

            frequenciaOutputDTOS.add(frequenciaOutputDTO);
        }

        return frequenciaOutputDTOS;
    }
}
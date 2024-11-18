package powerup.v1.usecases;

import powerup.v1.dtos.request.PerguntaRequestDto;
import powerup.v1.dtos.response.PerguntaResponseDto;
import powerup.v1.entities.Pergunta;

import java.util.List;

public interface PerguntaService {
    PerguntaRequestDto create(PerguntaResponseDto pergunta);
    List<PerguntaRequestDto> getAll();
    PerguntaRequestDto getById(Integer id);
    PerguntaRequestDto update(Integer id, PerguntaResponseDto pergunta);
    void delete(Integer id);
}

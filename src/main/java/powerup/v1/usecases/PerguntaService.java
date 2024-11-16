package powerup.v1.usecases;

import powerup.v1.dtos.request.PerguntaRequestDto;
import powerup.v1.entities.Pergunta;

import java.util.List;

public interface PerguntaService {
    PerguntaRequestDto create(Pergunta pergunta);
    List<PerguntaRequestDto> getAll();
    PerguntaRequestDto getById(Integer id);
    PerguntaRequestDto update(Integer id, Pergunta pergunta);
    void delete(Integer id);
}

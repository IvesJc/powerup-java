package powerup.v1.usecases;

import powerup.v1.dtos.request.EmblemaDto;
import powerup.v1.dtos.request.PerguntaDto;
import powerup.v1.entities.Emblema;
import powerup.v1.entities.Pergunta;

import java.util.List;

public interface PerguntaService {
    PerguntaDto create(Pergunta pergunta);
    List<PerguntaDto> getAll();
    PerguntaDto getById(Integer id);
    PerguntaDto update(Integer id, Pergunta pergunta);
    void delete(Integer id);
}

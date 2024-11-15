package powerup.v1.usecases;

import powerup.v1.dtos.request.ArtigoDto;
import powerup.v1.dtos.request.PerguntaDto;
import powerup.v1.entities.Artigo;
import powerup.v1.entities.Pergunta;

import java.util.List;

public interface ArtigoService {
    ArtigoDto create(Artigo artigo);
    List<ArtigoDto> getAll();
    ArtigoDto getById(Integer id);
    ArtigoDto update(Integer id, Artigo artigo);
    void delete(Integer id);
}

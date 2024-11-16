package powerup.v1.usecases;

import powerup.v1.dtos.request.ArtigoRequestDto;
import powerup.v1.entities.Artigo;

import java.util.List;

public interface ArtigoService {
    ArtigoRequestDto create(Artigo artigo);
    List<ArtigoRequestDto> getAll();
    ArtigoRequestDto getById(Integer id);
    ArtigoRequestDto update(Integer id, Artigo artigo);
    void delete(Integer id);
}

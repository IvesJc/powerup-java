package powerup.v1.usecases;

import powerup.v1.dtos.request.ArtigoRequestDto;
import powerup.v1.dtos.response.ArtigoResponseDto;
import powerup.v1.entities.Artigo;

import java.util.List;

public interface ArtigoService {
    ArtigoRequestDto create(ArtigoResponseDto artigo);
    List<ArtigoRequestDto> getAll();
    ArtigoRequestDto getById(Integer id);
    ArtigoRequestDto update(Integer id, ArtigoResponseDto artigo);
    void delete(Integer id);
}

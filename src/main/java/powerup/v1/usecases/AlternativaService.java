package powerup.v1.usecases;

import powerup.v1.dtos.request.AlternativaDto;
import powerup.v1.dtos.request.ArtigoDto;
import powerup.v1.entities.Alternativa;
import powerup.v1.entities.Artigo;

import java.util.List;

public interface AlternativaService {
    AlternativaDto create(Alternativa alternativa);
    List<AlternativaDto> getAll();
    AlternativaDto getById(Integer id);
    AlternativaDto update(Integer id, Alternativa alternativa);
    void delete(Integer id);
}

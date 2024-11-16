package powerup.v1.usecases;

import powerup.v1.dtos.request.AlternativaRequestDto;
import powerup.v1.entities.Alternativa;

import java.util.List;

public interface AlternativaService {
    AlternativaRequestDto create(Alternativa alternativa);
    List<AlternativaRequestDto> getAll();
    AlternativaRequestDto getById(Integer id);
    AlternativaRequestDto update(Integer id, Alternativa alternativa);
    void delete(Integer id);
}

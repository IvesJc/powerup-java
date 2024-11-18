package powerup.v1.usecases;

import powerup.v1.dtos.request.AlternativaRequestDto;
import powerup.v1.dtos.response.AlternativaResponseDto;
import powerup.v1.entities.Alternativa;

import java.util.List;

public interface AlternativaService {
    AlternativaRequestDto create(AlternativaResponseDto alternativaResponseDto);
    List<AlternativaRequestDto> getAll();
    AlternativaRequestDto getById(Integer id);
    AlternativaRequestDto update(Integer id, AlternativaResponseDto alternativaResponseDto);
    void delete(Integer id);
}

package powerup.v1.usecases;

import powerup.v1.dtos.request.DesafioRequestDto;
import powerup.v1.dtos.response.DesafioResponseDto;
import powerup.v1.entities.Desafio;

import java.util.List;

public interface DesafioService {
    DesafioRequestDto create(DesafioResponseDto desafio);
    List<DesafioRequestDto> getAll();
    DesafioRequestDto getById(Integer id);
    DesafioRequestDto update(Integer id, DesafioResponseDto desafio);
    void delete(Integer id);
}

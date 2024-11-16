package powerup.v1.usecases;

import powerup.v1.dtos.request.DesafioRequestDto;
import powerup.v1.entities.Desafio;

import java.util.List;

public interface DesafioService {
    DesafioRequestDto create(Desafio desafio);
    List<DesafioRequestDto> getAll();
    DesafioRequestDto getById(Integer id);
    DesafioRequestDto update(Integer id, Desafio desafio);
    void delete(Integer id);
}

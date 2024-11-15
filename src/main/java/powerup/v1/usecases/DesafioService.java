package powerup.v1.usecases;

import powerup.v1.dtos.request.AlternativaDto;
import powerup.v1.dtos.request.DesafioDto;
import powerup.v1.entities.Alternativa;
import powerup.v1.entities.Desafio;

import java.util.List;

public interface DesafioService {
    DesafioDto create(Desafio desafio);
    List<DesafioDto> getAll();
    DesafioDto getById(Integer id);
    DesafioDto update(Integer id, Desafio desafio);
    void delete(Integer id);
}

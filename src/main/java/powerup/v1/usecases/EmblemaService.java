package powerup.v1.usecases;

import powerup.v1.dtos.request.EmblemaRequestDto;
import powerup.v1.dtos.response.EmblemaResponseDto;
import powerup.v1.entities.Emblema;

import java.util.List;

public interface EmblemaService {
    EmblemaRequestDto create(EmblemaResponseDto emblema);
    List<EmblemaRequestDto> getAll();
    EmblemaRequestDto getById(Integer id);
    EmblemaRequestDto update(Integer id, EmblemaResponseDto emblema);
    void delete(Integer id);
}

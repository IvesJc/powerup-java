package powerup.v1.usecases;

import powerup.v1.dtos.request.RecompensaRequestDto;
import powerup.v1.dtos.response.RecompensaResponseDto;
import powerup.v1.entities.Recompensa;

import java.util.List;

public interface RecompensaService {
    RecompensaRequestDto create(RecompensaResponseDto recompensa);
    List<RecompensaRequestDto> getAll();
    RecompensaRequestDto getById(Integer id);
    RecompensaRequestDto update(Integer id, RecompensaResponseDto recompensa);
    void delete(Integer id);
}

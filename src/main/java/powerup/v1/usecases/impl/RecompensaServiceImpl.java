package powerup.v1.usecases.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import powerup.v1.dtos.request.RecompensaDto;
import powerup.v1.entities.Recompensa;
import powerup.v1.repositories.RecompensaRepository;
import powerup.v1.usecases.RecompensaService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RecompensaServiceImpl implements RecompensaService {
    private final RecompensaRepository recompensaRepository;

    @Override
    public RecompensaDto create(Recompensa recompensa) {
        Recompensa savedEntity = recompensaRepository.save(recompensa);
        return mapToDTO(savedEntity);
    }

    @Override
    public List<RecompensaDto> getAll() {
        return recompensaRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public RecompensaDto getById(Integer id) {
        return recompensaRepository.findById(id)
                .map(this::mapToDTO)
                .orElseThrow(() -> new EntityNotFoundException("Recompensa not found with id: " + id));
    }

    @Override
    public RecompensaDto update(Integer id, Recompensa recompensa) {
        if (!recompensaRepository.existsById(id)) {
            throw new EntityNotFoundException("Recompensa not found with id: " + id);
        }
        recompensa.setId(id);
        Recompensa updatedEntity = recompensaRepository.save(recompensa);
        return mapToDTO(updatedEntity);
    }

    @Override
    public void delete(Integer id) {
        if (!recompensaRepository.existsById(id)) {
            throw new EntityNotFoundException("Recompensa not found with id: " + id);
        }
        recompensaRepository.deleteById(id);
    }

    private RecompensaDto mapToDTO(Recompensa recompensa) {
        return RecompensaDto.builder()
                .id(recompensa.getId())
                .pontosUtilizados(recompensa.getPontosUtilizados())
                .usuario(recompensa.getUsuario().getId())
                .recompensaConfig(recompensa.getRecompensaConfig().getId())
                .build();
    }
}


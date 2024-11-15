package powerup.v1.usecases.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import powerup.v1.dtos.request.RecompensaTipoDto;
import powerup.v1.entities.RecompensaTipo;
import powerup.v1.repositories.RecompensaTipoRepository;
import powerup.v1.usecases.RecompensaTipoService;
import powerup.v1.usecases.exception.IdNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RecompensaTipoServiceImpl implements RecompensaTipoService {
    private final RecompensaTipoRepository recompensaTipoRepository;


    @Override
    public RecompensaTipoDto create(RecompensaTipo recompensaTipo) {
        RecompensaTipo savedEntity = recompensaTipoRepository.save(recompensaTipo);
        return mapToDTO(savedEntity);
    }

    @Override
    public List<RecompensaTipoDto> getAll() {
        return recompensaTipoRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public RecompensaTipoDto getById(Integer id) {
        return recompensaTipoRepository.findById(id)
                .map(this::mapToDTO)
                .orElseThrow(() -> new IdNotFoundException("RecompensaTipo not found with id: " + id));
    }

    @Override
    public RecompensaTipoDto update(Integer id, RecompensaTipo recompensaTipo) {
        if (!recompensaTipoRepository.existsById(id)) {
            throw new IdNotFoundException("RecompensaTipo not found with id: " + id);
        }
        recompensaTipo.setId(id);
        RecompensaTipo updatedEntity = recompensaTipoRepository.save(recompensaTipo);
        return mapToDTO(updatedEntity);
    }

    @Override
    public void delete(Integer id) {
        if (!recompensaTipoRepository.existsById(id)) {
            throw new IdNotFoundException("RecompensaTipo not found with id: " + id);
        }
        recompensaTipoRepository.deleteById(id);
    }

    private RecompensaTipoDto mapToDTO(RecompensaTipo recompensaTipo) {
        return RecompensaTipoDto.builder()
                .id(recompensaTipo.getId())
                .nome(recompensaTipo.getNome())
                .descricao(recompensaTipo.getDescricao())
                .build();
    }
}

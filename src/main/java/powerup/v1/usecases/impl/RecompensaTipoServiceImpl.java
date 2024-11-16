package powerup.v1.usecases.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import powerup.v1.dtos.request.RecompensaTipoRequestDto;
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
    public RecompensaTipoRequestDto create(RecompensaTipo recompensaTipo) {
        RecompensaTipo savedEntity = recompensaTipoRepository.save(recompensaTipo);
        return mapToDTO(savedEntity);
    }

    @Override
    public List<RecompensaTipoRequestDto> getAll() {
        return recompensaTipoRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public RecompensaTipoRequestDto getById(Integer id) {
        return recompensaTipoRepository.findById(id)
                .map(this::mapToDTO)
                .orElseThrow(() -> new IdNotFoundException("RecompensaTipo not found with id: " + id));
    }

    @Override
    public RecompensaTipoRequestDto update(Integer id, RecompensaTipo recompensaTipo) {
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

    private RecompensaTipoRequestDto mapToDTO(RecompensaTipo recompensaTipo) {
        return RecompensaTipoRequestDto.builder()
                .id(recompensaTipo.getId())
                .nome(recompensaTipo.getNome())
                .descricao(recompensaTipo.getDescricao())
                .build();
    }
}

package powerup.v1.usecases.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import powerup.v1.dtos.request.EmblemaDto;
import powerup.v1.entities.Emblema;
import powerup.v1.repositories.EmblemaRepository;
import powerup.v1.usecases.EmblemaService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmblemaServiceImpl implements EmblemaService {
    private final EmblemaRepository emblemaRepository;

    @Override
    public EmblemaDto create(Emblema emblema) {
        Emblema savedEntity = emblemaRepository.save(emblema);
        return mapToDTO(savedEntity);
    }

    @Override
    public List<EmblemaDto> getAll() {
        return emblemaRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public EmblemaDto getById(Integer id) {
        return emblemaRepository.findById(id)
                .map(this::mapToDTO)
                .orElseThrow(() -> new EntityNotFoundException("Emblema not found with id: " + id));
    }

    @Override
    public EmblemaDto update(Integer id, Emblema emblema) {
        if (!emblemaRepository.existsById(id)) {
            throw new EntityNotFoundException("Emblema not found with id: " + id);
        }
        emblema.setId(id);
        Emblema updatedEntity = emblemaRepository.save(emblema);
        return mapToDTO(updatedEntity);
    }

    @Override
    public void delete(Integer id) {
        if (!emblemaRepository.existsById(id)) {
            throw new EntityNotFoundException("Emblema not found with id: " + id);
        }
        emblemaRepository.deleteById(id);
    }

    private EmblemaDto mapToDTO(Emblema emblema) {
        return EmblemaDto.builder()
                .id(emblema.getId())
                .usuario(emblema.getUsuarioId().getId())
                .emblemaConfig(emblema.getId())
                .build();
    }
}


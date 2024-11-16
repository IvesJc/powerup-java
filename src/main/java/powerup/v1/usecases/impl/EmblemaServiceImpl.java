package powerup.v1.usecases.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import powerup.v1.dtos.request.EmblemaRequestDto;
import powerup.v1.entities.Emblema;
import powerup.v1.repositories.EmblemaRepository;
import powerup.v1.usecases.EmblemaService;
import powerup.v1.usecases.exception.IdNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmblemaServiceImpl implements EmblemaService {
    private final EmblemaRepository emblemaRepository;

    @Override
    public EmblemaRequestDto create(Emblema emblema) {
        Emblema savedEntity = emblemaRepository.save(emblema);
        return mapToDTO(savedEntity);
    }

    @Override
    public List<EmblemaRequestDto> getAll() {
        return emblemaRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public EmblemaRequestDto getById(Integer id) {
        return emblemaRepository.findById(id)
                .map(this::mapToDTO)
                .orElseThrow(() -> new IdNotFoundException("Emblema not found with id: " + id));
    }

    @Override
    public EmblemaRequestDto update(Integer id, Emblema emblema) {
        if (!emblemaRepository.existsById(id)) {
            throw new IdNotFoundException("Emblema not found with id: " + id);
        }
        emblema.setId(id);
        Emblema updatedEntity = emblemaRepository.save(emblema);
        return mapToDTO(updatedEntity);
    }

    @Override
    public void delete(Integer id) {
        if (!emblemaRepository.existsById(id)) {
            throw new IdNotFoundException("Emblema not found with id: " + id);
        }
        emblemaRepository.deleteById(id);
    }

    private EmblemaRequestDto mapToDTO(Emblema emblema) {
        return EmblemaRequestDto.builder()
                .id(emblema.getId())
                .usuario(emblema.getUsuarioId().getId())
                .emblemaConfig(emblema.getId())
                .build();
    }
}


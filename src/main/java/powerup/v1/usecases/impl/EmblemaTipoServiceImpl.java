package powerup.v1.usecases.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import powerup.v1.dtos.request.EmblemaTipoRequestDto;
import powerup.v1.entities.EmblemaTipo;
import powerup.v1.repositories.EmblemaTipoRepository;
import powerup.v1.usecases.EmblemaTipoService;
import powerup.v1.usecases.exception.IdNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmblemaTipoServiceImpl implements EmblemaTipoService {
    private final EmblemaTipoRepository emblemaTipoRepository;

    @Override
    public EmblemaTipoRequestDto create(EmblemaTipo emblemaTipo) {
        EmblemaTipo savedEntity = emblemaTipoRepository.save(emblemaTipo);
        return mapToDTO(savedEntity);
    }

    @Override
    public List<EmblemaTipoRequestDto> getAll() {
        return emblemaTipoRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public EmblemaTipoRequestDto getById(Integer id) {
        return emblemaTipoRepository.findById(id)
                .map(this::mapToDTO)
                .orElseThrow(() -> new IdNotFoundException("EmblemaTipo not found with id: " + id));
    }

    @Override
    public EmblemaTipoRequestDto update(Integer id, EmblemaTipo emblemaTipo) {
        if (!emblemaTipoRepository.existsById(id)) {
            throw new IdNotFoundException("EmblemaTipo not found with id: " + id);
        }
        emblemaTipo.setId(id);
        EmblemaTipo updatedEntity = emblemaTipoRepository.save(emblemaTipo);
        return mapToDTO(updatedEntity);
    }

    @Override
    public void delete(Integer id) {
        if (!emblemaTipoRepository.existsById(id)) {
            throw new IdNotFoundException("EmblemaTipo not found with id: " + id);
        }
        emblemaTipoRepository.deleteById(id);
    }

    private EmblemaTipoRequestDto mapToDTO(EmblemaTipo emblemaTipo) {
        return EmblemaTipoRequestDto.builder()
                .id(emblemaTipo.getId())
                .nome(emblemaTipo.getNome())
                .imageLink(emblemaTipo.getImageLinkId().getId())
                .build();
    }
}

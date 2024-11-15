package powerup.v1.usecases.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import powerup.v1.dtos.request.LinkDto;
import powerup.v1.dtos.request.ModuloEducativoDto;
import powerup.v1.entities.Link;
import powerup.v1.entities.ModuloEducativo;
import powerup.v1.repositories.LinkRepository;
import powerup.v1.repositories.ModuloEducativoRepository;
import powerup.v1.usecases.LinkService;
import powerup.v1.usecases.ModuloEducativoService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ModuloEducativoServiceImpl implements ModuloEducativoService {
    private final ModuloEducativoRepository moduloEducativoRepository;


    @Override
    public ModuloEducativoDto create(ModuloEducativo moduloEducativo) {
        ModuloEducativo savedEntity = moduloEducativoRepository.save(moduloEducativo);
        return mapToDTO(savedEntity);
    }

    @Override
    public List<ModuloEducativoDto> getAll() {
        return moduloEducativoRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ModuloEducativoDto getById(Integer id) {
        return moduloEducativoRepository.findById(id)
                .map(this::mapToDTO)
                .orElseThrow(() -> new EntityNotFoundException("ModuloEducativo not found with id: " + id));
    }

    @Override
    public ModuloEducativoDto update(Integer id, ModuloEducativo moduloEducativo) {
        if (!moduloEducativoRepository.existsById(id)) {
            throw new EntityNotFoundException("ModuloEducativo not found with id: " + id);
        }
        moduloEducativo.setId(id);
        ModuloEducativo updatedEntity = moduloEducativoRepository.save(moduloEducativo);
        return mapToDTO(updatedEntity);
    }

    @Override
    public void delete(Integer id) {
        if (!moduloEducativoRepository.existsById(id)) {
            throw new EntityNotFoundException("ModuloEducativo not found with id: " + id);
        }
        moduloEducativoRepository.deleteById(id);
    }

    private ModuloEducativoDto mapToDTO(ModuloEducativo moduloEducativo) {
        return ModuloEducativoDto.builder()
                .id(moduloEducativo.getId())
                .titulo(moduloEducativo.getTitulo())
                .subtitulo(moduloEducativo.getSubtitulo())
                .descricao(moduloEducativo.getDescricao())
                .nivel(moduloEducativo.getNivel())
                .thumbLink(moduloEducativo.getThumbLinkId().getId())
                .build();
    }
}

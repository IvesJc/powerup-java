package powerup.v1.usecases.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import powerup.v1.dtos.request.ModuloEducativoRequestDto;
import powerup.v1.entities.ModuloEducativo;
import powerup.v1.repositories.ModuloEducativoRepository;
import powerup.v1.usecases.ModuloEducativoService;
import powerup.v1.usecases.exception.IdNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ModuloEducativoServiceImpl implements ModuloEducativoService {
    private final ModuloEducativoRepository moduloEducativoRepository;


    @Override
    public ModuloEducativoRequestDto create(ModuloEducativo moduloEducativo) {
        ModuloEducativo savedEntity = moduloEducativoRepository.save(moduloEducativo);
        return mapToDTO(savedEntity);
    }

    @Override
    public List<ModuloEducativoRequestDto> getAll() {
        return moduloEducativoRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ModuloEducativoRequestDto getById(Integer id) {
        return moduloEducativoRepository.findById(id)
                .map(this::mapToDTO)
                .orElseThrow(() -> new IdNotFoundException("ModuloEducativo not found with id: " + id));
    }

    @Override
    public ModuloEducativoRequestDto update(Integer id, ModuloEducativo moduloEducativo) {
        if (!moduloEducativoRepository.existsById(id)) {
            throw new IdNotFoundException("ModuloEducativo not found with id: " + id);
        }
        moduloEducativo.setId(id);
        ModuloEducativo updatedEntity = moduloEducativoRepository.save(moduloEducativo);
        return mapToDTO(updatedEntity);
    }

    @Override
    public void delete(Integer id) {
        if (!moduloEducativoRepository.existsById(id)) {
            throw new IdNotFoundException("ModuloEducativo not found with id: " + id);
        }
        moduloEducativoRepository.deleteById(id);
    }

    private ModuloEducativoRequestDto mapToDTO(ModuloEducativo moduloEducativo) {
        return ModuloEducativoRequestDto.builder()
                .id(moduloEducativo.getId())
                .titulo(moduloEducativo.getTitulo())
                .subtitulo(moduloEducativo.getSubtitulo())
                .descricao(moduloEducativo.getDescricao())
                .nivel(moduloEducativo.getNivel())
                .thumbLink(moduloEducativo.getThumbLinkId().getId())
                .build();
    }
}

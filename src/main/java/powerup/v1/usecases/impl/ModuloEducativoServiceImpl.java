package powerup.v1.usecases.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import powerup.v1.dtos.request.ModuloEducativoRequestDto;
import powerup.v1.dtos.response.ModuloEducativoResponseDto;
import powerup.v1.entities.Link;
import powerup.v1.entities.ModuloEducativo;
import powerup.v1.repositories.LinkRepository;
import powerup.v1.repositories.ModuloEducativoRepository;
import powerup.v1.usecases.ModuloEducativoService;
import powerup.v1.usecases.exception.IdNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ModuloEducativoServiceImpl implements ModuloEducativoService {
    private final ModuloEducativoRepository moduloEducativoRepository;
    private final LinkRepository linkRepository;


    @Override
    public ModuloEducativoRequestDto create(ModuloEducativoResponseDto moduloEducativo) {

        Link link = linkRepository.findById(moduloEducativo.thumbLink()).orElseThrow(() -> new IdNotFoundException("Link not found"));

        ModuloEducativo savedEntity = ModuloEducativo.builder()
                .titulo(moduloEducativo.titulo())
                .subtitulo(moduloEducativo.subtitulo())
                .descricao(moduloEducativo.descricao())
                .nivel(moduloEducativo.nivel())
                .thumbLinkId(link).build();

        moduloEducativoRepository.save(savedEntity);
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
    public ModuloEducativoRequestDto update(Integer id, ModuloEducativoResponseDto moduloEducativo) {
        Link link = linkRepository.findById(moduloEducativo.thumbLink()).orElseThrow(() -> new IdNotFoundException("Link not found"));

        ModuloEducativo saveModuloEducativo = moduloEducativoRepository.findById(id).orElseThrow(() -> new IdNotFoundException("ModuloEducativo not found"));

        saveModuloEducativo.setTitulo(moduloEducativo.titulo());
        saveModuloEducativo.setSubtitulo(moduloEducativo.subtitulo());
        saveModuloEducativo.setDescricao(moduloEducativo.descricao());
        saveModuloEducativo.setNivel(moduloEducativo.nivel());
        saveModuloEducativo.setThumbLinkId(link);

        moduloEducativoRepository.save(saveModuloEducativo);
        return mapToDTO(saveModuloEducativo);
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

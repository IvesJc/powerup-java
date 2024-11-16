package powerup.v1.usecases.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import powerup.v1.dtos.request.ArtigoRequestDto;
import powerup.v1.entities.Artigo;
import powerup.v1.repositories.ArtigoRepository;
import powerup.v1.usecases.ArtigoService;
import powerup.v1.usecases.exception.IdNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ArtigoServiceImpl implements ArtigoService {
    private final ArtigoRepository artigoRepository;

    @Override
    public ArtigoRequestDto create(Artigo artigo) {
        Artigo savedEntity = artigoRepository.save(artigo);
        return mapToDTO(savedEntity);
    }

    @Override
    public List<ArtigoRequestDto> getAll() {
        return artigoRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ArtigoRequestDto getById(Integer id) {
        return artigoRepository.findById(id)
                .map(this::mapToDTO)
                .orElseThrow(() -> new IdNotFoundException("Artigo not found with id: " + id));
    }

    @Override
    public ArtigoRequestDto update(Integer id, Artigo artigo) {
        if (!artigoRepository.existsById(id)) {
            throw new IdNotFoundException("Artigo not found with id: " + id);
        }
        artigo.setId(id);
        Artigo updatedEntity = artigoRepository.save(artigo);
        return mapToDTO(updatedEntity);
    }

    @Override
    public void delete(Integer id) {
        if (!artigoRepository.existsById(id)) {
            throw new IdNotFoundException("Artigo not found with id: " + id);
        }
        artigoRepository.deleteById(id);
    }

    private ArtigoRequestDto mapToDTO(Artigo artigo) {
        return ArtigoRequestDto.builder()
                .id(artigo.getId())
                .titulo(artigo.getTitulo())
                .subtitulo(artigo.getSubtitulo())
                .conteudo(artigo.getConteudo())
                .thumbLink(artigo.getThumbLink().getId())
                .moduloEducativo(artigo.getModuloEducativoId().getId())
                .build();
    }
}


package powerup.v1.usecases.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import powerup.v1.dtos.request.ArtigoRequestDto;
import powerup.v1.dtos.response.ArtigoResponseDto;
import powerup.v1.entities.Artigo;
import powerup.v1.entities.Link;
import powerup.v1.entities.ModuloEducativo;
import powerup.v1.repositories.ArtigoRepository;
import powerup.v1.repositories.LinkRepository;
import powerup.v1.repositories.ModuloEducativoRepository;
import powerup.v1.usecases.ArtigoService;
import powerup.v1.usecases.exception.IdNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ArtigoServiceImpl implements ArtigoService {
    private final ArtigoRepository artigoRepository;
    private final LinkRepository linkRepository;
    private final ModuloEducativoRepository moduloEducativoRepository;

    @Override
    public ArtigoRequestDto create(ArtigoResponseDto artigo) {

        Link link = linkRepository.findById(artigo.thumbLink()).orElseThrow(() -> new IdNotFoundException("Link not found with id: " + artigo.thumbLink()));

        ModuloEducativo moduloEducativo = moduloEducativoRepository.findById(artigo.moduloEducativo()).orElseThrow(() -> new IdNotFoundException("Educativo not found with id: " + artigo.moduloEducativo()));

        Artigo newArtigo = Artigo.builder()
                .titulo(artigo.titulo())
                .subtitulo(artigo.subtitulo())
                .conteudo(artigo.conteudo())
                .thumbLink(link)
                .moduloEducativoId(moduloEducativo).build();

        artigoRepository.save(newArtigo);
        return mapToDTO(newArtigo);
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
    public ArtigoRequestDto update(Integer id, ArtigoResponseDto artigo) {

        Artigo updatedArtigo = artigoRepository.findById(id).orElseThrow(() -> new IdNotFoundException("Artigo not found with id: " + id));

        Link link = linkRepository.findById(artigo.thumbLink()).orElseThrow(() -> new IdNotFoundException("Link not found with id: " + artigo.thumbLink()));

        ModuloEducativo moduloEducativo = moduloEducativoRepository.findById(artigo.moduloEducativo()).orElseThrow(() -> new IdNotFoundException("Educativo not found with id: " + artigo.moduloEducativo()));

        updatedArtigo.setTitulo(artigo.titulo());
        updatedArtigo.setSubtitulo(artigo.subtitulo());
        updatedArtigo.setConteudo(artigo.conteudo());
        updatedArtigo.setThumbLink(link);
        updatedArtigo.setModuloEducativoId(moduloEducativo);

        artigoRepository.save(updatedArtigo);
        return mapToDTO(updatedArtigo);
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


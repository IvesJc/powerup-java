package powerup.v1.usecases.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import powerup.v1.dtos.request.LinkDto;
import powerup.v1.entities.Link;
import powerup.v1.repositories.LinkRepository;
import powerup.v1.usecases.LinkService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LinkServiceImpl implements LinkService {
    private final LinkRepository linkRepository;


    @Override
    public LinkDto create(Link link) {
        Link savedEntity = linkRepository.save(link);
        return mapToDTO(savedEntity);
    }

    @Override
    public List<LinkDto> getAll() {
        return linkRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public LinkDto getById(Integer id) {
        return linkRepository.findById(id)
                .map(this::mapToDTO)
                .orElseThrow(() -> new EntityNotFoundException("Link not found with id: " + id));
    }

    @Override
    public LinkDto update(Integer id, Link link) {
        if (!linkRepository.existsById(id)) {
            throw new EntityNotFoundException("Link not found with id: " + id);
        }
        link.setId(id);
        Link updatedEntity = linkRepository.save(link);
        return mapToDTO(updatedEntity);
    }

    @Override
    public void delete(Integer id) {
        if (!linkRepository.existsById(id)) {
            throw new EntityNotFoundException("Link not found with id: " + id);
        }
        linkRepository.deleteById(id);
    }

    private LinkDto mapToDTO(Link link) {
        return LinkDto.builder()
                .id(link.getId())
                .url(link.getUrl())
                .descricao(link.getDescricao())
                .build();
    }
}

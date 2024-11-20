package powerup.v1.usecases.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import powerup.v1.dtos.request.LinkRequestDto;
import powerup.v1.dtos.response.LinkResponseDto;
import powerup.v1.entities.Link;
import powerup.v1.repositories.LinkRepository;
import powerup.v1.usecases.LinkService;
import powerup.v1.usecases.exception.IdNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LinkServiceImpl implements LinkService {
    private final LinkRepository linkRepository;


    @Override
    public LinkRequestDto create(LinkResponseDto link) {
        Link savedEntity = Link.builder()
                .url(link.url())
                .descricao(link.descricao()).build();
        return mapToDTO(savedEntity);
    }

    @Override
    public List<LinkRequestDto> getAll() {
        return linkRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public LinkRequestDto getById(Integer id) {
        return linkRepository.findById(id)
                .map(this::mapToDTO)
                .orElseThrow(() -> new IdNotFoundException("Link not found with id: " + id));
    }

    @Override
    public LinkRequestDto update(Integer id, LinkResponseDto link) {

        Link updateLink = linkRepository.findById(id).orElseThrow(() -> new IdNotFoundException("Link not found with id: " + id));

        updateLink.setUrl(link.url());
        updateLink.setDescricao(link.descricao());

        linkRepository.save(updateLink);
        return mapToDTO(updateLink);
    }

    @Override
    public void delete(Integer id) {
        if (!linkRepository.existsById(id)) {
            throw new IdNotFoundException("Link not found with id: " + id);
        }
        linkRepository.deleteById(id);
    }

    private LinkRequestDto mapToDTO(Link link) {
        return LinkRequestDto.builder()
                .id(link.getId())
                .url(link.getUrl())
                .descricao(link.getDescricao())
                .build();
    }
}

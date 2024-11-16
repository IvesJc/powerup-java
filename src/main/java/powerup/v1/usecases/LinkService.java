package powerup.v1.usecases;

import powerup.v1.dtos.request.LinkRequestDto;
import powerup.v1.entities.Link;

import java.util.List;

public interface LinkService {
    LinkRequestDto create(Link link);
    List<LinkRequestDto> getAll();
    LinkRequestDto getById(Integer id);
    LinkRequestDto update(Integer id, Link link);
    void delete(Integer id);
    
}

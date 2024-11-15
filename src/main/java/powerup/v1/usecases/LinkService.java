package powerup.v1.usecases;

import powerup.v1.dtos.request.LinkDto;
import powerup.v1.entities.Link;

import java.util.List;
import java.util.Optional;

public interface LinkService {
    LinkDto create(Link link);
    List<LinkDto> getAll();
    LinkDto getById(Integer id);
    LinkDto update(Integer id, Link link);
    void delete(Integer id);
    
}

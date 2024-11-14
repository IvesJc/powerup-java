package powerup.v1.usecases;

import powerup.v1.dtos.LinkDto;
import powerup.v1.dtos.MissaoConfigDto;
import powerup.v1.entities.Link;
import powerup.v1.entities.MissaoConfig;

import java.util.List;
import java.util.Optional;

public interface LinkService {
    LinkDto create(Link link);

    LinkDto update(Link link);

    Optional<LinkDto> getById(Long id);

    List<LinkDto> getAll();

    void delete(Long id);
}

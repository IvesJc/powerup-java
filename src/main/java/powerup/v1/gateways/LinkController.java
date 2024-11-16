package powerup.v1.gateways;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import powerup.v1.dtos.request.LinkRequestDto;
import powerup.v1.entities.Link;
import powerup.v1.usecases.LinkService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/powerup/link/")
@Tag(name = "Link", description = "Endpoints destinados para a classe Link")
public class LinkController {

    private final LinkService linkService;

    @PostMapping
    public ResponseEntity<LinkRequestDto> create(@RequestBody Link link) {
        LinkRequestDto createdLink = linkService.create(link);
        return new ResponseEntity<>(createdLink, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<LinkRequestDto>> getAll() {
        List<LinkRequestDto> linkList = linkService.getAll();
        return new ResponseEntity<>(linkList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LinkRequestDto> getById(@PathVariable Integer id) {
        LinkRequestDto link = linkService.getById(id);
        return new ResponseEntity<>(link, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LinkRequestDto> update(@PathVariable Integer id, @RequestBody Link link) {
        LinkRequestDto updatedLink = linkService.update(id, link);
        return new ResponseEntity<>(updatedLink, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        linkService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

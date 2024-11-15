package powerup.v1.gateways;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import powerup.v1.dtos.request.EmblemaConfigDto;
import powerup.v1.entities.EmblemaConfig;
import powerup.v1.usecases.EmblemaConfigService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/powerup/emblemaConfig/")
@Tag(name = "Emblema Config", description = "Endpoints destinados para a classe Emblema Config")
public class EmblemaConfigController {

    private final EmblemaConfigService emblemaConfigService;

    @PostMapping
    public ResponseEntity<EmblemaConfigDto> create(@RequestBody EmblemaConfig emblemaConfig) {
        EmblemaConfigDto createdEmblemaConfig = emblemaConfigService.create(emblemaConfig);
        return new ResponseEntity<>(createdEmblemaConfig, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<EmblemaConfigDto>> getAll() {
        List<EmblemaConfigDto> emblemaConfigList = emblemaConfigService.getAll();
        return new ResponseEntity<>(emblemaConfigList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmblemaConfigDto> getById(@PathVariable Integer id) {
        EmblemaConfigDto emblemaConfig = emblemaConfigService.getById(id);
        return new ResponseEntity<>(emblemaConfig, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmblemaConfigDto> update(@PathVariable Integer id, @RequestBody EmblemaConfig emblemaConfig) {
        EmblemaConfigDto updatedEmblemaConfig = emblemaConfigService.update(id, emblemaConfig);
        return new ResponseEntity<>(updatedEmblemaConfig, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        emblemaConfigService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

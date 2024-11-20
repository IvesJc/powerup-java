package powerup.v1.gateways;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import powerup.v1.dtos.request.EmblemaConfigRequestDto;
import powerup.v1.dtos.response.EmblemaConfigResponseDto;
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
    public ResponseEntity<EmblemaConfigRequestDto> create(@RequestBody EmblemaConfigResponseDto emblemaConfig) {
        EmblemaConfigRequestDto createdEmblemaConfig = emblemaConfigService.create(emblemaConfig);
        return new ResponseEntity<>(createdEmblemaConfig, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<EmblemaConfigRequestDto>> getAll() {
        List<EmblemaConfigRequestDto> emblemaConfigList = emblemaConfigService.getAll();
        return new ResponseEntity<>(emblemaConfigList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmblemaConfigRequestDto> getById(@PathVariable Integer id) {
        EmblemaConfigRequestDto emblemaConfig = emblemaConfigService.getById(id);
        return new ResponseEntity<>(emblemaConfig, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmblemaConfigRequestDto> update(@PathVariable Integer id, @RequestBody EmblemaConfigResponseDto emblemaConfig) {
        EmblemaConfigRequestDto updatedEmblemaConfig = emblemaConfigService.update(id, emblemaConfig);
        return new ResponseEntity<>(updatedEmblemaConfig, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        emblemaConfigService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

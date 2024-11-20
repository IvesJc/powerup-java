package powerup.v1.gateways;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import powerup.v1.dtos.request.ArtigoRequestDto;
import powerup.v1.dtos.response.ArtigoResponseDto;
import powerup.v1.entities.Artigo;
import powerup.v1.usecases.ArtigoService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/powerup/artigo/")
@Tag(name = "Artigo", description = "Endpoints destinados para a classe Artigo")
public class ArtigoController {

    private final ArtigoService artigoService;
    // Endpoint para criar um artigo
    @PostMapping
    public ResponseEntity<ArtigoRequestDto> create(@RequestBody ArtigoResponseDto artigo) {
        ArtigoRequestDto createdArtigo = artigoService.create(artigo);
        return new ResponseEntity<>(createdArtigo, HttpStatus.CREATED);
    }

    // Endpoint para obter todos os artigos
    @GetMapping
    public ResponseEntity<List<ArtigoRequestDto>> getAll() {
        List<ArtigoRequestDto> artigoList = artigoService.getAll();
        return new ResponseEntity<>(artigoList, HttpStatus.OK);
    }

    // Endpoint para obter um artigo por ID
    @GetMapping("/{id}")
    public ResponseEntity<ArtigoRequestDto> getById(@PathVariable Integer id) {
        ArtigoRequestDto artigo = artigoService.getById(id);
        return new ResponseEntity<>(artigo, HttpStatus.OK);
    }

    // Endpoint para atualizar um artigo
    @PutMapping("/{id}")
    public ResponseEntity<ArtigoRequestDto> update(@PathVariable Integer id, @RequestBody ArtigoResponseDto artigo) {
        ArtigoRequestDto updatedArtigo = artigoService.update(id, artigo);
        return new ResponseEntity<>(updatedArtigo, HttpStatus.OK);
    }

    // Endpoint para deletar um artigo
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        artigoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

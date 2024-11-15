package powerup.v1.gateways;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import powerup.v1.dtos.request.ArtigoDto;
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
    public ResponseEntity<ArtigoDto> create(@RequestBody Artigo artigo) {
        ArtigoDto createdArtigo = artigoService.create(artigo);
        return new ResponseEntity<>(createdArtigo, HttpStatus.CREATED);
    }

    // Endpoint para obter todos os artigos
    @GetMapping
    public ResponseEntity<List<ArtigoDto>> getAll() {
        List<ArtigoDto> artigoList = artigoService.getAll();
        return new ResponseEntity<>(artigoList, HttpStatus.OK);
    }

    // Endpoint para obter um artigo por ID
    @GetMapping("/{id}")
    public ResponseEntity<ArtigoDto> getById(@PathVariable Integer id) {
        ArtigoDto artigo = artigoService.getById(id);
        return new ResponseEntity<>(artigo, HttpStatus.OK);
    }

    // Endpoint para atualizar um artigo
    @PutMapping("/{id}")
    public ResponseEntity<ArtigoDto> update(@PathVariable Integer id, @RequestBody Artigo artigo) {
        ArtigoDto updatedArtigo = artigoService.update(id, artigo);
        return new ResponseEntity<>(updatedArtigo, HttpStatus.OK);
    }

    // Endpoint para deletar um artigo
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        artigoService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

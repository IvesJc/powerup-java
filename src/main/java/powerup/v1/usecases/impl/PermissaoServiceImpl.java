package powerup.v1.usecases.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import powerup.v1.dtos.request.PermissaoRequestDto;
import powerup.v1.entities.Permissao;
import powerup.v1.repositories.PermissaoRepository;
import powerup.v1.usecases.PermissaoService;
import powerup.v1.usecases.exception.IdNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PermissaoServiceImpl implements PermissaoService {
    private final PermissaoRepository permissaoRepository;

    @Override
    public PermissaoRequestDto create(Permissao permissao) {
        Permissao savedEntity = permissaoRepository.save(permissao);
        return mapToDTO(savedEntity);
    }

    @Override
    public List<PermissaoRequestDto> getAll() {
        return permissaoRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PermissaoRequestDto getById(Integer id) {
        return permissaoRepository.findById(id)
                .map(this::mapToDTO)
                .orElseThrow(() -> new IdNotFoundException("Permissao not found with id: " + id));
    }

    @Override
    public PermissaoRequestDto update(Integer id, Permissao permissao) {
        if (!permissaoRepository.existsById(id)) {
            throw new IdNotFoundException("Permissao not found with id: " + id);
        }
        permissao.setId(id);
        Permissao updatedEntity = permissaoRepository.save(permissao);
        return mapToDTO(updatedEntity);
    }

    @Override
    public void delete(Integer id) {
        if (!permissaoRepository.existsById(id)) {
            throw new IdNotFoundException("Permissao not found with id: " + id);
        }
        permissaoRepository.deleteById(id);
    }

    private PermissaoRequestDto mapToDTO(Permissao permissao) {
        return PermissaoRequestDto.builder()
                .id(permissao.getId())
                .nome(permissao.getNome())
                .descricao(permissao.getDescricao())
                .build();
    }
}


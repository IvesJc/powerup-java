package powerup.v1.usecases.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import powerup.v1.dtos.request.MissaoRequestDto;
import powerup.v1.entities.Missao;
import powerup.v1.repositories.MissaoRepository;
import powerup.v1.usecases.MissaoService;
import powerup.v1.usecases.exception.IdNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MissaoServiceImpl implements MissaoService {
    private final MissaoRepository missaoRepository;

    @Override
    public MissaoRequestDto create(Missao missao) {
        Missao savedEntity = missaoRepository.save(missao);
        return mapToDTO(savedEntity);
    }

    @Override
    public List<MissaoRequestDto> getAll() {
        return missaoRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public MissaoRequestDto getById(Integer id) {
        return missaoRepository.findById(id)
                .map(this::mapToDTO)
                .orElseThrow(() -> new IdNotFoundException("Missao not found with id: " + id));
    }

    @Override
    public MissaoRequestDto update(Integer id, Missao missao) {
        if (!missaoRepository.existsById(id)) {
            throw new IdNotFoundException("Missao not found with id: " + id);
        }
        missao.setId(id);
        Missao updatedEntity = missaoRepository.save(missao);
        return mapToDTO(updatedEntity);
    }

    @Override
    public void delete(Integer id) {
        if (!missaoRepository.existsById(id)) {
            throw new IdNotFoundException("Missao not found with id: " + id);
        }
        missaoRepository.deleteById(id);
    }

    private MissaoRequestDto mapToDTO(Missao missao) {
        return MissaoRequestDto.builder()
                .id(missao.getId())
                .recompensaPontos(missao.getRecompensaPontos())
                .status(missao.getStatus())
                .missaoConfig(missao.getMissaoConfig().getId())
                .usuario(missao.getUsuario().getId())
                .build();
    }
}


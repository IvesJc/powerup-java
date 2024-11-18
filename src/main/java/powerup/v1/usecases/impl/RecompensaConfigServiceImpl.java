package powerup.v1.usecases.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import powerup.v1.dtos.request.RecompensaConfigRequestDto;
import powerup.v1.dtos.response.RecompensaConfigResponseDto;
import powerup.v1.entities.RecompensaConfig;
import powerup.v1.entities.RecompensaTipo;
import powerup.v1.repositories.RecompensaConfigRepository;
import powerup.v1.repositories.RecompensaTipoRepository;
import powerup.v1.usecases.RecompensaConfigService;
import powerup.v1.usecases.exception.IdNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RecompensaConfigServiceImpl implements RecompensaConfigService {
    private final RecompensaConfigRepository recompensaConfigRepository;
    private final RecompensaTipoRepository recompensaTipoRepository;

    @Override
    public RecompensaConfigRequestDto create(RecompensaConfigResponseDto recompensaConfig) {

        RecompensaTipo recompensaTipo = recompensaTipoRepository.findById(recompensaConfig.recompensaTipo()).orElseThrow(() -> new IdNotFoundException("Ranking not found"));

        RecompensaConfig savedEntity = RecompensaConfig.builder()
                .nome(recompensaConfig.nome())
                .custoPontos(recompensaConfig.custoPontos())
                .recompensaTipo(recompensaTipo).build();
        recompensaConfigRepository.save(savedEntity);
        return mapToDTO(savedEntity);
    }

    @Override
    public List<RecompensaConfigRequestDto> getAll() {
        return recompensaConfigRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public RecompensaConfigRequestDto getById(Integer id) {
        return recompensaConfigRepository.findById(id)
                .map(this::mapToDTO)
                .orElseThrow(() -> new IdNotFoundException("RecompensaConfig not found with id: " + id));
    }

    @Override
    public RecompensaConfigRequestDto update(Integer id, RecompensaConfigResponseDto recompensaConfig) {

        RecompensaTipo recompensaTipo = recompensaTipoRepository.findById(recompensaConfig.recompensaTipo()).orElseThrow(() -> new IdNotFoundException("Ranking not found"));

        RecompensaConfig updateRecompensaConfig = recompensaConfigRepository.findById(id).orElseThrow(() -> new IdNotFoundException("Recompensa Config not found with this id: "+id));

        updateRecompensaConfig.setNome(recompensaConfig.nome());
        updateRecompensaConfig.setCustoPontos(recompensaConfig.custoPontos());
        updateRecompensaConfig.setRecompensaTipo(recompensaTipo);

        recompensaConfigRepository.save(updateRecompensaConfig);
        return mapToDTO(updateRecompensaConfig);
    }

    @Override
    public void delete(Integer id) {
        if (!recompensaConfigRepository.existsById(id)) {
            throw new IdNotFoundException("RecompensaConfig not found with id: " + id);
        }
        recompensaConfigRepository.deleteById(id);
    }

    private RecompensaConfigRequestDto mapToDTO(RecompensaConfig recompensaConfig) {
        return RecompensaConfigRequestDto.builder()
                .id(recompensaConfig.getId())
                .nome(recompensaConfig.getNome())
                .custoPontos(recompensaConfig.getCustoPontos())
                .recompensaTipo(recompensaConfig.getRecompensaTipo().getId())
                .build();
    }
}



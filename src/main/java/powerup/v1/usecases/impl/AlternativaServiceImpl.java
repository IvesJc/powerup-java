package powerup.v1.usecases.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import powerup.v1.dtos.request.AlternativaRequestDto;
import powerup.v1.dtos.response.AlternativaResponseDto;
import powerup.v1.entities.Alternativa;
import powerup.v1.repositories.AlternativaRepository;
import powerup.v1.usecases.AlternativaService;
import powerup.v1.usecases.exception.IdNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AlternativaServiceImpl implements AlternativaService {
    private final AlternativaRepository alternativaRepository;

    @Override
    public AlternativaRequestDto create(AlternativaResponseDto alternativa) {
        // TODO: RESPONSE DTO
        Alternativa newAlternativa = new Alternativa();
        newAlternativa.setDescricao(alternativa.descricao());
        newAlternativa.setPergunta(alternativa.pergunta());
        AlternativaResponseDto.builder().descricao(newAlternativa.getDescricao()).eCorreta(newAlternativa.getECorreta()).pergunta(newAlternativa.getPergunta().getId()).build();
        Alternativa savedEntity = alternativaRepository.save(alternativa);
        return mapToDTO(savedEntity);
    }

    @Override
    public List<AlternativaRequestDto> getAll() {
        return alternativaRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public AlternativaRequestDto getById(Integer id) {
        return alternativaRepository.findById(id)
                .map(this::mapToDTO)
                .orElseThrow(() -> new IdNotFoundException("Alternativa not found with id: " + id));
    }

    @Override
    public AlternativaRequestDto update(Integer id, AlternativaResponseDto alternativa) {
        if (!alternativaRepository.existsById(id)) {
            throw new IdNotFoundException("Alternativa not found with id: " + id);
        }
        alternativa.setId(id);
        Alternativa updatedEntity = alternativaRepository.save(alternativa);
        return mapToDTO(updatedEntity);
    }

    @Override
    public void delete(Integer id) {
        if (!alternativaRepository.existsById(id)) {
            throw new IdNotFoundException("Alternativa not found with id: " + id);
        }
        alternativaRepository.deleteById(id);
    }

    private AlternativaRequestDto mapToDTO(Alternativa alternativa) {
        return AlternativaRequestDto.builder()
                .id(alternativa.getId())
                .pergunta(alternativa.getPergunta().getId())
                .descricao(alternativa.getDescricao())
                .eCorreta(alternativa.getECorreta())
                .build();
    }
}

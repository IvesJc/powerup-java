package powerup.v1.usecases.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import powerup.v1.dtos.request.AlternativaRequestDto;
import powerup.v1.dtos.response.AlternativaResponseDto;
import powerup.v1.entities.Alternativa;
import powerup.v1.entities.Pergunta;
import powerup.v1.repositories.AlternativaRepository;
import powerup.v1.repositories.PerguntaRepository;
import powerup.v1.usecases.AlternativaService;
import powerup.v1.usecases.exception.IdNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AlternativaServiceImpl implements AlternativaService {
    private final AlternativaRepository alternativaRepository;
    private final PerguntaRepository perguntaRepository;

    @Override
    public AlternativaRequestDto create(AlternativaResponseDto alternativaResponseDto) {

        Pergunta pergunta = perguntaRepository.findById(alternativaResponseDto.pergunta())
                .orElseThrow(() -> new IdNotFoundException("Pergunta não encontrada com ID: " + alternativaResponseDto.pergunta()));

        Alternativa newAlternativa = Alternativa.builder()
                .descricao(alternativaResponseDto.descricao())
                .eCorreta(alternativaResponseDto.eCorreta())
                .pergunta(pergunta)
                .build();

        alternativaRepository.save(newAlternativa);
        return mapToDTO(newAlternativa);
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
    public AlternativaRequestDto update(Integer id, AlternativaResponseDto alternativaResponseDto) {
        Alternativa alternativaUpdate = alternativaRepository.findById(id).orElseThrow(() -> new IdNotFoundException("Alternativa not found with id: " + id));

        Pergunta pergunta = perguntaRepository.findById(alternativaResponseDto.pergunta())
                .orElseThrow(() -> new IdNotFoundException("Pergunta não encontrada com ID: " + alternativaResponseDto.pergunta()));

        alternativaUpdate.setDescricao(alternativaResponseDto.descricao());
        alternativaUpdate.setECorreta(alternativaResponseDto.eCorreta());
        alternativaUpdate.setPergunta(pergunta);

        alternativaRepository.save(alternativaUpdate);

        return mapToDTO(alternativaUpdate);
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

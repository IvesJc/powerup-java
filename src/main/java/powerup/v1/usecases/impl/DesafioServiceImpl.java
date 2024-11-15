package powerup.v1.usecases.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import powerup.v1.dtos.request.DesafioDto;
import powerup.v1.entities.Desafio;
import powerup.v1.repositories.DesafioRepository;
import powerup.v1.usecases.DesafioService;
import powerup.v1.usecases.exception.IdNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DesafioServiceImpl implements DesafioService {
    private final DesafioRepository desafioRepository;

    @Override
    public DesafioDto create(Desafio desafio) {
        Desafio savedEntity = desafioRepository.save(desafio);
        return mapToDTO(savedEntity);
    }

    @Override
    public List<DesafioDto> getAll() {
        return desafioRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public DesafioDto getById(Integer id) {
        return desafioRepository.findById(id)
                .map(this::mapToDTO)
                .orElseThrow(() -> new IdNotFoundException("Desafio not found with id: " + id));
    }

    @Override
    public DesafioDto update(Integer id, Desafio desafio) {
        if (!desafioRepository.existsById(id)) {
            throw new IdNotFoundException("Desafio not found with id: " + id);
        }
        desafio.setId(id);
        Desafio updatedEntity = desafioRepository.save(desafio);
        return mapToDTO(updatedEntity);
    }

    @Override
    public void delete(Integer id) {
        if (!desafioRepository.existsById(id)) {
            throw new IdNotFoundException("Desafio not found with id: " + id);
        }
        desafioRepository.deleteById(id);
    }

    private DesafioDto mapToDTO(Desafio desafio) {
        return DesafioDto.builder()
                .id(desafio.getId())
                .nome(desafio.getNome())
                .descricao(desafio.getDescricao())
                .thumbLink(desafio.getThumbLink().getId())
                .quiz(desafio.getQuiz().getId())
                .build();
    }
}



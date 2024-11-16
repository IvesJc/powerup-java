package powerup.v1.dtos.response;

import lombok.Builder;

@Builder
public record AlternativaResponseDto(
        String descricao,
        Boolean eCorreta,
        Integer pergunta
) {
}

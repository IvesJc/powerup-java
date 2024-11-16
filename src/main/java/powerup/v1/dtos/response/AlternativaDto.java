package powerup.v1.dtos.response;

import lombok.Builder;

@Builder
public record AlternativaDto(
        Integer id,
        String descricao,
        // TODO: REVIEW
        Boolean eCorreta,
        Integer pergunta
) {
}

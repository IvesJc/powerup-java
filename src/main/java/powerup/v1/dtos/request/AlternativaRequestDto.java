package powerup.v1.dtos.request;

import lombok.Builder;

@Builder
public record AlternativaRequestDto(
        Integer id,
        String descricao,
        // TODO: REVIEW
        Boolean eCorreta,
        Integer pergunta
) {
}

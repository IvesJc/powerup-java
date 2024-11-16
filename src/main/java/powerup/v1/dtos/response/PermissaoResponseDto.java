package powerup.v1.dtos.response;

import lombok.Builder;

@Builder
public record PermissaoResponseDto(
        String nome,
        String descricao
) {
}

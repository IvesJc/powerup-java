package powerup.v1.dtos.response;

import lombok.Builder;

@Builder
public record RecompensaTipoResponseDto(
        String nome,
        String descricao
) {
}

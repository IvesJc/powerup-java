package powerup.v1.dtos.request;

import lombok.Builder;

@Builder
public record RecompensaTipoRequestDto(
        Integer id,
        String nome,
        String descricao
) {
}

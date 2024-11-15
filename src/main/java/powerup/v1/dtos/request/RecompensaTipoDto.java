package powerup.v1.dtos.request;

import lombok.Builder;

@Builder
public record RecompensaTipoDto(
        Integer id,
        String nome,
        String descricao
) {
}

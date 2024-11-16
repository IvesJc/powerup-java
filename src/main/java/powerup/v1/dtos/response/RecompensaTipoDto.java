package powerup.v1.dtos.response;

import lombok.Builder;

@Builder
public record RecompensaTipoDto(
        Integer id,
        String nome,
        String descricao
) {
}

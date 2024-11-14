package powerup.v1.dtos;

import java.util.List;

public record MissaoDto(
        int recompensaPontos,
        String status,
        Long missaoConfigId,
        Long usuarioId,
        List<Long> artigoIds,
        List<Long> moduloEducativoIds
) {
}

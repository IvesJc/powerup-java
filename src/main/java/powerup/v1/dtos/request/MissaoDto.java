package powerup.v1.dtos.request;

public record MissaoDto(
        Integer id,
        Integer recompensaPontos,
        String status,
        MissaoConfigDto missaoConfig,
        UsuarioDto usuario
) {
}

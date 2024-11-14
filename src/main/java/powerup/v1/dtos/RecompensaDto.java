package powerup.v1.dtos;

public record RecompensaDto(
        int pontosUtilizados,
        Long usuarioId,
        Long recompensaConfigId
) {
}

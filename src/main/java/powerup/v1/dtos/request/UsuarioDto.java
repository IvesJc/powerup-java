package powerup.v1.dtos.request;

public record UsuarioDto(
        Integer id,
        String firebaseUid,
        String email,
        String nome,
        RankingDto ranking
) {
}

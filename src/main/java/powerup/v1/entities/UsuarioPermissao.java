package powerup.v1.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "usuario_permissao")
public class UsuarioPermissao {

    @EmbeddedId
    private UsuarioPermissaoId id;

    @ManyToOne
    @MapsId("usuarioId")
    @JoinColumn(name = "USUARIO_ID", referencedColumnName = "id")
    private Usuario usuarioId;

    @ManyToOne
    @MapsId("permissaoId")
    @JoinColumn(name = "PERMISSAO_ID", referencedColumnName = "id")
    private Permissao permissaoId;
}

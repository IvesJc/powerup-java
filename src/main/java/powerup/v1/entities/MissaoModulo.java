package powerup.v1.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "missao_modulo")
public class MissaoModulo {

    @EmbeddedId
    private MissaoModuloId id;

    @ManyToOne
    @MapsId("missaoId")
    @JoinColumn(name = "MISSAO_ID", referencedColumnName = "id")
    private Missao missaoId;

    @ManyToOne
    @MapsId("moduloEducativoId")
    @JoinColumn(name = "MODULO_EDUCATIVO_ID", referencedColumnName = "id")
    private ModuloEducativo moduloEducativoId;
}

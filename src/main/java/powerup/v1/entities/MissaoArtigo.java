package powerup.v1.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "missao_artigo")
public class MissaoArtigo {

    @EmbeddedId
    private MissaoArtigoId id;

    @ManyToOne
    @MapsId("missaoId")
    @JoinColumn(name = "MISSAO_ID", referencedColumnName = "id")
    private Missao missaoId;

    @ManyToOne
    @MapsId("artigoId")
    @JoinColumn(name = "ARTIGO_ID", referencedColumnName = "id")
    private Artigo artigoId;
}

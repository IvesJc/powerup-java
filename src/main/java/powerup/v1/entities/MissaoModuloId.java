package powerup.v1.entities;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MissaoModuloId {

    private Integer missaoId;
    private Integer moduloEducativoId;
}

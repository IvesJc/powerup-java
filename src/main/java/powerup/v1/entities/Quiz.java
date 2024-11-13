package powerup.v1.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descricao;
    private String categoria;

    @ManyToOne
    @JoinColumn(name = "emblema_config_id")
    private EmblemaConfig emblemaConfig;

    private Integer notaMinima;

    @ManyToOne
    @JoinColumn(name = "modulo_educativo_id")
    private ModuloEducativo moduloEducativo;
}

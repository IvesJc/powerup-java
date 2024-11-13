package powerup.v1.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Missao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer recompensaPontos;
    private String status;

    @ManyToOne
    @JoinColumn(name = "missao_config_id")
    private MissaoConfig missaoConfig;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToMany
    @JoinTable(
            name = "missao_artigo",
            joinColumns = @JoinColumn(name = "missao_id"),
            inverseJoinColumns = @JoinColumn(name = "artigo_id"))
    private List<Artigo> artigos;

    @ManyToMany
    @JoinTable(
            name = "missao_modulo",
            joinColumns = @JoinColumn(name = "missao_id"),
            inverseJoinColumns = @JoinColumn(name = "modulo_educativo_id"))
    private List<ModuloEducativo> modulosEducativos;
}

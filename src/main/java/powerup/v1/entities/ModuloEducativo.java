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
public class ModuloEducativo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String subtitulo;
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "thumb_link_id")
    private Link thumbLink;

    private Integer nivel;

    @ManyToMany
    @JoinTable(
            name = "modulo_artigo",
            joinColumns = @JoinColumn(name = "modulo_educativo_id"),
            inverseJoinColumns = @JoinColumn(name = "artigo_id"))
    private List<Artigo> artigos;
}

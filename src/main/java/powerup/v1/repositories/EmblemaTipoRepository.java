package powerup.v1.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import powerup.v1.entities.EmblemaTipo;
import powerup.v1.entities.Usuario;

@Repository
public interface EmblemaTipoRepository extends JpaRepository<EmblemaTipo, Long> {
}


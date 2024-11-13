package powerup.v1.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import powerup.v1.entities.EmblemaConfig;
import powerup.v1.entities.EmblemaTipo;

@Repository
public interface EmblemaConfigRepository extends JpaRepository<EmblemaConfig, Long> {
}


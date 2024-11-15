package powerup.v1.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import powerup.v1.entities.Emblema;
import powerup.v1.entities.Missao;

@Repository
public interface EmblemaRepository extends JpaRepository<Emblema, Integer> {
}


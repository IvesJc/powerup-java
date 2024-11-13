package powerup.v1.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import powerup.v1.entities.Alternativa;
import powerup.v1.entities.Artigo;

@Repository
public interface ArtigoRepository extends JpaRepository<Artigo, Long> {
}


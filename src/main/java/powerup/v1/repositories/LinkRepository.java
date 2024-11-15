package powerup.v1.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import powerup.v1.entities.Link;
import powerup.v1.entities.Ranking;

@Repository
public interface LinkRepository extends JpaRepository<Link, Integer> {
}


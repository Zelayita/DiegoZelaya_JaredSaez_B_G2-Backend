package DiegoZelaya_JaredSaez_B_G2.DiegoZelaya_JaredSaez_B_G2.Repository;

import DiegoZelaya_JaredSaez_B_G2.DiegoZelaya_JaredSaez_B_G2.Entity.EntityPeliculas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryPelicula extends JpaRepository<EntityPeliculas, Long> {
}

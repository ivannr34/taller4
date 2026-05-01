package pa.actividad.repository;

import pa.actividad.modelo.Actividad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Acceso a base de datos
 */
@Repository
public interface ActividadRepository extends JpaRepository<Actividad, Long> {
}
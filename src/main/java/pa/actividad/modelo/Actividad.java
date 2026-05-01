package pa.actividad.modelo;
import jakarta.persistence.*;
import java.time.LocalDate;
import lombok.Data;

@Data
@Table(name = "actividad")
@Entity
public class Actividad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String descripcion;

    @Column(name = "fecha_inicio")
    private LocalDate fechaInicio;

    @Column(name = "fecha_fin")
    private LocalDate fechaFin;

    private String tipo;

    @Column(name = "id_quehacer")
    private Long idQuehacer;

    @Column(name = "id_tutor")
    private Long idTutor;

    @Column(name = "id_hijo")
    private Long idHijo;
}
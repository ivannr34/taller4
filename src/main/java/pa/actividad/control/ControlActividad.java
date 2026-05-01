package pa.actividad.control;

import pa.actividad.modelo.Actividad;
import pa.actividad.service.ActividadService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST
 */
@RestController
@RequestMapping("/api/actividad")
@CrossOrigin(origins = "*") // CORS
public class ControlActividad {

    private final ActividadService service;

    public ControlActividad(ActividadService service) {
        this.service = service;
    }

    @PostMapping
    public Actividad crear(@RequestBody Actividad actividad) {
        return service.crearActividad(actividad);
    }

    @GetMapping
    public List<Actividad> listar() {
        return service.obtenerTodas();
    }

    @GetMapping("/{id}")
    public Actividad obtener(@PathVariable Long id) {
        return service.obtenerPorId(id)
                .orElseThrow(() -> new RuntimeException("No encontrada"));
    }

    @PutMapping("/{id}")
    public Actividad actualizar(@PathVariable Long id, @RequestBody Actividad actividad) {
        return service.actualizar(id, actividad);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}